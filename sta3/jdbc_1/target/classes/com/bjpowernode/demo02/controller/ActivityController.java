package com.bjpowernode.demo02.controller;

import com.bjpowernode.demo02.domain.Dept;
import com.bjpowernode.demo02.service.ActivityService;
import com.bjpowernode.demo02.service.imp.ActivityServiceImpl;
import com.bjpowernode.demo02.utils.ServiceFactory;

/**
 * @author feng
 * @date 2021/1/26
 * @Description
 */
public class ActivityController {

    public static void main(String[] args) {

        ActivityService as = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());

        Dept dept = new Dept();
        dept.setDeptno(77);
        dept.setDname("demo");
        dept.setLoc("北京");
        try {
            boolean flag = as.update(dept);
            System.out.println("更新成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
