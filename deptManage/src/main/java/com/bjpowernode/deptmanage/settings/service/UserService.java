package com.bjpowernode.deptmanage.settings.service;

import com.bjpowernode.deptmanage.exception.LoginException;
import com.bjpowernode.deptmanage.settings.domain.User;

import java.util.List;

/**
 * @author feng
 * @date 2020/10/11 - 10:55
 * @Description
 */
public interface UserService {
    User login(String loginAct, String loginPwd, String ip) throws LoginException;

    List<User> getUserList();
}
