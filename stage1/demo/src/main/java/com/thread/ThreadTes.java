package com.thread;

/**
 * @author feng
 * @date 2020/12/28
 * @Description
 */
public class ThreadTes implements Runnable{

    private String url;
    private String file;

    public ThreadTes(String url, String file) {
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


        new Thread(thread1).start();
        new Thread(thread2).start();
        new Thread(thread3).start();


    }
}

