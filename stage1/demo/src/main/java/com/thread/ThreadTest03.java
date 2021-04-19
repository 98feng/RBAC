package com.thread;

/**
 * @author feng
 * @date 2020/12/29
 * @Description
 */
public class ThreadTest03 implements Runnable {


    private int ticket = 10;


    @Override
    public synchronized void run() {
        while (true) {
            if (ticket <= 0) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了" + ticket + "票");
            ticket --;
        }
    }


    public static void main(String[] args) {
        ThreadTest03 test03 = new ThreadTest03();
        new Thread(test03, "小明").start();
        new Thread(test03, "老师").start();
        new Thread(test03, "黄牛党").start();
    }
}
