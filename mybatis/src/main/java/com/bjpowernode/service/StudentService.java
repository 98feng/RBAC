package com.bjpowernode.service;

import com.bjpowernode.ioc.domain.Student;

import java.util.List;

/**
  *  @author feng
  *  @date 2021/3/1
  *  @Description ${Description}
  *  
  */
public interface StudentService{


    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    List<Student> selectAll();

    List<Student> selectByEmail(String email);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

}
