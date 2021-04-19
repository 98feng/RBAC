package com.thread;

/**
 * 有时会在线程中根据线程的中断标志来决定是否结束线程
 * \isInterrupted()默认是false，查看当前线程的终止状态
 */
public class TestInterupted {

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName() + " ============" + i + Thread.currentThread().isInterrupted());
                    /*run方法结束，线程结束*/
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }
                }
            }
        });
        System.out.println(t1.isAlive());
        t1.start();
        System.out.println(t1.isAlive());

        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        for (int i = 0; i < 300; i++) {
            System.out.println("main============" + i);
            if (i == 30) {
                t1.interrupt();  //中断t1线程

            }
        }
        System.out.println(t1.isAlive());
    }
}
