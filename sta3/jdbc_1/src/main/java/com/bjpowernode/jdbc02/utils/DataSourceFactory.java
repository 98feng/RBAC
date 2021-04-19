package com.bjpowernode.jdbc02.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author feng
 * @date 2021/1/22
 * @Description
 */
public class DataSourceFactory {

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

//    private static final ThreadLocal<DataSource> t = new ThreadLocal<DataSource>();

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closeResource(Connection conn) {
        DbUtils.closeQuietly(conn);
    }
}
