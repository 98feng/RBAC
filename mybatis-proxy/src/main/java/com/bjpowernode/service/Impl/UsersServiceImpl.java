package com.bjpowernode.service.Impl;

import javax.annotation.Resource;
import java.util.List;
import com.bjpowernode.dao.UsersMapper;
import com.bjpowernode.ioc.domain.Users;
import com.bjpowernode.service.UsersService;
  
 /** 
  *  @author feng
  *  @date 2021/3/4
  *  @Description ${Description}
  *  
  */
public class UsersServiceImpl implements UsersService{

    @Resource
    private UsersMapper usersMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return usersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Users record) {
        return usersMapper.insert(record);
    }

    @Override
    public int insertSelective(Users record) {
        return usersMapper.insertSelective(record);
    }

    @Override
    public Users selectByPrimaryKey(Integer id) {
        return usersMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Users record) {
        return usersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Users record) {
        return usersMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateBatch(List<Users> list) {
        return usersMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<Users> list) {
        return usersMapper.batchInsert(list);
    }

}
