package com.bjpowernode.day10.exception;

/**
 * @author feng
 * @date 2020/12/29
 * @Description
 */
public class MyRuntimeException extends RuntimeException {
    static final long serialVersionUID = -7034897193246939L;

    public MyRuntimeException(){

    }

    public MyRuntimeException(String msg){
        super(msg);
    }
}
