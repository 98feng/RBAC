package com.bjpowernode.shop.exception;

/**
 * @author feng
 * @date 2020/12/31
 * @Description
 */
public class LoginException extends Exception {

    private static final long serialVersionUID = -3877265898765686083L;

    public LoginException() {
    }

    public LoginException(String message) {
        super(message);
    }
}
