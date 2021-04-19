package com.bjpowernode.service;

import java.util.List;

import com.bjpowernode.domain.Admin;

/**
 * @author feng
 * @date 2021/3/12
 * @Description ${Description}
 */
public interface AdminService {


    int deleteByPrimaryKey(Integer aId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    int updateBatch(List<Admin> list);

    int batchInsert(List<Admin> list);


    Admin login(String name, String pwd);
}
