package com.bjpowernode.demo01.controller;

import com.bjpowernode.demo01.domain.Dept;
import com.bjpowernode.demo01.service.ActivityService;
import com.bjpowernode.demo01.utils.ApplicationContext;
import com.bjpowernode.demo01.utils.ServiceFactory;

import java.util.HashMap;

/**
 * @author feng
 * @date 2021/1/26
 * @Description
 */
public class ActivityController {

    public static void main(String[] args) {

        ApplicationContext<?> applicationContext = new ApplicationContext<>();
        ApplicationContext.initContextByAnnotation();
        Object servImpl = applicationContext.getBean(ActivityService.class);
        ActivityService as = (ActivityService) ServiceFactory.getService(servImpl);

        Dept dept = new Dept();
        dept.setDeptno(66666666);
        dept.setDname("demo");
        dept.setLoc("北京");
//        boolean flag = as.insert(dept);
//        System.out.println("添加成功！");
//        boolean update = as.update(dept);
//        System.out.println("更新成功！");

//        for (int i = 0;i < 30;i++) {
//            List<Dept> all = as.getAll();
//            System.out.println(all);
//            Long count = as.getCount();
//            System.out.println(count);
//            Dept deptById = as.getDeptById(666666);
//            System.out.println(deptById);
//
//
//            boolean flag1 = as.deleteById(666);
//            if (flag1){
//                System.out.println("删除成功！");
//            }
//        }
//        for (int i = 0;i < 30;i ++) {
//            new Thread(new Runnable() {
//                @Override
//                public synchronized void run() {
//                    System.out.println(as.getAll());
//                }
//            }).start();
//        }
    }
}
