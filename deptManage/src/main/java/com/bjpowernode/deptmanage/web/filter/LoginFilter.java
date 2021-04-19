package com.bjpowernode.deptmanage.web.filter;

import com.bjpowernode.deptmanage.settings.domain.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(value = "/*.",filterName = "")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        System.out.println("进入到验证有没有登录过的过滤器");

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String path = request.getServletPath();

        //不应该被拦截的资源，自动放行请求
        if ("/login.jsp".equals(path) || "/settings/user/login.do".equals(path)) {

            chain.doFilter(req, resp);
            //其他资源必须验证有没有登录过
        } else {

            HttpSession session = ((HttpServletRequest) req).getSession();
            ServletContext application = request.getServletContext();
            //获取请求中的所有cookie，得到cookies数组
            Cookie[] cookies = ((HttpServletRequest) req).getCookies();

            if (cookies != null && cookies.length > 0) {
                for (Cookie cookie : cookies) {
                    System.out.println("cookie.getName() = " + cookie.getName());
                    //如果cookie的名称为session
                    if ("session".equals(cookie.getName())) {
                        //则读取这个cookie的值，得到sessionid
                        //然后再根据sessionid，获取储存在应用域中的session对象
                        session = (HttpSession) application.getAttribute(cookie
                                .getValue());
                        System.out.println("cookie.getValue() = " + cookie.getValue());
                    }
                }
            }

            User user = (User) session.getAttribute("user");

            //如果user不为null，说明登录过
            if (user != null) {

                chain.doFilter(req, resp);
                //没有登录过
            } else {

                response.sendRedirect(request.getContextPath() + "/login.jsp");

            }


        }

    }


}
