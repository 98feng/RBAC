package com.bjpowernode.service.impl;


import com.bjpowernode.service.Action;
import com.bjpowernode.service.util.ServiceFactory;
import org.junit.Test;


/**
 * @author feng
 * @date 2021/2/28
 * @Description
 */
public class LiuImplTest {
    @Test
    public void test1() {
        Action a = (Action) ServiceFactory.getService(new LiuImpl());
        a.sing();
    }
}
