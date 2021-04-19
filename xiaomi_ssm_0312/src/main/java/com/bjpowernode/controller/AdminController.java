package com.bjpowernode.controller;

import com.bjpowernode.domain.Admin;
import com.bjpowernode.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author feng
 * @date 2021/3/12
 * @Description
 */
@Controller
public class AdminController {
    @Autowired
    AdminService as;

    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request) {

        System.out.println("登录控制器");
        Admin admin = as.login(name, pwd);


        if (admin != null) {

            return "main";
        }
        request.setAttribute("errmsg", "用户名密码不正确！");
        return "login";

    }
}
