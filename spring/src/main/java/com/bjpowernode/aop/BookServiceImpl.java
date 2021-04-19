package com.bjpowernode.aop;

/**
 * @author feng
 * @date 2021/3/6
 * @Description
 */
public class BookServiceImpl implements Action {
    @Override
    public void buy() {
        System.out.println("买书的主业务执行");
    }
}
