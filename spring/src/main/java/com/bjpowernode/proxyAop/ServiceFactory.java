package com.bjpowernode.proxyAop;

/**
 * @author feng
 * @date 2021/3/6
 * @Description
 */
public class ServiceFactory {
    public static Object getService(Aop aop,Object object){
        return new MyInvocationHandler(aop,object).getProxy();
    }
}
