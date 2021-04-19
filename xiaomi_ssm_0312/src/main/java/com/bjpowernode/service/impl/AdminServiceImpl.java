package com.bjpowernode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.bjpowernode.dao.AdminMapper;
import com.bjpowernode.domain.Admin;
import com.bjpowernode.service.AdminService;

/**
 * @author feng
 * @date 2021/3/12
 * @Description ${Description}
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int deleteByPrimaryKey(Integer aId) {
        return adminMapper.deleteByPrimaryKey(aId);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public Admin selectByPrimaryKey(Integer aId) {
        return adminMapper.selectByPrimaryKey(aId);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Admin> list) {
        return adminMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<Admin> list) {
        return adminMapper.batchInsert(list);
    }

    @Override
    public Admin login(String name, String pwd) {
        System.out.println("进入业务层");
        Admin admin = adminMapper.login(name, pwd);
        System.out.println(admin);
        return admin;
    }

}
