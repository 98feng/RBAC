package com.bjpowernode.service.Impl;

import javax.annotation.Resource;
import com.bjpowernode.ioc.domain.Student;
import com.bjpowernode.dao.StudentMapper;
import com.bjpowernode.service.StudentService;

import java.util.List;

/**
  *  @author feng
  *  @date 2021/3/1
  *  @Description ${Description}
  *  
  */

public class StudentServiceImpl implements StudentService{

    @Resource
    private StudentMapper studentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public int insertSelective(Student record) {
        return studentMapper.insertSelective(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer id) {
        return studentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public List<Student> selectByEmail(String email) {
        return studentMapper.selectByEmail(email);
    }

    @Override
    public int updateByPrimaryKeySelective(Student record) {
        return studentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }

}
