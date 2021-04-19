package com.bjpowernode.service.impl;


import com.bjpowernode.service.Action;
import org.junit.Test;

/**
 * @author feng
 * @date 2021/2/28
 * @Description
 */
public class StartLiuImplTest {

    @Test
    public void sing() {

        Action action = new Proxy(new StartLiuImpl());
        action.sing();
    }
}
