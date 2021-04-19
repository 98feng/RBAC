package com.bjpowernode.controller;

import com.bjpowernode.http.AbstractServlet;
import com.bjpowernode.http.HttpServletRequest;
import com.bjpowernode.http.HttpServletResponse;

import java.io.IOException;

public class OneServlet<E> extends AbstractServlet {
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String userName = request.getParameter("userName");
        String result = userName + "使用OneServlet获得帮助";
        response.setContentType("text/html;charset=utf-8");
        response.print(result);
    }
}
