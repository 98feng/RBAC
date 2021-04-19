package com.thread;

/**
 * @author feng
 * @date 2020/12/28
 * @Description 方式二：实现Runnable接口的方式：
 * * 1. 创建一个实现了Runnable接口的类
 * * 2. 实现类去实现Runnable中的抽象方法：run()
 * * 3. 创建实现类的对象
 * * 4. 将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * * 5. 通过Thread类的对象调用start()
 */
public class ThreadTest02 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1100; i++) {
            System.out.println(Thread.currentThread().getName() + "我在学习多线程" + i);
        }
    }


    public static void main(String[] args) {
        ThreadTest02 test02 = new ThreadTest02();
//        Thread thread = new Thread(test02);
//        thread.start();

        new Thread(test02, "匿名内部类 ----> ").start();

        for (int i = 0; i < 1100; i++) {

            System.out.println(Thread.currentThread().getName() + "我在写代码" + i);
        }


        Thread lambda = new Thread(() -> {
            for (int i = 0; i < 1100; i++) {
                System.out.println(Thread.currentThread().getName() + "===========lambda=======" + i);
            }
        });
        lambda.start();


    }
}
