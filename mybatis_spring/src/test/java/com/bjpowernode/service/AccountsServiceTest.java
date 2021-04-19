package com.bjpowernode.service;


import com.bjpowernode.domain.Accounts;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author feng
 * @date 2021/3/8
 * @Description
 */
public class AccountsServiceTest {

    ClassPathXmlApplicationContext classPathXmlApplicationContext;
    AccountsService as;
    @Before
    public void setUp() throws Exception {
        classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext_service.xml");
        as = classPathXmlApplicationContext.getBean(AccountsService.class);
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void insert() {

        Accounts accounts = new Accounts();
        accounts.setAcontent("123");
        accounts.setAid(1001);
        accounts.setAname("name");
        int insert = as.insert(accounts);
        System.out.println(insert);
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
