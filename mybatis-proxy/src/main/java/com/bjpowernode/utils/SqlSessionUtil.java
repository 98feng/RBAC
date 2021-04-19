package com.bjpowernode.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author feng
 * @date 2021/3/1
 * @Description
 */
public class SqlSessionUtil {


    private SqlSessionUtil() {
    }

    private static SqlSessionFactory factory;

    static {
        InputStream inputStream = null;
        String resource = "mybatis-config.xml";

        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        factory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    private static ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>();

    public static SqlSession getSqlSession() {
        SqlSession session = t.get();

        if (session == null) {
            session = factory.openSession();
            t.set(session);
        }
        return session;
    }


    public static void myClose(SqlSession session){
        if (session != null){
            session.close();
            t.remove();
        }
    }

}
