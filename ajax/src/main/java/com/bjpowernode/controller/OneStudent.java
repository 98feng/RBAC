package com.bjpowernode.controller;

import com.bjpowernode.ioc.domain.Student;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author feng
 * @date 2021/2/27
 * @Description
 */
@WebServlet("/one1.do")
public class OneStudent extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("dflskdjfaalskdfjlksd");
        resp.setContentType("text/html;charset=utf-8");
        Student student1 = new Student("zhangsan",18);
        Student student2 = new Student("zhangsan",18);
        Student student3 = new Student("zhangsan",18);
        HashMap<String, Student> map = new HashMap<>();
        List<Student> list = new ArrayList<>();
        map.put("stu1",student1);
        map.put("stu2",student2);
        map.put("stu3",student3);
        list.add(student1);
        list.add(student2);
        list.add(student3);
//        PrintJson.printJsonObj(resp,list);
        req.getSession().setAttribute("map",map);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("dflskdjfaalskdfjlksd");
        resp.setContentType("text/html;charset=utf-8");
        Student student1 = new Student("zhangsan",18);
        Student student2 = new Student("zhangsan",18);
        Student student3 = new Student("zhangsan",18);
        HashMap<String, Student> map = new HashMap<>();
        List<Student> list = new ArrayList<>();
        map.put("stu1",student1);
        map.put("stu2",student2);
        map.put("stu3",student3);
        list.add(student1);
        list.add(student2);
        list.add(student3);
//        PrintJson.printJsonObj(resp,list);
        req.getSession().setAttribute("map",list);
    }


}
