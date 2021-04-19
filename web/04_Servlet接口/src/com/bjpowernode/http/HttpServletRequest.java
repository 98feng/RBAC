package com.bjpowernode.http;

import java.util.Map;

/**
 *
 * 存储本次Http请求协议包信息
 */
public class HttpServletRequest {

    private String method; //存储请求行中请求方式
    private Map map;       //存储请求行中请求参数信息 请求参数名-----请求value
    private String uri;    //存放被访问的资源文件地址

    public HttpServletRequest(String method, Map map) {
        this.method = method;
        this.map = map;
    }


    public String getMethod() {
        return method;
    }

    public HttpServletRequest setMethod(String method) {
        this.method = method;
        return this;
    }

    public HttpServletRequest(String method, Map map, String uri) {
        this.method = method;
        this.map = map;
        this.uri = uri;
    }

    //读取指定的请求参数名对应的参数内容
    public String getParameter(String paramName){
         return (String)map.get(paramName);
    }

    //读取被访问的资源文件地址
    public String getRequestUri(){
         return uri;
    }
}
