package com.bjpowernode.demo01.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class MyInvocationHandler implements InvocationHandler{
	
	private Object target;

    private static Connection connection;

    static {
        try {
            connection = DataSourceUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Object obj;

	public MyInvocationHandler(Object target){

		this.target = target;

	}

	@Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try{
			connection = DataSourceUtil.getConnection();
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
		    DataSourceUtil.closeResource(connection);
		}

		return obj;
	}

	
	public Object getProxy(){

		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);

	}
}











































