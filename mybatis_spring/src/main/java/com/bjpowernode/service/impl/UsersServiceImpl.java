package com.bjpowernode.service.impl;

import com.bjpowernode.dao.UsersMapper;
import com.bjpowernode.domain.Accounts;
import com.bjpowernode.domain.Users;
import com.bjpowernode.service.AccountsService;
import com.bjpowernode.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 动力节点
 * 2021/3/8
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UsersServiceImpl implements UsersService {

    @Autowired  //由Spring框架负责mapper对象的创建并依赖注入
    UsersMapper usersMapper;

    @Autowired
    AccountsService accountsService;

    @Override
    public int insert(Users users) {

        int num = usersMapper.insert(users);
        System.out.println("增加用户成功=========="+num);

        //调用增加帐户的方法，完成增加帐户并抛异常
        accountsService.insert(new Accounts(2002,"李四","很好"));
        return num;
    }
}
