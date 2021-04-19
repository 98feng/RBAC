package com.thread.hw.syn;

/**
 * @author feng
 * @date 2021/1/5
 * @Description
 */
public class Test03 {

    public static void main(String[] args) {

        Test03 test03 = new Test03();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test03.method01();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                test03.method01();

            }
        }).start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (Test03.class) {
                    for (int i = 0; i < 100; i++) {
                        System.out.println(Thread.currentThread().getName() + "==========" + i);
                    }
                }
            }
        };
        new Thread(runnable,"t1").start();
        new Thread(runnable,"t2").start();
        for (int i = 0; i < 1000000; i++) {
            new Thread(runnable,String.valueOf(i)).start();
        }

    }

    private void method01() {
        synchronized (Test03.class) {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + "==========" + i);
            }
        }
    }
}
