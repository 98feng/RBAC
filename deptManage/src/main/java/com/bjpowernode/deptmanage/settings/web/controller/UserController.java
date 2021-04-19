package com.bjpowernode.deptmanage.settings.web.controller;

import com.bjpowernode.deptmanage.exception.LoginException;
import com.bjpowernode.deptmanage.settings.domain.User;
import com.bjpowernode.deptmanage.settings.service.UserService;
import com.bjpowernode.deptmanage.settings.service.impl.UserServiceImpl;
import com.bjpowernode.deptmanage.utils.MD5Util;
import com.bjpowernode.deptmanage.utils.PrintJson;
import com.bjpowernode.deptmanage.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author feng
 * @date 2020/10/11 - 10:20
 * @Description
 */
public class UserController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入登录控制器");
        String path = request.getServletPath();
        if ("/settings/user/login.do".equals(path)) {
            login(request, response);
        }

    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String loginAct = request.getParameter("loginAct");
        String loginPwd = request.getParameter("loginPwd");
        HttpSession session = request.getSession();
        loginPwd = MD5Util.getMD5(loginPwd);
        String ip = request.getRemoteAddr();

        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        try {
            User user = us.login(loginAct, loginPwd, ip);


            session.setAttribute("user", user);
            Cookie cookie = new Cookie("session", session.getId());
            System.out.println("session.getId() = " + session.getId());
            //设置cookie的有效时间
            cookie.setMaxAge(Integer.MAX_VALUE);
            //将cookie添加到响应行
            response.addCookie(cookie);
            //此时需要在应用域中添加一个属性，用于储存用户的sessionid和对应的session关系
            //以保证后面可以根据sessionid获取到session
            getServletContext().setAttribute(session.getId(), session);
            System.out.println("session = " + session);


            PrintJson.printJsonFlag(response, true);
        } catch (LoginException e) {
            e.printStackTrace();
            String msg = e.getMessage();

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", false);
            map.put("msg", msg);
            PrintJson.printJsonObj(response, map);
        }
    }
}
