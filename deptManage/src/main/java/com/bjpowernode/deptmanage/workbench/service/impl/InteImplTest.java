package com.bjpowernode.deptmanage.workbench.service.impl;

import com.bjpowernode.deptmanage.utils.ServiceFactory;
import com.bjpowernode.deptmanage.workbench.dao.DeptActivityDao;
import com.bjpowernode.deptmanage.workbench.dao.DeptActivityRemarkDao;
import com.bjpowernode.deptmanage.workbench.service.ActivityService;
import com.bjpowernode.deptmanage.workbench.service.DeptActivityService;

import java.lang.reflect.ParameterizedType;
import java.util.LinkedList;
import java.util.List;

//
//
//import com.bjpowernode.deptmanage.utils.DateTimeUtil;
//import com.bjpowernode.deptmanage.utils.ServiceFactory;
//import com.bjpowernode.deptmanage.utils.UUIDUtil;
//import com.bjpowernode.deptmanage.workbench.domain.DeptActivity;
//import com.bjpowernode.deptmanage.workbench.domain.EmpActivity;
//import com.bjpowernode.deptmanage.workbench.service.ActivityService;
//
//import java.util.List;
//
///**
// * @author feng
// * @date 2021/2/7
// * @Description
// */
//class ActivityServiceImplTest {
//
//
////        DeptActivity deptActivity = new DeptActivity();
////        ActivityService das = (ActivityService) ServiceFactory.getService(new ActivityServiceImpl());
////
////
////        deptActivity.setId(UUIDUtil.getUUID());
////        deptActivity.setOwner("40f6cdea0bd34aceb77492a1656d9fb3");
////        deptActivity.setDeptno("1234");
////        deptActivity.setDname("餐饮部");
////        deptActivity.setLoc("beishang");
////        deptActivity.setStartDate(DateTimeUtil.getSysTime());
////        deptActivity.setEndDate(DateTimeUtil.getSysTime());
////        deptActivity.setCreateBy("张三");
////        deptActivity.setCreateTime(DateTimeUtil.getSysTime());
////        deptActivity.setDescription("zheshi1说明");
//////
////        boolean flag = das.creatActivity(deptActivity);
////        System.out.println(flag);
//////
////        DeptActivityRemark ar = new DeptActivityRemark();
////        ar.setId(UUIDUtil.getUUID());
////        ar.setNoteContent("213423423");
////        ar.setActivityId("5d454ad9958a448c83d556ecdf7678f4");
////        ar.setCreateBy("李四");
////        System.out.println(das.saveRemark(ar));
////
////        System.out.println(das.getActivityListByName("张三").size());
//
////    ActivityServiceImpl<EmpActivity> as = new ActivityServiceImpl<EmpActivity>();
//
//
//    List<String> list;
//
//    public static void main(String[] args) throws SecurityException, NoSuchFieldException {
//        System.out.println(ActivityServiceImplTest.class.getDeclaredField("list").getGenericType());
//    }
//
//
//}
//
interface Inte<E>{
    void test11();
}

public class InteImplTest<E,V,K> implements Inte<E>{
    @Override
    public void test11() {
        System.out.println("fuIner");
    }
}

interface InteSon extends Inte<Object>{
}
class Son extends InteImplTest<Object,DeptActivityDao,DeptActivityRemarkDao> implements InteSon{

}



class Main{
    public static void main(String[] args) throws NoSuchFieldException {

//        ActivityServiceImplTest<String, String> test = new ActivityServiceImplTest<>();
//        test.test();
//        InteImplTest father = new Son();
        InteSon i = (InteSon) ServiceFactory.getService(new Son());
        i.test11();

        /**
         * $Proxy0 cannot be cast to Inte
         */
    }
}