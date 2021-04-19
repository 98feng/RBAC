package com.bjpowernode.demo02.utils;

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
public class JDBCUtils {

    /*//封装:获取连接
    @Deprecated
    public Connection getConnection() throws Exception {
        // 1.读取配置文件中的4个基本信息
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("username");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClassName");

        // 2.加载驱动
        Class.forName(driverClass);

        // 3.获取连接
        return DriverManager.getConnection(url, user, password);

    }*/

    //封装:交通工具创建功能
    public PreparedStatement createStatement(String sql) throws SQLException {
        PreparedStatement ps = null;
        Connection conn = null;
        conn = getConnection();
        ps = conn.prepareStatement(sql);
        return ps;
    }

    /**
     * 获取连接
     *
     * @return
     */
    private Connection getConnection() {
        Connection conn = null;
        Class<?> classManager = null;
        try {
            classManager = Class.forName("com.bjpowernode.demo02.utils.MyInvocationHandler");
            Field field = classManager.getDeclaredField("conn");

            conn = (Connection) field.get(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //封装：推送DML语句
    public int executeUpate(String dml) throws SQLException {
        int result = 0;
        result = createStatement(dml).executeUpdate();
        return result;
    }

    public <E> E executeQuery(Class<E> classManager, String sql) throws Exception {
        ResultSet rs = null;
        PreparedStatement ps = createStatement(sql);
        try {
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
        } finally {
            DataSourceUtil.closeResource(rs, ps);
        }

        return null;
    }

    public <E> List<E> executeQueryAll(Class<E> classManager, String sql) throws Exception {
        PreparedStatement ps = createStatement(sql);
        ResultSet rs = null;
        try {
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
        } finally {
            DataSourceUtil.closeResource(rs, ps);
        }
    }

    public <E> E executeQueryCount(String sql) throws SQLException {
        ResultSet rs = null;
        PreparedStatement ps = createStatement(sql);
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                return (E) rs.getObject(1);
            }
        } finally {
            DataSourceUtil.closeResource(rs, ps);
        }
        return null;
    }
}
