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
import com.bjpowernode.deptmanage.workbench.domain.EmpActivity;
import com.bjpowernode.deptmanage.workbench.domain.EmpActivityRemark;
import com.bjpowernode.deptmanage.workbench.service.EmpActivityService;
import com.bjpowernode.deptmanage.workbench.service.impl.EmpActivityServiceImpl;

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
@SuppressWarnings({"all"})
public class EmpActivityController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入到信息活动控制器");

        String path = request.getServletPath();

        if ("/workbench/empActivity/getUserList.do".equals(path)) {

            getUserList(request, response);
        } else if ("/workbench/empActivity/creatActivity.do".equals(path)) {

            creatActivity(request, response);
        }else if ("/workbench/empActivity/pageList.do".equals(path)) {

            pageList(request, response);
        }else if("/workbench/empActivity/delete.do".equals(path)){

            delete(request,response);

        }else if("/workbench/empActivity/getUserListAndActivity.do".equals(path)){

            getUserListAndActivity(request,response);

        }else if("/workbench/empActivity/update.do".equals(path)){

            update(request,response);

        }else if("/workbench/empActivity/detail.do".equals(path)){

            detail(request,response);

        }else if("/workbench/empActivity/getRemarkListByAid.do".equals(path)){

            getRemarkListByAid(request,response);

        }else if("/workbench/empActivity/deleteRemark.do".equals(path)){

            deleteRemark(request,response);

        }else if("/workbench/empActivity/saveRemark.do".equals(path)){

            saveRemark(request,response);

        }else if("/workbench/empActivity/updateRemark.do".equals(path)){

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

        EmpActivityService as = (EmpActivityService) ServiceFactory.getService(new EmpActivityServiceImpl());

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

        EmpActivityService as = (EmpActivityService) ServiceFactory.getService(new EmpActivityServiceImpl());

        boolean flag = as.saveRemark(ar);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success", flag);
        map.put("ar", ar);

        PrintJson.printJsonObj(response, map);


    }

    private void deleteRemark(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("删除备注操作");

        String id = request.getParameter("id");

        EmpActivityService as = (EmpActivityService) ServiceFactory.getService(new EmpActivityServiceImpl());

        boolean flag = as.deleteRemark(id);

        PrintJson.printJsonFlag(response, flag);


    }

    private void getRemarkListByAid(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("根据信息id，取得备注信息列表");

        String activityId = request.getParameter("activityId");

        EmpActivityService as = (EmpActivityService) ServiceFactory.getService(new EmpActivityServiceImpl());

        List<Object> arList = as.getRemarkListByAid(activityId);

        PrintJson.printJsonObj(response, arList);



    }

    private void detail(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        System.out.println("进入到跳转到详细信息页的操作");

        String id = request.getParameter("id");

        EmpActivityService as = (EmpActivityService) ServiceFactory.getService(new EmpActivityServiceImpl());

        EmpActivity a = (EmpActivity) as.detail(id);

        request.setAttribute("a", a);

        request.getRequestDispatcher("/workbench/activity/detailemp.jsp").forward(request, response);


    }

    private void update(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("执行信息修改操作");

        String id = request.getParameter("id");
        String owner = request.getParameter("owner");
        String ename = request.getParameter("ename");
        String job = request.getParameter("job");
        String mgr = request.getParameter("mgr");
        String sal = request.getParameter("sal");
        String comm = request.getParameter("comm");
        String startDate = request.getParameter("startDate");

        String description = request.getParameter("description");
        //修改时间：当前系统时间
        String editTime = DateTimeUtil.getSysTime();
        //修改人：当前登录用户
        String editBy = ((User)request.getSession().getAttribute("user")).getName();

        EmpActivity a = new EmpActivity();
        a.setId(id);
        a.setStartDate(startDate);
        a.setOwner(owner);
        a.setEname(ename);
        a.setJob(job);
        a.setSal(sal);
        a.setComm(comm);
        a.setMgr(mgr);

        a.setDescription(description);
        a.setEditBy(editBy);
        a.setEditTime(editTime);

        EmpActivityService as = (EmpActivityService) ServiceFactory.getService(new EmpActivityServiceImpl());

        boolean flag = as.update(a);

        PrintJson.printJsonFlag(response, flag);

    }

    private void getUserListAndActivity(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("进入到查询用户信息列表和根据信息id查询单条记录的操作");

        String id = request.getParameter("id");

        EmpActivityService as = (EmpActivityService) ServiceFactory.getService(new EmpActivityServiceImpl());

        Map<String,Object> map = as.getUserListAndActivity(id);

        PrintJson.printJsonObj(response, map);


    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("执行信息活动的删除操作");

        String[] ids = request.getParameterValues("id");

        EmpActivityService as = (EmpActivityService) ServiceFactory.getService(new EmpActivityServiceImpl());

        boolean flag = as.delete(ids);

        PrintJson.printJsonFlag(response, flag);


    }


    private void pageList(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("进入到信息活动列表的操作（结合条件查询+分页查询）");

        String owner = request.getParameter("owner");
        String ename = request.getParameter("ename");
        String mgr = request.getParameter("mgr");
        String sal = request.getParameter("sal");
        String job = request.getParameter("job");
        String comm = request.getParameter("comm");
        String startDate = request.getParameter("startDate");

        String pageNoStr = request.getParameter("pageNo");
        int pageNo = Integer.parseInt(pageNoStr);
        //每页展现的记录数
        String pageSizeStr = request.getParameter("pageSize");
        int pageSize = Integer.parseInt(pageSizeStr);
        //计算出略过的记录数
        int skipCount = (pageNo-1)*pageSize;

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("owner", owner);
        map.put("ename", ename);
        map.put("mgr", mgr);
        map.put("sal", sal);
        map.put("job", job);
        map.put("comm", comm);
        map.put("startDate",startDate);
        map.put("skipCount",skipCount);
        map.put("pageSize",pageSize);

        EmpActivityService as = (EmpActivityService) ServiceFactory.getService(new EmpActivityServiceImpl());
        PaginationVO<Object> vo = as.pageList(map);

        //vo--> {"total":100,"dataList":[{信息1},{2},{3}]}
        PrintJson.printJsonObj(response, vo);




    }

    private void creatActivity(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("创建信息活动");
        String id = UUIDUtil.getUUID();
        String owner = request.getParameter("owner");
        String ename = request.getParameter("ename");
        String job = request.getParameter("job");
        String sal = request.getParameter("sal");
        String comm = request.getParameter("comm");
        String mgr = request.getParameter("mgr");
        String startDate = request.getParameter("startDate");
        String createTime = DateTimeUtil.getSysTime();
        String createBy = ((User) request.getSession().getAttribute("user")).getName();
        String describetion = request.getParameter("description");

        EmpActivity activity = new EmpActivity();
        activity.setId(id);
        activity.setOwner(owner);
        activity.setEname(ename);
        activity.setJob(job);
        activity.setSal(sal);
        activity.setComm(comm);
        activity.setMgr(mgr);
        activity.setStartDate(startDate);
        activity.setCreateBy(createBy);
        activity.setCreateTime(createTime);
        activity.setDescription(describetion);
        EmpActivityService as = (EmpActivityService) ServiceFactory.getService(new EmpActivityServiceImpl());

        boolean flag = as.creatActivity(activity);

        PrintJson.printJsonFlag(response, flag);
    }

    private void getUserList(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("取得用户信息列表");
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        List<User> userList = us.getUserList();
        PrintJson.printJsonObj(response, userList);
    }


}
