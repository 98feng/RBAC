package com.bjpowernode.day09.hw.login.userController;

import com.bjpowernode.day09.hw.login.TestLogin;
import com.bjpowernode.day09.hw.login.UserServiceImpl;
import com.bjpowernode.day09.hw.login.service.UserService;
import org.junit.Test;

import java.util.Map;

/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */
public class UserController {

    @Test
    public void test(){


        Map<String, String> map = TestLogin.input();
        UserService us = (UserService) (new UserServiceImpl());

    }
}
