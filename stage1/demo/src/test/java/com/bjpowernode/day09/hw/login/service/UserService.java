package com.bjpowernode.day09.hw.login.service;

import com.bjpowernode.day09.hw.login.domain.User;

/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */
public interface UserService {

    User login(String loginAct,String loginPwd);

}
