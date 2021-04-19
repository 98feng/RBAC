package com.bjpowernode.shop.login.service.impl;

import com.bjpowernode.shop.exception.LoginException;
import com.bjpowernode.shop.exception.registerException;
import com.bjpowernode.shop.login.dao.UserDao;
import com.bjpowernode.shop.login.dao.UserDaoImpl;
import com.bjpowernode.shop.login.domain.User;
import com.bjpowernode.shop.login.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User register(String loginAct, String loginPwd) throws Throwable {
        Map<String, String> map = new HashMap<String, String>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);

        User user = userDao.register(map);


        if (user != null) {

            throw new registerException("此用户已存在！");
        }

        return user;
    }

    @Override
    public User login(String loginAct, String loginPwd) throws Throwable {

        Map<String, String> map = new HashMap<String, String>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);

        User user = userDao.login(map);


        if (user == null) {

            throw new LoginException("账号密码错误！");
        }

        return user;
    }


}
