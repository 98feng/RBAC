package com.thread;

/**
 * @author feng
 * @date 2020/12/30
 * @Description getState()获取线程的状态
 */
public class TestState {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread.State state = thread.getState();
        System.out.println(state);//NEW

        thread.start();
        state = thread.getState();
        System.out.println(state);//RUNNABLE

        /*只要线程不终止，就一直处于输出状态*/
        while(state != Thread.State.TERMINATED){
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);//TIMED_WAITING
        }

        /*线程死亡后不能再启动*/
        thread.start();

    }

}
