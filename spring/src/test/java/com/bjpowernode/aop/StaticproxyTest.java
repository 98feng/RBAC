package com.bjpowernode.aop;


import org.junit.Test;

/**
 * @author feng
 * @date 2021/3/6
 * @Description
 */
public class StaticproxyTest {

    @Test
    public void buy() {

        Staticproxy staticproxy = new Staticproxy(new LogImpl(),new Staticproxy(new TranImpl(),new BookServiceImpl()));
        staticproxy.buy();
    }
}
