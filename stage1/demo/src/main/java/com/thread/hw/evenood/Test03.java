package com.thread.hw.evenood;

/**
 * @author feng
 * @date 2021/1/7
 * @Description
 */
public class Test03 {

    private static final Object OBJ = new Object();
    static int num = 0;//要打印的整数
    static int threadsNum = 2;
//
//    public static void main(String[] args) {
//        for (int i = 0; i < threadsNum; i++) {
//            int r = i;
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    printNum(threadsNum, r);
//                }
//            };
//            new Thread(runnable).start();
//        }
//    }

    public static void printNum(int threadsNum, int r) {
        for (int i = 0; i < 100; i++) {
            synchronized (OBJ) {
                while (num % threadsNum != r) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "============等待");
                        OBJ.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(Thread.currentThread().getName() + "============" + num);
            num++;
            synchronized (OBJ) {
                OBJ.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < threadsNum; i++) {
            int r = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        synchronized (OBJ) {
                            while (num % threadsNum != r) {
                                try {
                                    System.out.println(Thread.currentThread().getName() + "============等待");
                                    OBJ.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        System.out.println(Thread.currentThread().getName() + "============" + num);
                        num++;
                        synchronized (OBJ) {
                            OBJ.notifyAll();
                        }
                    }
                }
            };
            new Thread(runnable).start();
        }
    }


}
