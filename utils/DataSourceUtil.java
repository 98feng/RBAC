package com.bjpowernode.demo01.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author feng
 * @date 2021/1/22
 * @Description
 */
public class DataSourceUtil {

    private static DataSource dataSource = null;

    static {
        Properties pros = new Properties();
        InputStream is = null;
        try {
            is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            pros.load(is);
            dataSource = DruidDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 关闭连接
     *
     * @param conn
     */
    public static void closeResource(Connection conn) {
        if (conn != null) {
            try {
                //数据库连接池的连接会自动回到连接池中
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResource(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResource(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void closeResource(ResultSet rs, Statement stmt) {
        closeResource(rs);
        closeResource(stmt);
    }

    public static void closeResource(Connection conn, Statement ps) {
        closeResource(ps);
        closeResource(conn);
    }

    public static void closeResource(Connection conn, ResultSet ps) {
        closeResource(ps);
        closeResource(conn);
    }

    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        closeResource(rs);
        closeResource(conn, ps);
    }
}
