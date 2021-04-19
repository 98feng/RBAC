package com.bjpowernode;

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
    //数据库连接池是线程安全的，但数据库连接不是同步的,虽然跟这句话没关系
    //ThreadLocal在每个线程中对连接会创建一个副本，且在线程内部任何地方都可以使用，线程之间互不影响,
    // 避免不同时间先获取的是相同的连接
    private static ThreadLocal<Connection> t = new ThreadLocal<Connection>();

    public static Connection getConnection() throws SQLException {
        Connection connection = t.get();
        if (connection == null){
            connection = dataSource.getConnection();
            t.set(connection);
        }
        return connection;
    }

    /**
     * 关闭连接
     * @param conn
     */
    public static void closeResource(Connection conn) {
        if (conn != null) {
            try {
                //数据库连接池的连接会自动回到连接池中
                conn.close();
                //map中的线程对象是一个弱引用,key为null了，但value即connection还在,
                // 造成内存泄露,需要及时rm
                t.remove();
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
