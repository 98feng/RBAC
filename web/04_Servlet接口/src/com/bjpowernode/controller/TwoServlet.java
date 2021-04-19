package com.bjpowernode.controller;

import com.bjpowernode.http.Servlet;
import com.bjpowernode.http.HttpServletRequest;
import com.bjpowernode.http.HttpServletResponse;

import java.io.IOException;

public class TwoServlet implements Servlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

             String userName =request.getParameter("userName");
             String result =userName+"使用TwoServlet获得了服务";
             response.setContentType("text/html;charset=utf-8");
             response.print(result);
    }
}
