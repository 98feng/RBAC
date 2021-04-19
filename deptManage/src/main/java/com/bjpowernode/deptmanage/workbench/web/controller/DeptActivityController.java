package com.bjpowernode.deptmanage.workbench.web.controller;

import com.bjpowernode.deptmanage.settings.domain.User;
import com.bjpowernode.deptmanage.settings.service.UserService;
import com.bjpowernode.deptmanage.settings.service.impl.UserServiceImpl;
import com.bjpowernode.deptmanage.utils.DateTimeUtil;
import com.bjpowernode.deptmanage.utils.PrintJson;
import com.bjpowernode.deptmanage.utils.ServiceFactory;
import com.bjpowernode.deptmanage.utils.UUIDUtil;
import com.bjpowernode.deptmanage.vo.PaginationVO;
import com.bjpowernode.deptmanage.workbench.domain.DeptActivity;
import com.bjpowernode.deptmanage.workbench.domain.DeptActivityRemark;
import com.bjpowernode.deptmanage.workbench.service.DeptActivityService;
import com.bjpowernode.deptmanage.workbench.service.impl.DeptActivityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @date 2020/10/13 - 11:46
 * @Description
 */
@SuppressWarnings("all")
public class DeptActivityController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到信息活动控制器");

        String path = request.getServletPath();

        if ("/workbench/deptActivity/getUserList.do".equals(path)) {

            getUserList(request, response);
        } else if ("/workbench/deptActivity/creatActivity.do".equals(path)) {

            creatActivity(request, response);
        }else if ("/workbench/deptActivity/pageList.do".equals(path)) {

            pageList(request, response);
        }else if("/workbench/deptActivity/delete.do".equals(path)){

            delete(request,response);

        }else if("/workbench/deptActivity/getUserListAndActivity.do".equals(path)){

            getUserListAndActivity(request,response);

        }else if("/workbench/deptActivity/update.do".equals(path)){

            update(request,response);

        }else if("/workbench/deptActivity/detail.do".equals(path)){

            detail(request,response);

        }else if("/workbench/deptActivity/getRemarkListByAid.do".equals(path)){

            getRemarkListByAid(request,response);

        }else if("/workbench/deptActivity/deleteRemark.do".equals(path)){

            deleteRemark(request,response);

        }else if("/workbench/deptActivity/saveRemark.do".equals(path)){

            saveRemark(request,response);

        }else if("/workbench/deptActivity/updateRemark.do".equals(path)){

            updateRemark(request,response);

        }


    }
    private void updateRemark(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("执行修改备注的操作");

        String id = request.getParameter("id");
        String noteContent = request.getParameter("noteContent");
        String editTime = DateTimeUtil.getSysTime();
        String editBy = ((User)request.getSession().getAttribute("user")).getName();
        String editFlag = "1";

        DeptActivityRemark ar = new DeptActivityRemark();

        ar.setId(id);
        ar.setNoteContent(noteContent);
        ar.setEditFlag(editFlag);
        ar.setEditBy(editBy);
        ar.setEditTime(editTime);

        DeptActivityService as = (DeptActivityService) ServiceFactory.getService(new DeptActivityServiceImpl());

        boolean flag = as.updateRemark(ar);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success", flag);
        map.put("ar", ar);

        PrintJson.printJsonObj(response, map);

    }

    private void saveRemark(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("执行添加备注操作");

        String noteContent = request.getParameter("noteContent");
        String activityId = request.getParameter("activityId");
        String id = UUIDUtil.getUUID();
        String createTime = DateTimeUtil.getSysTime();
        String createBy = ((User)request.getSession().getAttribute("user")).getName();
        String editFlag = "0";

        DeptActivityRemark ar = new DeptActivityRemark();
        ar.setId(id);
        ar.setNoteContent(noteContent);
        ar.setActivityId(activityId);
        ar.setCreateBy(createBy);
        ar.setCreateTime(createTime);
        ar.setEditFlag(editFlag);

        DeptActivityService as = (DeptActivityService) ServiceFactory.getService(new DeptActivityServiceImpl());

        boolean flag = as.saveRemark(ar);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success", flag);
        map.put("ar", ar);

        PrintJson.printJsonObj(response, map);


    }

    private void deleteRemark(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("删除备注操作");

        String id = request.getParameter("id");

        DeptActivityService as = (DeptActivityService) ServiceFactory.getService(new DeptActivityServiceImpl());

        boolean flag = as.deleteRemark(id);

        PrintJson.printJsonFlag(response, flag);


    }

    private void getRemarkListByAid(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("根据信息id，取得备注信息列表");

        String activityId = request.getParameter("activityId");

        DeptActivityService as = (DeptActivityService) ServiceFactory.getService(new DeptActivityServiceImpl());

        List<Object> arList = as.getRemarkListByAid(activityId);

        PrintJson.printJsonObj(response, arList);



    }

    private void detail(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        System.out.println("进入到跳转到详细信息页的操作");

        String id = request.getParameter("id");

        DeptActivityService as = (DeptActivityService) ServiceFactory.getService(new DeptActivityServiceImpl());

        DeptActivity a = (DeptActivity) as.detail(id);

        request.setAttribute("a", a);

        request.getRequestDispatcher("/workbench/activity/detaildept.jsp").forward(request, response);


    }

    private void update(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("执行信息修改操作");

        String id = request.getParameter("id");
        String owner = request.getParameter("owner");
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String description = request.getParameter("description");
        //修改时间：当前系统时间
        String editTime = DateTimeUtil.getSysTime();
        //修改人：当前登录用户
        String editBy = ((User)request.getSession().getAttribute("user")).getName();

        DeptActivity a = new DeptActivity();
        a.setId(id);
        a.setStartDate(startDate);
        a.setOwner(owner);
        a.setDeptno(deptno);
        a.setDname(dname);
        a.setLoc(loc);

        a.setEndDate(endDate);
        a.setDescription(description);
        a.setEditBy(editBy);
        a.setEditTime(editTime);

        DeptActivityService as = (DeptActivityService) ServiceFactory.getService(new DeptActivityServiceImpl());

        boolean flag = as.update(a);

        PrintJson.printJsonFlag(response, flag);

    }

    private void getUserListAndActivity(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("进入到查询用户信息列表和根据信息id查询单条记录的操作");

        String id = request.getParameter("id");

        DeptActivityService as = (DeptActivityService) ServiceFactory.getService(new DeptActivityServiceImpl());

        Map<String,Object> map = as.getUserListAndActivity(id);

        PrintJson.printJsonObj(response, map);


    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("执行信息活动的删除操作");

        String[] ids = request.getParameterValues("id");

        DeptActivityService as = (DeptActivityService) ServiceFactory.getService(new DeptActivityServiceImpl());

        boolean flag = as.delete(ids);

        PrintJson.printJsonFlag(response, flag);


    }


    private void pageList(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("进入到信息活动列表的操作（结合条件查询+分页查询）");

        String owner = request.getParameter("owner");
        String deptno = request.getParameter("deptno");
        String loc = request.getParameter("loc");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String pageNoStr = request.getParameter("pageNo");
        int pageNo = Integer.parseInt(pageNoStr);
        //每页展现的记录数
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize = Integer.parseInt(pageSizeStr);
        //计算出略过的记录数
        int skipCount = (pageNo-1)*pageSize;

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("owner", owner);
        map.put("deptno", deptno);
        map.put("loc", loc);
        map.put("startDate",startDate);
        map.put("endDate",endDate);
        map.put("skipCount",skipCount);
        map.put("pageSize",pageSize);

        DeptActivityService as = (DeptActivityService) ServiceFactory.getService(new DeptActivityServiceImpl());
        PaginationVO<Object> vo = as.pageList(map);

        //vo--> {"total":100,"dataList":[{信息1},{2},{3}]}
        PrintJson.printJsonObj(response, vo);




    }

    private void creatActivity(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("创建信息活动");
        String id = UUIDUtil.getUUID();
        String owner = request.getParameter("owner");
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String createTime = DateTimeUtil.getSysTime();
        String createBy = ((User) request.getSession().getAttribute("user")).getName();
        String describetion = request.getParameter("description");

        DeptActivity deptActivity = new DeptActivity();
        deptActivity.setId(id);
        deptActivity.setOwner(owner);
        deptActivity.setDeptno(deptno);
        deptActivity.setDname(dname);
        deptActivity.setLoc(loc);
        deptActivity.setStartDate(startDate);
        deptActivity.setEndDate(endDate);
        deptActivity.setCreateBy(createBy);
        deptActivity.setCreateTime(createTime);
        deptActivity.setDescription(describetion);






        DeptActivityService as = (DeptActivityService) ServiceFactory.getService(new DeptActivityServiceImpl());

        boolean flag = as.creatActivity(deptActivity);

        PrintJson.printJsonFlag(response, flag);
    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("取得用户信息列表");
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        List<User> userList = us.getUserList();
        PrintJson.printJsonObj(response, userList);
    }


}
