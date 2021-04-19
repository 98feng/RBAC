package com.bjpowernode.service.impl;

import com.bjpowernode.dao.UserMapper;
import com.bjpowernode.lib.SetValue;
import com.bjpowernode.service.UserService;

/**
 * @author feng
 * @date 2021/3/5
 * @Description
 */
public class UserServiceImpl implements UserService {

    UserMapper um;

    public UserServiceImpl() {
        System.out.println("业务层对象被创建");
    }

    public void setUm(UserMapper um) {
        this.um = um;
    }

    @Override
    public void login() {
        System.out.println("业务层登录执行");
        SetValue.initClassInfo(UserServiceImpl.class);
        um.login();
    }
}
