package com.bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/17
 * @Description
 */
public class RedBird extends Bird implements Flyable {
    @Override
    public void flay() {
        System.out.println("正常飞行");
    }
}
