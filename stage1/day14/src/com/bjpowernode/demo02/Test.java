package com.bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/12
 * @Description
 */
public class Test {

    public static void main(String[] args) {

        Master master = new Master();
        master.feed(new Cat());
        master.feed(new Dog());

    }
}
