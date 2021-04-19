package com.thread;

/**
 * @author feng
 * @date 2020/12/29
 * @Description
 */
public class ThreadTest04 implements Runnable {

    String winner;

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            if ("兔子".equals(Thread.currentThread().getName()) && i % 10 == 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            boolean flag = gameOver(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "-----> 跑了" + i + "步");
        }
    }

    private boolean gameOver(int steps) {

        if (winner != null) {
            return true;
        }{
            if (steps >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner-->" + winner);
            }
        }


        return false;
    }

    public static void main(String[] args) {

        ThreadTest04 test04 = new ThreadTest04();
        new Thread(test04,"兔子").start();
        new Thread(test04,"乌龟").start();

    }

}
