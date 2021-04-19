package com.bjpowernode.day09.generice.lambda;

import org.junit.Test;

/**
 * @author feng
 * @date 2020/12/29
 * @Description
 */
public class LambdaTest {

    @Test
    public void test01() {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        };

        runnable.run();


        System.out.println("***********************");
        Runnable r2 = ()-> System.out.println("123");
        r2.run();
    }
}
