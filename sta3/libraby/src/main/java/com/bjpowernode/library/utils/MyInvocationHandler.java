package com.bjpowernode.library.utils;

import java.io.FileNotFoundException;
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
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {

        this.target = target;

    }

    static PrintStream printStream = null;

    static {
        Date date = new Date();
        String time = new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(date);
        try {
            printStream = new PrintStream(new FileOutputStream("Log.txt", true));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assert printStream != null;
        printStream.println(time);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;

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
