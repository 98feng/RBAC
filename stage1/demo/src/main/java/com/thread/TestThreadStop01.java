package com.thread;

/**
 * @author feng
 * @date 2020/12/30
 * @Description
 */
public class TestThreadStop01 implements Runnable {


    boolean flag = true;

    @Override
    public void run() {
        int count  = 1;
        while(flag){
            System.out.println(Thread.currentThread().getName() + ++count);
        }

    }
    //设置一个停止线程的方法
    private void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {

        TestThreadStop01 testThreadStop01 = new TestThreadStop01();

        new Thread(testThreadStop01).start();

        for (int i = 0; i < 1000; i++) {

            if (i == 800) {
                testThreadStop01.stop();
                System.out.println("这个线程停止了");
            }
            System.out.println("main" + i);

        }
    }

}
