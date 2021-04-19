package com.bjpowernode.demo01.utils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author feng
 * @date 2021/1/20
 * @Description
 */
@SuppressWarnings("unchecked")
@Deprecated
public class JDBCUtils {

    //封装:交通工具创建功能
    public static PreparedStatement createStatement(String sql) {
        PreparedStatement ps = null;
        Connection conn = null;
        conn = MyInvocationHandler.connection;
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    //封装：推送DML语句
    public static int executeUpate(String dml) {
        int result = 0;
        try {
            result = createStatement(dml).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <E> E executeQuery(Class<E> classManager, String sql) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = createStatement(sql);
            rs = ps.executeQuery();
            // 获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                E e = classManager.newInstance();
                // 处理结果集一行数据中的每一个列
                for (int i = 0; i < columnCount; i++) {
                    // 获取每个列的列名
                    // String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    // 获取列值
                    Object columValue = rs.getObject(i + 1);

                    // 给E对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = classManager.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(e, columValue);
                }
                return e;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceUtil.closeResource(rs, ps);
        }
        return null;
    }

    public static <E> List<E> executeQueryAll(Class<E> classManager, String sql) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = createStatement(sql);
            rs = ps.executeQuery();
            // 获取结果集的元数据 :ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            // 通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            // 创建集合对象
            ArrayList<E> list = new ArrayList<E>();
            while (rs.next()) {
                E e = classManager.newInstance();
                // 处理结果集一行数据中的每一个列:给t对象指定的属性赋值
                for (int i = 0; i < columnCount; i++) {
                    // 获取列值
                    Object columValue = rs.getObject(i + 1);

                    // 获取每个列的列名
                    // String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    // 给t对象指定的columnName属性，赋值为columValue：通过反射
                    Field field = classManager.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(e, columValue);
                }
                list.add(e);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceUtil.closeResource(rs, ps);
        }
        return null;
    }

    public static <E> E executeQueryCount(String sql) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = createStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return (E) rs.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceUtil.closeResource(rs, ps);
        }
        return null;
    }
}
