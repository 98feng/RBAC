package com.bjpowernode.jdbc001.util;

import java.lang.reflect.Field;

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

    public String createInsertSql(Object object) throws Exception {

        String tableName = null;
        Field[] fieldArray = null;
        Class classManager = object.getClass();

        StringBuffer columns = new StringBuffer(" (");
        StringBuffer sql = new StringBuffer("insert into ");
        StringBuffer values = new StringBuffer(" values(");

        //1.得到插入语句关联的表名
        tableName = classManager.getSimpleName();

        //2、获取属性类型
        fieldArray = classManager.getDeclaredFields();
        for (int i = 0; i < fieldArray.length; i++) {
            if (i != 0) {
                columns.append(",");
            }
            columns.append(fieldArray[i].getName());
        }
        columns.append(")");

        //3、获取属性值
        for (int i = 0; i < fieldArray.length; i++) {
            if (i != 0) {
                values.append(",");
            }
            fieldArray[i].setAccessible(true);
            values.append("'").append(fieldArray[i].get(object)).append("'");
        }
        values.append(")");

        //4、拼接
        sql.append(tableName);
        sql.append(columns);
        sql.append(values);

        return sql.toString();
    }
}
