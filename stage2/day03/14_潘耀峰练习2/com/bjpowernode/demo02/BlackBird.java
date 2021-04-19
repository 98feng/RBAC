package com.bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/17
 * @Description
 */
public class BlackBird extends Bird implements Flyable {
    @Override
    public void flay() {
        System.out.println("爆炸");
    }
}
