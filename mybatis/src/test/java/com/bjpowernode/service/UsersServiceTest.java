package com.bjpowernode.service;

import com.bjpowernode.dao.UsersMapper;
import com.bjpowernode.ioc.domain.Users;
import com.bjpowernode.utils.SqlSessionUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author feng
 * @date 2021/3/2
 * @Description
 */
public class UsersServiceTest {

    UsersMapper um = SqlSessionUtil.getSqlSession().getMapper(UsersMapper.class);
    @Test
    public void deleteByPrimaryKey() {
        System.out.println(um.deleteByPrimaryKey(1));
    }

    @Test
    public void insert() {
        Date date = new Date();
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(date);
        Users users = new Users(1, "name", dateFormat, "男", "beiji");
        System.out.println(um.insert(users));
    }

    @Test
    public void test(){
        System.out.println(new Date());
        Date date = new Date();
        String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        System.out.println(um.selectByPrimaryKey(1));
    }


    @Test
    public void selectAll(){
        List<Users> list = um.selectByAll();
        for (Users users : list) {
            System.out.println(users);
        }
    }
    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
        Date date = new Date();
        String dateFormat = new SimpleDateFormat("yyyy-MM-dd").format(date);
        Users users = new Users(2, "name", dateFormat, "nan", "beiji");
        System.out.println(um.updateByPrimaryKey(users));
    }

    @Test
    public void getByColmnName(){
        List<Users> usersByName = um.getByColmnName("username", "name");
        for (Users users : usersByName) {
            System.out.println(users);
        }
    }
    @Test
    public void updateBatch() {
    }

    @Test
    public void batchInsert() {
    }
}
