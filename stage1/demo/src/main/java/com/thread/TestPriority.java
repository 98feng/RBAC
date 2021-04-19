package com.thread;

/**
 * @author feng
 * @date 2020/12/30
 * @Description 线程优先级1-10  觉得哪块代码比较重要需要先执行就设置优先级
 */
public class TestPriority implements Runnable {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "----> " + Thread.currentThread().getPriority());

        TestPriority testPriority = new TestPriority();
        Thread thread1 = new Thread(testPriority);
        Thread thread2 = new Thread(testPriority);
        Thread thread3 = new Thread(testPriority);
        Thread thread4 = new Thread(testPriority);
        Thread thread5 = new Thread(testPriority);
        Thread thread6 = new Thread(testPriority);

        thread1.setPriority(1);
        thread1.start();

        thread2.setPriority(Thread.MAX_PRIORITY);/*Thread.MAX_PRIORITY == 10*/
        thread2.start();

        thread3.setPriority(5);
        thread3.start();

        thread4.setPriority(6);
        thread4.start();

//        thread5.setPriority(11);
//        thread5.start();
//
//        thread6.setPriority(-1);
//        thread6.start();

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "----> " + Thread.currentThread().getPriority());
    }
}
