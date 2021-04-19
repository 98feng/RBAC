package com.bjpowernode.demo01.service.imp;


import com.bjpowernode.demo01.dao.DeptDao;
import com.bjpowernode.demo01.domain.Dept;
import com.bjpowernode.demo01.service.ActivityService;
import com.bjpowernode.demo01.utils.AutoWrite;
import com.bjpowernode.demo01.utils.Bean;

import java.util.List;

/**
 * @author feng
 * @date 2021/1/26
 * @Description
 */
@Bean
public class ActivityServiceImpl implements ActivityService {

    public ActivityServiceImpl() {
    }

    @AutoWrite
    DeptDao dd;

    @Override
    public boolean insert(Dept dept)  {
        boolean flag = true;
        int count = dd.insert(dept);
        if (count != 1){
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean update(Dept dept)  {
        boolean flag = true;
        int count = dd.update(dept);
        if (count != 1){
            flag = false;
        }
        return flag;
    }

    @Override
    public boolean deleteById(Integer id)  {

        boolean flag = true;
        int count = dd.deleteById(id);
        if (count != 1){
            flag = false;
        }
        return flag;
    }


    @Override
    public Dept getDeptById(Integer id)  {
        return dd.getDeptById(id);
    }

    @Override
    public List<Dept> getAll() {
        return dd.getAll();
    }

    @Override
    public Long getCount() {
        return dd.getCount();
    }
}
