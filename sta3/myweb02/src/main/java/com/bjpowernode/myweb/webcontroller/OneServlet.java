package com.bjpowernode.myweb.webcontroller;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class OneServlet extends HttpServlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("OneServlet被tomcat调用来解决用户问题");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
