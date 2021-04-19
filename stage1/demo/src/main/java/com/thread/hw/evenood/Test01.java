package com.thread.hw.evenood;

/**
 * @author feng
 * @date 2021/1/7
 * @Description
 */
public class Test01 {

    private static final Object OBJ = new Object();
    static int num = 0;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (OBJ) {
                        while (num % 2 != 0) {
                            try {
                                System.out.println(Thread.currentThread().getName() + "============等待");
                                OBJ.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + "============" + num);
                        num++;
                        OBJ.notify();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    synchronized (OBJ) {
                        while (num % 2 == 0) {
                            try {
                                System.out.println(Thread.currentThread().getName() + "=======waiting");
                                OBJ.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + "=======" + num);
                        num++;
                        OBJ.notify();
                    }
                }
            }
        }).start();
    }
}
