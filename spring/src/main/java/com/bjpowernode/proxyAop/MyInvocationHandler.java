package com.bjpowernode.proxyAop;

import org.omg.CORBA.OBJ_ADAPTER;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author feng
 * @date 2021/3/6
 * @Description
 */
public class MyInvocationHandler implements InvocationHandler {

    Aop aop;
    Object target;

    public MyInvocationHandler(Aop aop, Object target) {
        this.aop = aop;
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {

        Object obj = null;
        try {
            aop.before();
            obj = method.invoke(target, args);
            aop.after();
        } catch (Exception e) {
            aop.exception();
            e.printStackTrace();
        }
        return obj;

    }
    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
}
