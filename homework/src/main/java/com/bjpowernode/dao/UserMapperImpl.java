package com.bjpowernode.dao;

/**
 * @author feng
 * @date 2021/3/5
 * @Description
 */
public class UserMapperImpl implements UserMapper {
    public UserMapperImpl() {
        System.out.println("Dao层对象被创建");
    }

    @Override
    public void login() {
        System.out.println("dao层登录查询");
    }
}
