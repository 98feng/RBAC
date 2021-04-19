package com.bjpowernode.shop.exception;

/**
 * @author feng
 * @date 2021/1/1
 * @Description
 */
public class GoodsNotFoundException extends Exception {


    private static final long serialVersionUID = -4711033112996709589L;

    public GoodsNotFoundException(String s) {
        super(s);
    }

    public GoodsNotFoundException(){}
}
