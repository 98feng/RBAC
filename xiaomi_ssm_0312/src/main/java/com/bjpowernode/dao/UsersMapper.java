package com.bjpowernode.dao;

import com.bjpowernode.domain.Users;
import com.bjpowernode.domain.UsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

  
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
public interface UsersMapper {
    long countByExample(UsersExample example);

    int deleteByExample(UsersExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(Users record);

    int insertSelective(Users record);

    List<Users> selectByExample(UsersExample example);

    Users selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
}