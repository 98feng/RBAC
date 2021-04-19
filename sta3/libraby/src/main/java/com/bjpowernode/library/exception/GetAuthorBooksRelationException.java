package com.bjpowernode.library.exception;

/**
 * @author feng
 * @date 2021/1/3
 * @Description
 */
public class GetAuthorBooksRelationException extends Exception {
    private static final long serialVersionUID = -1461193424125282138L;

    public GetAuthorBooksRelationException() {
    }

    public GetAuthorBooksRelationException(String mas) {
        super(mas);
    }
}
