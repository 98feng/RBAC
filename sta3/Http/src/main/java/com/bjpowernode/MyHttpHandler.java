package com.bjpowernode;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.net.URI;

/**
 * @author feng
 * @date 2021/2/2
 * @Description
 */
public class MyHttpHandler implements HttpHandler {


    @Override
    public void handle(HttpExchange httpExchange) {
        System.out.println("Http服务器接收到浏览器发送的一次请求");
        System.out.println("请求行:");
        String method = httpExchange.getRequestMethod();//读取请求行请求方式
        System.out.println("method : --------" + method);
        URI uri = httpExchange.getRequestURI();
        String path = uri.getPath();//读取请求行请求地址
        System.out.println("uri : ---------" + path);
        String params = uri.getQuery();//读取请求行携带请求参数
        System.out.println("request params:-------" + params);
    }
}
