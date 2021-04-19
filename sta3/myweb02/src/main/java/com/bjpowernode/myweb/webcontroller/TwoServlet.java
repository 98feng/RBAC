package com.bjpowernode.myweb.webcontroller;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class TwoServlet extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("TwoServlet被Tomcat调用为用户提供服务");

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String  method = request.getMethod();
        if("get".equalsIgnoreCase(method)){
             this.doGet(servletRequest,servletResponse);
        }else if("post".equalsIgnoreCase(method)){
             this.doGet(servletRequest,servletResponse);
        }
    }

    public void doGet(ServletRequest servletRequest, ServletResponse servletResponse){
        System.out.println("TwoServlet中doGet方法被调用处理GET请求方式");
    }
    public void doPost(ServletRequest servletRequest, ServletResponse servletResponse){
        System.out.println("TwoServlet中doPost方法被调用处理Post请求方式");
    }
}
