package com.bjpowernode.aop;

/**
 * @author feng
 * @date 2021/3/6
 * @Description
 */
public class TranImpl implements Aop {

    @Override
    public void before() {
        System.out.println("事务开启");
    }

    @Override
    public void after() {
        System.out.println("事务提交");
    }

    @Override
    public void exception() {
        System.out.println("事务回滚");
    }
}
