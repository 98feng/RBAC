package com.bjpowernode.service;

import java.util.List;
import com.bjpowernode.ioc.domain.Users;

/**
  *  @author feng
  *  @date 2021/3/2
  *  @Description ${Description}
  *  
  */
public interface UsersService{


    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);

    int updateBatch(List<Users> list);

    int batchInsert(List<Users> list);

    List<Users> getByColmnName(String columnName,String columnValue);

    int insert(Integer id);

}
