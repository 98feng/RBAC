package com.bjpowernode.controller;

import com.bjpowernode.pojo.Users;
import com.sun.deploy.net.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 动力节点
 * 2021/3/9
 */
@Controller
@RequestMapping("/data")
public class MyData {

    @RequestMapping("/one")
    public String one(String uname, int uage) {
        System.out.println("uname=" + uname + ",uage=" + (uage + 100));  //122  22+100  22100
        return "main";
    }

    @RequestMapping("/two")
    public String two(Users users) {
        System.out.println("uname=" + users.getUname() + ",uage=" + (users.getUage() + 100));
        return "main";
    }

    @RequestMapping("/three/{name}/{age}")
    public String three(
            @PathVariable("name")
                    String uname,
            @PathVariable("age")
                    int uage) {
        System.out.println("uname=" + uname + ",uage=" + (uage + 100));
        return "main";
    }

    @RequestMapping("/four")
    public String four(
            @RequestParam(value = "name")
                    String name,
            @RequestParam(value = "age")
                    int age) {
        System.out.println("name=" + name + ",age=" + (age + 100));
        return "main";
    }

    @RequestMapping("/five")
    public String five(HttpServletRequest request) {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("name=" + name + ",age=" + (age + 100));
        return "main";
    }


    @RequestMapping("/requestJsp")
    public String requestJsp(){
        System.out.println("请求转发跳jsp");
        return "main";
    }

    @RequestMapping("/requestAction")
    public String requestAction(){
        System.out.println("请求转发跳action");
        return "forward:/one.action";
    }

    @RequestMapping("/responseJsp")
    public String responseJsp(){
        System.out.println("重定向跳页面");
        return "redirect:/admin/main.jsp";
    }

    @RequestMapping("/responseAction")
    public String responseAction(){
        System.out.println("重定向跳Action");
        return "redirect:/one.action";
    }
}
