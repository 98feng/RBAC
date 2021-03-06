package com.bjpowernode.deptmanage.settings.dao;

import com.bjpowernode.deptmanage.settings.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @date 2020/10/11 - 10:51
 * @Description
 */
public interface UserDao {
    User login(Map<String, String> map);
    List<User> getUserList();
}
