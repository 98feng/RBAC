package com.bjpowernode.proxyAop;

/**
 * @author feng
 * @date 2021/3/6
 * @Description
 */
public interface Aop {
    default void before(){}
    default void after(){}
    default void exception(){}
}
