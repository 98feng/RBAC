package com.bjpowernode.controller;

import com.bjpowernode.lib.ApplicationContext;
import com.bjpowernode.service.UserService;

/**
 * @author feng
 * @date 2021/3/5
 * @Description
 */
public class UserController {
    public static void main(String[] args) {

        ApplicationContext.initContext();

        UserService us = ApplicationContext.getBean(UserService.class);
        us.login();
    }
}
