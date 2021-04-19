package com.bjpowernode.aop;

/**
 * @author feng
 * @date 2021/3/6
 * @Description
 */
public class LogImpl implements Aop {

    @Override
    public void before() {
        System.out.println("前置日志输出");
    }
}
