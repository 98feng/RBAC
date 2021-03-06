package com.bjpowernode.deptmanage.settings.service.impl;


import com.bjpowernode.deptmanage.exception.LoginException;
import com.bjpowernode.deptmanage.settings.domain.User;
import com.bjpowernode.deptmanage.settings.service.UserService;
import com.bjpowernode.deptmanage.settings.dao.UserDao;
import com.bjpowernode.deptmanage.utils.DateTimeUtil;
import com.bjpowernode.deptmanage.utils.SqlSessionUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @date 2020/10/11 - 10:59
 * @Description
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public User login(String loginAct, String loginPwd, String ip) throws LoginException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("loginAct", loginAct);
        map.put("loginPwd", loginPwd);
        User user = userDao.login(map);
        if (user == null) {
            throw new LoginException("账号密码错误！");
        }

        String expireTime = user.getExpireTime();
        String currentTime = DateTimeUtil.getSysTime();
        if(expireTime.compareTo(currentTime) < 0){
            throw new LoginException("账号已失效");
        }
        String allowIps = user.getAllowIps();
        if(!allowIps.contains(ip)){
            throw new LoginException("ip地址失效");
        }
        String lockState = user.getLockState();
        if("0".equals(lockState)){
            throw new LoginException("账号已锁定");
        }
        return user;
    }
    @Override
    public List<User> getUserList(){
        return userDao.getUserList();
    }
}