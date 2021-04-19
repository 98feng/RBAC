package com.thread.hw.syn;

/**
 * @author feng
 * @date 2021/1/5
 * @Description
 */
public class Test01 {

    static int s = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    s++;
                }
                System.out.println(Thread.currentThread().getName() +"循环10000次之后结果"+ s);
            }
        };

        Thread t1 = new Thread(runnable, "t1");
        Thread t2 = new Thread(runnable, "t2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(s);

    }
}
