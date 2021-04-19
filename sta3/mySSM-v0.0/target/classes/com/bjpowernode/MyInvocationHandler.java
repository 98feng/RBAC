package com.bjpowernode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class MyInvocationHandler implements InvocationHandler{
	
	private Object target;

    private static Connection connection;

    public MyInvocationHandler(Object target){

		this.target = target;

	}

	@Override
    public Object  invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj;
        try{
			connection = DataSourceUtil.getConnection();
            System.out.println("ThreadLocal获取" + connection);
            connection.setAutoCommit(false);

			obj = method.invoke(target, args);

			connection.commit();
		}catch(Exception e){
            assert connection != null;
            connection.rollback();
			e.printStackTrace();

			//处理的是什么异常，继续往上抛什么异常
			throw e.getCause();

		}finally{
            try {
                assert connection != null;
                connection.setAutoCommit(true);//为true自动提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("关闭的连接" + connection);
		    DataSourceUtil.closeResource(connection);
            System.out.println("关闭的连接" + connection);
		}

		return obj;
	}

	
	public Object getProxy(){

		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);

	}
}











































