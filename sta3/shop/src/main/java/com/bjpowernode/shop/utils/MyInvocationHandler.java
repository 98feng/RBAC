package com.bjpowernode.shop.utils;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author feng
 * @date 2020/12/27
 * @Description
 *
 *
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {

        this.target = target;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;

        PrintStream printStream = null;
        Date date = new Date();
        String time = new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(date);
        printStream = new PrintStream(new FileOutputStream("Log.txt",true));
        printStream.println(time);
        try {
            obj = method.invoke(target, args);
        } catch (Exception e) {
            //将异常打印到日志文件中
            e.printStackTrace(printStream);
            throw e.getCause();
        }
        return obj;
    }

    public Object getProxy() {

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

    }
}
