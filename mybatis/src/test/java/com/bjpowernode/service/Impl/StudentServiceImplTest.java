package com.bjpowernode.service.Impl;


import com.bjpowernode.dao.StudentMapper;
import com.bjpowernode.ioc.domain.Student;
import com.bjpowernode.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

/**
 * @author feng
 * @date 2021/3/1
 * @Description
 */
public class StudentServiceImplTest {

    StudentMapper student = SqlSessionUtil.getSqlSession().getMapper(StudentMapper.class);

    @Test
    public void deleteByPrimaryKey() {
        int i = student.deleteByPrimaryKey(9);
        System.out.println(i);
    }

    @Test
    public void insert() {
        Student student1 = new Student(1,"2130", "213", 18);
        System.out.println(student.insert(student1));
    }


    @Test
    public void selectAll(){
        List<Student> list = student.selectAll();
        for (Student student1 : list) {
            System.out.println(student1);
        }
    }

    @Test
    public void selectByEmail(){
        List<Student> list = student.selectByEmail("a");
        for (Student student1 : list) {
            System.out.println(student1);
        }
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        Student stu = student.selectByPrimaryKey(1);
        System.out.println(stu);
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
        Student zhangsan = new Student(1, "zhangsan", "163@qq.coim", 21);
        int i = student.updateByPrimaryKey(zhangsan);
        System.out.println(i);
    }
}
