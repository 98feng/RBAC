package com.bjpowernode.demo02.service.imp;

import com.bjpowernode.demo02.dao.DeptDao;
import com.bjpowernode.demo02.dao.DeptDaoImpl;
import com.bjpowernode.demo02.domain.Dept;
import com.bjpowernode.demo02.service.ActivityService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author feng
 * @date 2021/1/26
 * @Description
 */
public class ActivityServiceImpl implements ActivityService {

    DeptDao dd = new DeptDaoImpl();


    @Override
    public boolean insert(Dept dept) throws Exception {
        boolean flag = true;
        int count = dd.insert(dept);
        if (count != 1){
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean update(Dept dept) throws Exception {
        boolean flag = true;
        int count = dd.update(dept);
        if (count != 1){
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean deleteById(Integer id) throws Exception {

        boolean flag = true;
        Connection conn = null;
        int count = dd.deleteById(78);
        if (count != 1){
            flag = false;
        }
        return flag;
    }


    @Override
    public Dept getDeptById(Integer id) throws Exception {
        return dd.getDeptById(77);
    }

    @Override
    public List<Dept> getAll() throws Exception {
        return dd.getAll();
    }

    @Override
    public Long getCount() throws SQLException {
        return dd.getCount();
    }
}
