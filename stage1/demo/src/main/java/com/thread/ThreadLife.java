package com.thread;

/**
 * @author feng
 * @date 2021/1/4
 * @Description
 */
public class ThreadLife {
    public static void main(String[] args) {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName() + " --> " + i);
                }
            }
        });
        System.out.println("1   `1 --- " + t.getState() );  //NEW

        t.start();
        System.out.println("22 --------" + t.getState() );  //RUNNABLE

        for (int i = 0; i < 1000; i++) {
            System.out.println("main ==> " + i );
        }
        System.out.println( "33 --------------" + t.getState());
        /*
            运行后,在33位置可能 的状态:
                RUNNABLE可运行状态, 即t线程还没有结束
                TERMINATED终止状态, t线程已经结束了
                BLOCKED阻塞状态, t线程调用println()方法前,首先需要申请System.out锁对象,当前该锁对象被main线程持有, 则t线程会转入阻塞状态,
         */
    }
}
