package com.bjpowernode.proxyAop;


/**
 * @author feng
 * @date 2021/3/6
 * @Description
 */
public class BookServiceImpl implements Service {
    @Override
    public void buy() {
        System.out.println("买书的主业务执行");
    }
}
