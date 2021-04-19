package com.bjpowernode.shop.login.service;


import com.bjpowernode.shop.exception.LoginException;
import com.bjpowernode.shop.exception.registerException;
import com.bjpowernode.shop.login.domain.User;

/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */
public interface UserService {

    User login(String loginAct, String loginPwd) throws Throwable;

    User register(String loginAct, String loginPwd) throws Throwable;
}
