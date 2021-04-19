package com.thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author feng
 * @date 2021/1/4
 * @Description
 */
public class ThreadCallTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> task = new FutureTask<>(new Task());
        Thread thread = new Thread(task);
        thread.start();
        System.out.println("父线程获得子线程的返回结果" + task.get());
//        thread.start();
        System.out.println(thread.isAlive());
    }

}
class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int num = new Random().nextInt(200);
        System.out.println(Thread.currentThread().getName() + "子线程计算得一个结果" + num);
        return num;
    }
}
