package com.bjpowernode.service;


import com.bjpowernode.domain.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author feng
 * @date 2021/3/8
 * @Description
 */
public class UsersServiceTest {

    ClassPathXmlApplicationContext classPathXmlApplicationContext;
    @Before
    public void setUp() throws Exception {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext_service.xml");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        UsersService us = classPathXmlApplicationContext.getBean(UsersService.class);
        Users users = new Users();
        users.setUname("name");
        users.setUpass("1243");
        users.setUserid(1002);
        int num = us.insert(users);
        System.out.println(num);
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void updateBatch() {
    }

    @Test
    public void batchInsert() {
    }
}
