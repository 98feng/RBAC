package com.bjpowernode.test;

import com.bjpowernode.domain.Accounts;
import com.bjpowernode.domain.Users;
import com.bjpowernode.service.AccountsService;
import com.bjpowernode.service.UsersService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 动力节点
 * 2021/3/8
 */
public class MyTest {

    ApplicationContext ac;

    @Before
    public void getAc(){
        ac = new ClassPathXmlApplicationContext("applicationContext_service.xml");
    }

    @Test
    public void testInsertUsers(){
        UsersService service = ac.getBean(UsersService.class);
        int num =service.insert(new Users(1001,"张三","123"));
        System.out.println(num+"=============");
    }

    @Test
    public void testInsertAccounts(){
        AccountsService service = ac.getBean(AccountsService.class);
        int num =service.insert(new Accounts(1001,"张三","很详细"));
        System.out.println(num+"=============");
    }

}
