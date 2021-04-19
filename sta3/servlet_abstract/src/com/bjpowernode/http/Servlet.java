package com.bjpowernode.http;

import java.io.IOException;
/*
*  价值:
*  1.约束了所有动态资源文件方法命名规则
*  2.降低了Http服务器调用动态资源文件解决用户问题的难度
* */
public interface Servlet {
    //定义所有动态资源文件为用户提供服务时需要调用的方法
    void service(HttpServletRequest request, HttpServletResponse response)throws IOException;

//    default String getServletInfo(){
//        return null;
//    }
//    default void destroy(){}

    String getServletInfo();

    void destroy();

}
