package com.bjpowernode.demo02.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class MyInvocationHandler implements InvocationHandler{
	
	private Object target;

    static Connection conn;

    static {
        try {
            conn = DataSourceUtil.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Object obj;

	public MyInvocationHandler(Object target) throws SQLException {

		this.target = target;

	}

	@Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {


		try{
            conn.setAutoCommit(false);
			obj = method.invoke(target, args);

			conn.commit();
		}catch(Exception e){
            assert conn != null;
            conn.rollback();
			e.printStackTrace();

			//处理的是什么异常，继续往上抛什么异常
			throw e.getCause();

		}finally{
            try {
                assert conn != null;
                conn.setAutoCommit(true);//为true自动提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
		    DataSourceUtil.closeResource(conn);
		}

		return obj;
	}

	
	public Object getProxy(){

		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);

	}
}











































