package com.bjpowernode.deptmanage.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {
	
	private SqlSessionUtil(){}
	
	private static SqlSessionFactory factory;
	
	static{
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		factory =
		 new SqlSessionFactoryBuilder().build(inputStream);
		
	}
	//创建线程副本，dataSource连接池中的连接数量是固定的，便于在不同时间下获取的是不同的连接
	private static ThreadLocal<SqlSession> t = new ThreadLocal<SqlSession>();
	
	public static SqlSession getSqlSession(){
		
		SqlSession session = t.get();
		
		if(session==null){
			
			session = factory.openSession();
			t.set(session);
		}
		
		return session;
		
	}
	
	public static void myClose(SqlSession session){
		
		if(session!=null){
		    //回到连接池
			session.close();
			//ThreadLocal中的key是个弱引用类型，当前线程回收到线程池，那这个key被销毁，但是value即session还在，会导致内存泄露，必须显示rm
			t.remove();
		}
		
	}
}
