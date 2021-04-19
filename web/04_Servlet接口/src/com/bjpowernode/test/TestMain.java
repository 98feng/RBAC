package com.bjpowernode.test;

import com.bjpowernode.http.HttpServletRequest;
import com.bjpowernode.http.HttpServletResponse;
import com.bjpowernode.http.Servlet;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试:
 * <p>
 * 第一步：启动Http服务器
 * 第二步：打开浏览器，由浏览器向Http服务器发送请求
 * http://服务端计算机IP地址:服务器端口号/服务器别名
 * <p>
 * 例子：
 * http://localhost:8082/myWeb
 */
public class TestMain {

    public static void main(String[] args) throws Exception {

        //1.向当前计算机申请一个端口号
        InetSocketAddress address = new InetSocketAddress(8082);
        //2.创建Http服务器实例对象并绑定端口号
        HttpServer server = HttpServer.create(address, 0);//0表示单位时间访问量为默认访问量 20
        //3.指定帮助Http服务器处理请求协议包和响应协议包的HttpHandler对象
        /*
         * server.createContext("http服务器对外别名",HttpHandler对象)
         */
        HttpHandler handler = new MyHttpHandler();
        server.createContext("/myWeb", handler);
        //4.启动Http服务器
        server.start();


    }

    static class MyHttpHandler implements HttpHandler {

        //handle方法在Http服务器每次接收到一个Http请求协议包后被自动调用
        //HttpExchange可以具体对请求协议包和响应协议包进行处理
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {

            //创建一个HttpServletRequest对象保存本次浏览器发送的请求协议包中信息
            HttpServletRequest request = createRequest(httpExchange);
            //创建一个HttpServletResponse响应对象负责提供对响应包操作
            HttpServletResponse response = new HttpServletResponse(httpExchange);

            /*
             * 假设用户向Http服务器索要OneServlet
             *
             * http://localhost:8082/myWeb/com.bjpowernode.controller.OneServlet
             */
            //-------------------根据用户请求调用动态资源文件进行处理------------start
            //1.通过请求对象得到浏览器要访问的资源文件地址
            String uri = request.getRequestUri();
            String classPath = uri.substring(uri.lastIndexOf("/") + 1);

            try {
                //2.根据需求将用户请求的动态资源文件加载到内存
                Class classManager = Class.forName(classPath);
                //3.向JVM申请创建当前类文件的实例对象
                Servlet instance = (Servlet) classManager.newInstance();//要求JVM调用当前类文件中无参构造方法创建一个实例对象
                //4.通过实例对象调用方法为用户提供服务
                instance.service(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //-------------------根据用户请求调用动态资源文件进行处理------------end


        }

        //创建一个HttpServletRequest实例对象，用于存储本次Http请求协议包相关信息，降低对Http请求协议包信息操作难度
        public HttpServletRequest createRequest(HttpExchange httpExchange) {

            HttpServletRequest request = null;
            URI uri = null;
            Map map = new HashMap();
            String method = null;
            String queryString = null;
            String requestUri = null;

            //读取请求行中请求方式
            method = httpExchange.getRequestMethod();
            //读取请求行中请求参数信息
            uri = httpExchange.getRequestURI();
            queryString = uri.getQuery(); //[userName=mike&password=123] or [userName=mike]
            if (queryString != null && !("").equals(queryString)) {
                if (queryString.contains("&")) {
                    String array_1[] = queryString.split("&"); //["userName=mike","password=123"]
                    for (String param : array_1) {
                        String array_2[] = param.split("="); //["userName","mike"]
                        map.put(array_2[0], array_2[1]);
                    }
                } else {
                    String array_1[] = queryString.split("="); //["userName","mike"]
                    map.put(array_1[0], array_1[1]);
                }
            }
            //获得被访问的资源文件地址
            requestUri = uri.getPath();

            request = new HttpServletRequest(method, map, requestUri);

            return request;
        }
    }
}
