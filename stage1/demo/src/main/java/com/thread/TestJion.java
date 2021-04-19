package com.thread;

/**
 * @author feng
 * @date 2020/12/30
 * @Description
 */
public class TestJion implements Runnable {
    static int x = 1;

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            ++ x;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new TestJion(), "t1");
        t1.start();

        t1.join();

        System.out.println(x);
//        System.out.println(x++);//1001
        System.out.println(++x);//1002
    }
    /*@Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("Vip--->" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestJion testJion = new TestJion();
        Thread thread = new Thread(testJion);
        thread.start();


        for (int i = 0; i < 500; i++) {
            System.out.println(Thread.currentThread().getName() + "mian---->" + i);
            if (i == 300){
                thread.join();
            }

        }
    }*/
}
