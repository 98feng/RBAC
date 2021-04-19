package com.bjpowernode.day09.hw.login.dao;

import com.bjpowernode.day09.hw.login.domain.User;

import java.util.Map;

/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */
public interface UserDao {
    User login(Map<String,String> map);
}
