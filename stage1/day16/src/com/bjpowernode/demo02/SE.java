package com.bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/15
 * @Description
 */
public class SE implements IBusiness, ICode {


    @Override
    public void speak() {
        System.out.println("讲业务");
    }

    @Override
    public void write() {
        System.out.println("写代码");

    }
}
