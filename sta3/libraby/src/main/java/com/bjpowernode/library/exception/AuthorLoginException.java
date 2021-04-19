package com.bjpowernode.library.exception;

/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
public class AuthorLoginException extends Throwable {
    private static final long serialVersionUID = 7263387128705440110L;

    public AuthorLoginException(){}

    public AuthorLoginException(String s) {
        super(s);
    }
}
