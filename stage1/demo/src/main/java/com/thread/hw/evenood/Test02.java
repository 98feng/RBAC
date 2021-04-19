package com.thread.hw.evenood;

/**
 * @author feng
 * @date 2021/1/16
 * @Description
 */
public class Test02 {

    static int num = 0;
    private static final Object OBJ = new Object();

    public static void main(String[] args) {
        getRunnable(2);

    }
    private static void getRunnable(int threadNum) {
        for (int j = 0; j < threadNum; j++) {
            int finalJ = j;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        synchronized (OBJ) {
                            while (num % threadNum != finalJ) {
                                try {
                                    OBJ.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println(Thread.currentThread().getName() + "==========" + num);
                            num++;
                            OBJ.notify();
                        }
                    }
                }
            };
            new Thread(runnable).start();

        }
    }
}
