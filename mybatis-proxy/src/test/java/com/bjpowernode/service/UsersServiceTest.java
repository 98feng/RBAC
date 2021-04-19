package com.bjpowernode.service;


import com.bjpowernode.dao.UsersMapper;
import com.bjpowernode.ioc.domain.Users;
import com.bjpowernode.utils.SqlSessionUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author feng
 * @date 2021/3/4
 * @Description
 */
public class UsersServiceTest {

    UsersMapper um = SqlSessionUtil.getSqlSession().getMapper(UsersMapper.class);
    @Test
    public void deleteByPrimaryKey() {

    }

    @Test
    public void deleteBatch(){
        int[] arr = {2,3,4};
        int num = um.deleteBatch(arr);
        System.out.println(num);


    }

    @Test
    public void getByNameOrGender(){
        List<Map<String,Object>> list = um.getByNameOrGender("name","男");
        list.forEach(System.out::println);
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
        String uuid = UUID.randomUUID().toString();
        Users users = new Users(uuid, "userName", new SimpleDateFormat("yyyy-MM-dd").format(new Date()), "gender", "address");
        int num = um.insert(users);
        System.out.println(num);
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
