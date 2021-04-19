package com.bjpowernode.http;

/**
 * @author feng
 * @date 2021/2/2
 * @Description
 */
public abstract class AbstractServlet implements Servlet {

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }
}
