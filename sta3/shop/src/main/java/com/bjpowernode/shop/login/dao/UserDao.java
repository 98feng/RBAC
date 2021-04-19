package com.bjpowernode.shop.login.dao;


import com.bjpowernode.shop.login.domain.User;

import java.util.Map;

/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */
public interface UserDao {
    /**
     *
     * @param map
     * @return
     * @throws Throwable
     */
    User login(Map<String, String> map) throws Throwable;

    User register(Map<String, String> map) throws Throwable;
}
