package com.bjpowernode.proxyAop;

import org.junit.Test;

/**
 * @author feng
 * @date 2021/3/6
 * @Description
 */
public class ServiceTest {


    @Test
    public void buy() {
        Service service = (Service) ServiceFactory.getService(new TranImpl(),new BookServiceImpl());
        System.out.println(service);
        Service service1 = (Service) ServiceFactory.getService(new LogImpl(),service);
        System.out.println(service1);
        service1.buy();
    }
}
