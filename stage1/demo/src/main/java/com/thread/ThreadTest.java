package com.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author feng
 * @date 2020/12/28
 * @Description
 */
public class ThreadTest extends Thread{

    private String url;
    private String file;

    public ThreadTest(String url, String file) {
        this.url = url;
        this.file = file;
    }


    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.webDownLoader(url,file);
        System.out.println("下载了·" + file);
    }

    public static void main(String[] args) {

        ThreadTest thread1 = new ThreadTest("http://p8.itc.cn/q_70/images03/20201217/3cd09be170ea4361b64e915b607d7dc1.jpeg", "2.jpeg");
        ThreadTest thread2 = new ThreadTest("http://p8.itc.cn/q_70/images03/20201217/3cd09be170ea4361b64e915b607d7dc1.jpeg", "3.jpeg");
        ThreadTest thread3 = new ThreadTest("http://p8.itc.cn/q_70/images03/20201217/3cd09be170ea4361b64e915b607d7dc1.jpeg", "23.jpeg");
        //先
        thread1.start();
        //后
        thread2.start();
        //最后
        thread3.start();


    }
}

//下载方法
class WebDownLoader {
    public void webDownLoader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ioException");
        }
    }
}
