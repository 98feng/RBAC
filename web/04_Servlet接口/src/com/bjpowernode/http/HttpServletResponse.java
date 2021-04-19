package com.bjpowernode.http;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

/*
* 基于功能进行封装，封装对Http响应包操作功能
* 用于降低开发人员对响应包操作难度
*
* Http响应协议包内部结构
* 状态行:Http状态码
* 响应头: content-type:通知浏览器采用对应解析器和编译器对响应体
*         中二进制数据进行解析
* 空白行：
* 响应体: 以二进制形式存在处理结果
*
* 响应包操作顺序必须固定：
* 1.必须对响应头设置
* 2.必须对状态行设置
* 3.必须对响应体设置
*
*/
public class HttpServletResponse {

    HttpExchange httpExchange;

    public HttpServletResponse(HttpExchange httpExchange) {
        this.httpExchange = httpExchange;
    }

    //设置响应头ContentType
    public void setContentType(String param){
          Headers headers = httpExchange.getResponseHeaders();
          headers.add("Content-Type",param);
    }

    //将处理结果写入到响应体
    public void print(String result) throws IOException {
        StringBuilder builder = new StringBuilder();
        OutputStream out = null;
        byte array[]=null;
        //1.将处理结果写入到HTML文件
        builder.append("<html>");
        builder.append("<body>");
        builder.append("<center>");
        builder.append("<font style='color:red;font-size:45px'>");
        builder.append(result);
        builder.append("</font>");
        builder.append("</center>");
        builder.append("</body>");
        builder.append("</html>");
        //2.将html文件内容解析为二进制数据
        array = builder.toString().getBytes("utf-8");
        //3.设置状态行中Http状态码以及设置返回数据长度
         setStatus(array);
        //4.通过输出流将处理结果写入到响应体
        out = httpExchange.getResponseBody();
        out.write(array);
        out.flush();
        out.close();


    }

    //设置状态行中Http状态码以及设置返回数据长度
    public void setStatus(byte[] array)throws IOException{
        httpExchange.sendResponseHeaders(200,array.length);
    }
}
