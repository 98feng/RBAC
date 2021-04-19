package com.bjpowernode.demo01.utils;

import java.lang.reflect.Field;

/**
 * @author feng
 * @date 2021/1/23
 * @Description 封装动态SQL语句
 */
@SuppressWarnings("unchecked")
public class ReflectUtil {

    /**
     * insert into dept(deptno,dname,loc) values(?,?,?)
     */
    public static String createInsertSql(Object object) {

        String tableName = null;
        Field[] fieldArray = null;
        Class<?> classManager = object.getClass();

        StringBuilder columns = new StringBuilder(" (");
        StringBuilder sql = new StringBuilder("insert into ");
        StringBuilder values = new StringBuilder(" values(");

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
            try {
                values.append("'").append(fieldArray[i].get(object)).append("'");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        values.append(")");

        //4、拼接
        sql.append(tableName);
        sql.append(columns);
        sql.append(values);

        return sql.toString();
    }

    /**
     * update dept set dname = ? ,loc = ? where deptno = ?
     */
    public static String updateSql(Object object) {
        Class<?> classManager = object.getClass();
        String simpleName = classManager.getSimpleName();
        StringBuilder filedName = new StringBuilder();
        StringBuilder sql = new StringBuilder("update ");
        sql.append(simpleName).append(" set ");

        Field[] fields = classManager.getDeclaredFields();
        String strId = null;
        try {
            for (int i = 1; i < fields.length; i++) {
                fields[i].setAccessible(true);
                if (fields[i].get(object) != null) {

                    if (!"".equals(filedName.toString())) {
                        filedName.append(",");
                    }
                    filedName.append(fields[i].getName()).append(" = ");
                    fields[i].setAccessible(true);
                    filedName.append("'").append(fields[i].get(object)).append("'");
                }

            }
            //获取id值
            fields[0].setAccessible(true);
            strId = null;
            strId = fields[0].get(object).toString();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        int id = Integer.parseInt(strId);

        sql.append(filedName).append(" where ").append(fields[0].getName()).append(" = ").append(id);
        return sql.toString();
    }


    /**
     * String sql = "delete from dept where deptno = ?
     */
    public static String delectByIdSql(Object object, Integer primaryKey) {
        Class<?> classManager = object.getClass();

        return "delete  from " + classManager.getSimpleName() + " where " + classManager.getDeclaredFields()[0].getName() + " = " + primaryKey;
    }

    /**
     * select deptno,dname,loc from dept where deptno = ?
     */
    public static String getDeptByIdSql(Object object, Integer deptno) {
        Class<?> classManager = object.getClass();
        String simpleName = classManager.getSimpleName();
        StringBuilder sql = new StringBuilder("select ");
        Field[] fields = classManager.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (i != 0) {
                sql.append(",");
            }
            sql.append(fields[i].getName());
        }
        sql.append(" from ").append(simpleName).append(" where ").append(fields[0].getName()).append(" = ").append(deptno);
        return sql.toString();
    }

    /**
     * select deptno,dname,loc from dept
     */
    public static String getAllSql(Object object) {
        Class<?> classManager = object.getClass();
        String simpleName = classManager.getSimpleName();
        StringBuilder sql = new StringBuilder("select ");
        Field[] fields = classManager.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (i != 0) {
                sql.append(",");
            }
            sql.append(fields[i].getName());
        }
        sql.append(" from ").append(simpleName);
        return sql.toString();
    }

    /**
     * select count(*) from dept
     */
    public static String getValue(Object object) {
        return "select count(*) from " + object.getClass().getSimpleName();
    }
}
