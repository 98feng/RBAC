package com.bjpowernode.day09.hw.login;

import com.bjpowernode.day09.hw.login.dao.UserDao;
import com.bjpowernode.day09.hw.login.domain.User;
import com.bjpowernode.day09.hw.login.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public User login(String loginAct, String loginPwd) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);

        User user = userDao.login(map);

        if (user == null) {

            throw new RuntimeException("账号密码错误！");
        }

        return user;
    }
}
