package com.bjpowernode.day10.exception;

/**
 * @author feng
 * @date 2020/12/29
 * @Description
 */
public class MyException extends Exception {

    private final long serialVersionUID = -7034897193246939L;

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

}
