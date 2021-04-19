package com.bjpowernode.library.exception;

/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
public class BooksNotFoundException extends Throwable {
    private static final long serialVersionUID = 8703046825187151605L;

    public BooksNotFoundException() {
    }

    public BooksNotFoundException(String s) {
        super(s);
    }
}
