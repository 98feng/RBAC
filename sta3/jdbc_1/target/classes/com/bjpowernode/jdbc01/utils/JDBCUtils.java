package com.bjpowernode.jdbc01.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author feng
 * @date 2021/1/20
 * @Description
 */
public class JDBCUtils {

    public static Connection getConnection() throws Exception {
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
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    //封装:交通工具创建功能
    public static PreparedStatement createStatement(String sql) throws Exception {
        PreparedStatement ps = null;
        ps = getConnection().prepareStatement(sql);
        return ps;
    }

    //封装：推送DML语句
    public static int executeUpate(String dml) throws Exception {
        int result = 0;
        result = createStatement(dml).executeUpdate();
        return result;
    }

    //关闭资源
    public static void closeResource(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResource(Connection conn, Statement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeResource(conn);
    }

    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeResource(conn, ps);
    }
}
