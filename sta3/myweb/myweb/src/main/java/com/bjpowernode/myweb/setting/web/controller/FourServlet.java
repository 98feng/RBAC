package com.bjpowernode.myweb.setting.web.controller;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/four","/login.do"})
@WebFilter()
public class FourServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("fourServlet的service()被调用");
        String servletPath = req.getServletPath();
        /*String method = req.getMethod();
        if ("GET".equalsIgnoreCase(method)){
            doGet(req,resp);
        }*/
        if ("/login.do".equals(servletPath)) {
            login(req, resp);
        } else if ("/four".equals(servletPath)) {
            get(req, resp);
        }
    }

    private void get(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("get()调用");
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("login方法被调用");
    }

}