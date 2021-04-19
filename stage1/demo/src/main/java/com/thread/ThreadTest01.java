package com.thread;

/**
 * @author feng
 * @date 2020/12/29
 * @Description
 * * 1. 创建一个继承于Thread类的子类
 * * 2. 重写Thread类的run() --> 将此线程执行的操作声明在run()中
 * * 3. 创建Thread类的子类的对象
 * * 4. 通过此对象调用start()：①启动当前线程 ② 调用当前线程的run()
 */
public class ThreadTest01 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("我在学习多线程");
        }
    }


    public static void main(String[] args) {

        ThreadTest01 test01 = new ThreadTest01();
        test01.start();

        for (int i = 0; i < 100; i++) {

            System.out.println("我在写代码");
        }
    }
}
