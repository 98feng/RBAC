package com.bjpowernode.service.impl;

import com.bjpowernode.dao.AccountsMapper;
import com.bjpowernode.domain.Accounts;
import com.bjpowernode.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 动力节点
 * 2021/3/9
 */
@Service
@Transactional(propagation = Propagation.NEVER)
public class AccountsServiceImpl implements AccountsService {

   //切记切记：在业务逻辑层一定会有数据访问层的对象
   @Autowired
   AccountsMapper accountsMapper;


    @Override
    public int insert(Accounts accounts) {
        int num= accountsMapper.insert(accounts);
        System.out.println("增加帐户成功======"+num);
        System.out.println(10/0);
        return num;
    }
}
