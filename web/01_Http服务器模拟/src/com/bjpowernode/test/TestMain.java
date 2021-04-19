package com.bjpowernode.test;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;

/**
 *
 * 测试:
 *
 * 第一步：启动Http服务器
 * 第二步：打开浏览器，由浏览器向Http服务器发送请求
 *       http://服务端计算机IP地址:服务器端口号/服务器别名
 *
 *       例子：
 *       http://localhost:8082/myWeb
 */
public class TestMain {

    public static void main(String[] args)throws Exception {

        //1.向当前计算机申请一个端口号
        InetSocketAddress address = new InetSocketAddress(8082);
        //2.创建Http服务器实例对象并绑定端口号
        HttpServer server= HttpServer.create(address,0);//0表示单位时间访问量为默认访问量 20
        //3.指定帮助Http服务器处理请求协议包和响应协议包的HttpHandler对象
        /*
        * server.createContext("http服务器对外别名",HttpHandler对象)
        */
        HttpHandler handler = new MyHttpHandler();
        server.createContext("/myWeb",handler);
        //4.启动Http服务器
        server.start();


    }

    static class MyHttpHandler implements HttpHandler{

        //handle方法在Http服务器每次接收到一个Http请求协议包后被自动调用
        //HttpExchange可以具体对请求协议包和响应协议包进行处理
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            System.out.println("Http服务器接收到浏览器发送的一次请求");
            System.out.println("请求行:");
            String method =httpExchange.getRequestMethod();//读取请求行请求方式
            System.out.println("method : --------"+method);
            URI uri = httpExchange.getRequestURI();
            String path = uri.getPath();//读取请求行请求地址
            System.out.println("uri : ---------"+path);
            String params = uri.getQuery();//读取请求行携带请求参数 请求参数名=值&请求参数名=值
            System.out.println("request params:-------"+params);

            //----------------设置响应包----------------------
             //1.将处理结果解析为二进制数据
             String result="欢迎来到动力节点";
             StringBuilder builder = new StringBuilder();
             builder.append("<html>");
             builder.append("<body>");
             builder.append("<center>");
             builder.append("<font style='color:red;font-size:45px'>");
             builder.append(result);
             builder.append("</font>");
             builder.append("</center>");
             builder.append("</body>");
             builder.append("</html>");
             byte[] responseContent= builder.toString().getBytes("utf-8");
             //2.设置响应头中Content-type
             Headers headers =httpExchange.getResponseHeaders();
             headers.add("Content-type", "text/html;charset=utf-8");
             //3.设置状态行中状态码以及处理结果长度
             httpExchange.sendResponseHeaders(200, responseContent.length);
             //4.将二进制形态的处理结果通过输出流写入到响应体
             OutputStream out =httpExchange.getResponseBody();
             out.write(responseContent);
             out.flush();
             out.close();

        }
    }
}
