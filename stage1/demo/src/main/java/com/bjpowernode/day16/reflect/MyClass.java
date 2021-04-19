package com.bjpowernode.day16.reflect;

import java.io.Serializable;

/**
 * @author feng
 * @date 2021/1/8
 * @Description
 */
public class MyClass implements Serializable {

    private static final long serialVersionUID = 838511197630002459L;

    static {
        System.out.println("这是静态代码块");
    }

    public int x;
    private int y;
    public static int s;

    public MyClass() {
        System.out.println("空参构造器执行");
    }

    public MyClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyClass{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
