package com.bjpowernode.crm.settings.service.impl;

import com.bjpowernode.crm.settings.domain.TblUser;
import com.bjpowernode.crm.settings.domain.User;
import com.bjpowernode.crm.settings.mapper.TblUserMapper;
import com.bjpowernode.crm.settings.mapper.UserMapper;
import com.bjpowernode.crm.settings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 动力节点
 * 2021/3/19
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TblUserMapper tblUserMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public TblUser selectUserById(String id) {
        return tblUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public User queryUserByLoginActAndPwd(Map<String, Object> map) {
        return userMapper.selectUserByLoginActAndPwd(map);
    }

    @Override
    public List<User> queryAllUsers() {
        return userMapper.selectAllUser();
    }


}
