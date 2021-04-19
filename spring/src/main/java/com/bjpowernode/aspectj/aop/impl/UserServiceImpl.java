package com.bjpowernode.aspectj.aop.impl;

import com.bjpowernode.aspectj.aop.UserService;
import com.bjpowernode.ioc.domain01.Student;

/**
 * @author feng
 * @date 2021/3/6
 * @Description
 */
public class UserServiceImpl implements UserService {
    @Override
    public void doSome() {
        System.out.println("主业务执行");
    }

    @Override
    public String doOther(String name, int age) {
        System.out.println("主业务doOther执行");
        return "asdc";
    }

    @Override
    public Object doFirst(String name, int age) {
        System.out.println("主业务执行diFirst执行");
        return new Student();
    }
}
