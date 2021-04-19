package com.bjpowernode;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @author feng
 * @date 2021/2/2
 * @Description 模拟Http通信
 */
public class HttpTest {

    public static void main(String[] args) throws IOException {

        InetSocketAddress address = new InetSocketAddress(8083);
        HttpServer server = HttpServer.create(address, 0);

        MyHttpHandler handler = new MyHttpHandler();
        server.createContext("/myWeb", handler);
        server.start();
    }

}
