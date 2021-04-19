package com.bjpowernode.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.bjpowernode.dao.UsersMapper;
import com.bjpowernode.domain.UsersExample;
import com.bjpowernode.domain.Users;
import com.bjpowernode.service.UsersService;
  
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
@Service
public class UsersServiceImpl implements UsersService{

    @Resource
    private UsersMapper usersMapper;

    @Override
    public long countByExample(UsersExample example) {
        return usersMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UsersExample example) {
        return usersMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer uid) {
        return usersMapper.deleteByPrimaryKey(uid);
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
    public List<Users> selectByExample(UsersExample example) {
        return usersMapper.selectByExample(example);
    }

    @Override
    public Users selectByPrimaryKey(Integer uid) {
        return usersMapper.selectByPrimaryKey(uid);
    }

    @Override
    public int updateByExampleSelective(Users record,UsersExample example) {
        return usersMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Users record,UsersExample example) {
        return usersMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Users record) {
        return usersMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Users record) {
        return usersMapper.updateByPrimaryKey(record);
    }

}
