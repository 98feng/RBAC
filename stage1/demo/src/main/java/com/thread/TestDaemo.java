package com.thread;

/**
 * @author feng
 * @date 2020/12/30
 * @Description 守护线程
        *
        * 虚拟机必须确保用户线程执行完毕，虚拟机不用等待守护线程执行完毕
        * 入后记录操作日志监控内存，垃圾回收等
        */
public class TestDaemo {
    public static void main(String[] args) {

        You you = new You();
        God god = new God();

        Thread godThread = new Thread(god);
        godThread.setDaemon(true);//默认是false表示用户线程。正常线程都是用户线程true表示守线程
        godThread.start();
        Thread youThread = new Thread(you);
        youThread.start();
    }

}

class God implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("DAEMO");

        }
    }
}

class You implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("HAPPY_EVERY_DAY!");
        }
        System.out.println("GOOD_BYR_WORLD!");
    }

}
