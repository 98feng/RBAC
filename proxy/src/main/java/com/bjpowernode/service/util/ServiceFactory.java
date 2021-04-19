package com.bjpowernode.service.util;

/**
 * @author feng
 * @date 2021/2/28
 * @Description
 */
public class ServiceFactory {
    public static Object getService(Object obj){
        return new MyInvocationHandler(obj).getProxy();
    }
}
