package com.bjpowernode.jdbc002.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 动力节点
 * 2021/1/23
 */
public class ReflectUtil {

    /*
     *  作用：动态生成INSERT语句
     *
     *  insert语句结构:
     *
     *  insert into  表    (字段名1，字段名2,字段名3) values(值1，值2)
     *  -----------  --    ---------------        ---------------
     *       1        2           3                     4
     *
     *   问题1：如何能够得到表名
     *         实体类的类名应该与对应的表名相同
     *
     *   问题2：如何得到表中字段名
     *         实体类的属性名应该与对应的表中字段名相同
     *
     *   问题3：如何得到要插入的数据行
     *         一个实体类的实例对象封装表文件中一个数据行
     */

    public String  createInsertSql(Object instance)throws Exception{

        String tableName = null;
        Class classManager = null;
        Field fieldArray[]=null;
        StringBuffer columns = new StringBuffer(" (");
        StringBuffer sql = new StringBuffer("insert into ");
        StringBuffer values = new StringBuffer(" values(");

        classManager= instance.getClass(); //得到实例对象，隶属的类文件的管理者
        fieldArray = classManager.getDeclaredFields();
        //1.得到插入语句关联的表名
        tableName = classManager.getSimpleName();

        //2.得到插入语句关联的字段名
        for(Field field:fieldArray){

            String fieldName = field.getName();//得到管理的属性的名称，这个名称就是字段名
            if(!columns.toString().equals(" (")){
                columns.append(",");
            }
            columns.append(fieldName);
        }
        columns.append(")");

        //3.得到插入语句对应的值
        for(Field field:fieldArray){
            field.setAccessible(true);
            Object value = field.get(instance);
            //如果添加的值不是第一个值，则在值添加的到StringBuffer之前，先添加一个","进入到StringBuffer
            if(!values.toString().equals(" values(")){
                values.append(",");
            }
            values.append("'");
            values.append(value);
            values.append("'");
        }
        values.append(")");

        //拼接
        sql.append(tableName);
        sql.append(columns);
        sql.append(values);

        return sql.toString();
    }

    /*
     * 作用:生成动态UPDATE
     *
     * UPDATE语句结构:
     *    UPDATE  表名  SET 非主键字段1=值1,非主键字段2=值2 WHERE 主键字段名=主键值
     *    -----   ---  ------------------------------- --------------------
     *       1     2              3                            4
     *
     *   问题1.如何得到更新的表名:
     *
     *        实体类的类名必须与表名相同
     *
     *   问题2：如何得到非主键字段名和更新内容
     *
     *        实体类中属性名就是表中字段名
     *        实体类的一个实例对象表示表中一行数据
     *
     *   问题3：如何区分主键字段与非主键字段
     *
     *         通过参数来指定主键字段对应的属性名
     *
     *   参数介绍:
     *
     *          Object instance: 本次操作的表文件对应一个实体类的实例对象
     *                           比如本次操作dept，那么就传入一个Dept类型的实例
     *                           对象。这个对象存放更新的内容
     *
     *          String primaryKey: 用于指定表文件中主键字段名(不考虑大小写)
     */

    public String createUpdateSql(Object instance,String primaryKey)throws Exception{
        String tableName = null;
        StringBuffer set = new StringBuffer(" SET ");
        StringBuffer where = null;
        StringBuffer sql = new StringBuffer("UPDATE ");
        Class classManager = null;
        Field fieldArray[]=null;


        classManager = instance.getClass();//获得当前实例对象隶属的类型文件的管理者
        fieldArray =classManager.getDeclaredFields();
        //1.得到需要处理的表文件名
        tableName = classManager.getSimpleName();

        //2.设置需要更新的非主键字段 以及用于定位数据行主键字段
        for(Field field : fieldArray){

            String fieldName = field.getName();//可能是非主键字段，也可能是主键字段
            field.setAccessible(true);
            Object value = field.get(instance);

            if(value!=null){
                if(!fieldName.equalsIgnoreCase(primaryKey)){

                    if(!set.toString().equals(" SET ")){
                        set.append(",");
                    }
                    set.append(fieldName);
                    set.append("=");
                    set.append("'");
                    set.append(value);
                    set.append("'"); // 字段名='新值'
                }else{
                    where =  new StringBuffer(" WHERE ");
                    where.append(fieldName);
                    where.append("=");
                    where.append("'");
                    where.append(value);
                    where.append("'");
                }
            }
        }
        //拼接SQL
        sql.append(tableName);
        sql.append(set);
        if(where!=null) {
            sql.append(where);
        }

        return sql.toString();
    }


    /*
     * 功能：自动将临时表数据行转为对应的实体类的实例对象
     *
     *    Dept临时表----------------------------Dept.class
     * deptNo   dname   loc
     *  10      部门1    上海             Dept d1 = new Dept(10,"部门1","loc")
     *  20      部门2    北京
     *
     *  1.如何定位临时表关联实体类
     *
     *      com.bjpowernode.entity.Dept
     *      com.bjpowernode.test.Dept
     *      将当前实体类管理者作为参数传入
     *
     *  2.如何将数据行字段内容赋值给实例对象同名属性
     *
     *    MySql服务器中所有的字段名都是大写的  DEPTNO
     *    实体类中属性名按照"驼峰规则"        deptNo
     *    "DEPTNO".equalsIgnoreCase("deptNo")
     */

    public List converData(ResultSet table,Class classManager)throws Exception{
        Field fieldArray[]=null;
        ResultSetMetaData rsmd=null;
        List list = new ArrayList();

        //1.需要得到实体类的所有属性的管理者
        fieldArray =classManager.getDeclaredFields();
        //2.需要得到临时表所有字段信息
        rsmd =table.getMetaData();
        //3.循环遍历临时表，每次循环时将一行数据赋值到对应的一个实体类的实例对象
        while(table.next()){
            //3.1.每次循环时得到一行数据,此时通知JVM调用当前类的[无参构造方法]创建当前类一个实例对象
            Object instance= classManager.newInstance();//假设classManager管理Dept.class,此处  Dept dept=new Dept();
            //3.2 将当前数据行字段值读取出来赋值给实例对象中同名属性
            for(int i=1;i<=rsmd.getColumnCount();i++){ //这个for循环执行结束后，意味着一行数据所有字段被遍历完毕
                //3.2.1 每次执行时读取当前数据行一个字段名称
                String columnName = rsmd.getColumnName(i); // 当前数据行 "DEPTNO"
                //3.2.2 读取当前数据行中指定的字段的值
                String value = table.getString(columnName);// 当前数据行"DEPTNO"字段的值 "30"
                //3.2.3 定位与当前字段名相同的同名属性,将字段中值赋值给实例对象中同名属性
                for(int j=0;j<fieldArray.length;j++){
                    Field field = fieldArray[j]; // private Integer deptNo
                    String typeName =field.getType().getSimpleName();//通过属性管理者获得其管理的属性的数据类型名称 "Integer"
                    //3.2.3.1 定位到同名属性之后，根据数据的数据类型名称将字段内容进行类型转换并赋值
                    if(field.getName().equalsIgnoreCase(columnName)){
                        field.setAccessible(true);
                        if("Integer".equalsIgnoreCase(typeName)){
                            field.set(instance, Integer.valueOf(value));
                        }else if("Double".equalsIgnoreCase(typeName)){
                            field.set(instance, Double.valueOf(value));
                        }else if("String".equalsIgnoreCase(typeName)){
                            field.set(instance, value);
                        }
                        break;
                    }
                }
            }
            //3.3.将赋值好的实例对象添加到List集合中存储
            list.add(instance);
        }

        return list;
    }



















}
