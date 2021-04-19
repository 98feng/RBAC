package com.thread;

/**
 * @author feng
 * @date 2020/12/30
 * @Description  线程让步，是有可能不让步的
 */
public class TestYield implements Runnable{
    public static void main(String[] args) {

        TestYield testYield = new TestYield();
        new Thread(testYield,"a").start();
        new Thread(testYield,"c").start();
        new Thread(testYield,"d").start();
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "end");
    }

/*
    public static void main(String[] args) {

        TestYield testYield = new TestYield();
        new Thread(testYield,"a").start();
        new Thread(testYield,"b").start();
    }


    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + "start");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "end");
    }*/


}
