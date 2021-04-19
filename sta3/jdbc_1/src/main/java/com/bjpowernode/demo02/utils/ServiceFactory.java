package com.bjpowernode.demo02.utils;


import java.sql.SQLException;

public class ServiceFactory {

    public static Object getService(Object service) {
        Object proxy = null;
        try {
            proxy = new MyInvocationHandler(service).getProxy();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proxy;

    }

}
