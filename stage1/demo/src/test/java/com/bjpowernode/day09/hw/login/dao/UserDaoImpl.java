package com.bjpowernode.day09.hw.login.dao;

import com.bjpowernode.day09.hw.login.domain.User;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */
public class UserDaoImpl implements UserDao {

    @Override
    public User login(Map<String, String> map) {

        Properties pros = new Properties();

        String resource = "config.txt";
        InputStream inputStream = null;
        try {
//            inputStream = Test01.class.getClassLoader().getResourceAsStream(resource);
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
            pros.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String username = pros.getProperty("LoginAct");
        String password = pros.getProperty("LoginPwd");
        if (username.equals(map.get("LoginAct")) && password.equals(map.get("LoginPwd"))) {
            return new User();
        }
        throw new RuntimeException(".........");

    }
}
