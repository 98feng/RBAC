package com.thread;

/**
 * @author feng
 * @date 2021/1/4
 * @Description
 */
public class ThreadActivityTest {

    public static void main(String[] args) {
        System.out.println("线程数量" + Thread.activeCount());//main + 垃圾回收器 一共两个线程
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "==============匿名==========" + i + "线程数量" + Thread.activeCount());//有可能为2有可能为3
            }
            //如果t线程还没有结束main就结束了，这时JVM会再启动一个新的线程：DestoryJavaVM，这个线程就是当t线程结束之后，会把JVM退出
            Thread[] threads = new Thread[Thread.activeCount()];
            Thread.enumerate(threads);//把当前线程赋值到threads数组中
            for (Thread thread1 : threads) {
                System.out.println(thread1);/*Thread[Monitor Ctrl-Break,5,main]
                                              Thread[Thread-0,5,main]
                                              Thread[DestroyJavaVM,5,main]*/
            }

        });
        System.out.println(Thread.activeCount());//mian + 垃圾回收器 + t 3个
        thread.start();
        System.out.println(Thread.activeCount() + "=========" +Thread.currentThread());//mian + 垃圾回收器 + DestoryVM 3个

        for (int i = 0; i < 100; i++) {
            System.out.println("main---------" + i + "线程数量" + Thread.activeCount());//3
        }

        System.out.println(Thread.activeCount());//2，这里t线程已经结束

    }
}
