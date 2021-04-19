package com.bjpowernode.jdbc01.utils;

import java.lang.reflect.Field;

/**
 * @author feng
 * @date 2021/1/23
 * @Description
 */
@SuppressWarnings("unchecked")
public class ReflectUtil {

    /**
     * @param object
     * @return
     * @throws Exception
     */
    public static String createInsertSql(Object object) {

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
    public static String updateSql(Object object) throws Exception {
        Class<?> classManager = object.getClass();
        String simpleName = classManager.getSimpleName();
        StringBuilder sql = new StringBuilder("update ");
        sql.append(simpleName).append(" set ");

        Field[] fields = classManager.getDeclaredFields();
        for (int i = 1; i < fields.length; i++) {
            if (i != 1) {
                sql.append(",");
            }
            sql.append(fields[i].getName()).append(" = ");
            fields[i].setAccessible(true);
            sql.append("'").append(fields[i].get(object)).append("'");
        }
        Field deptno = fields[0];
        deptno.setAccessible(true);
        sql.append(" where ").append(deptno.getName()).append(" = ").append(deptno.get(object));

        return sql.toString();
    }


}
