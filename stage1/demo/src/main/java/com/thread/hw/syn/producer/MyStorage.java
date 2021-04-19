package com.thread.hw.syn.producer;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * @author feng
 * @date 2021/1/7
 * @Description
 */
public class MyStorage {

    //定义一个容器存储数据
    private List list = new ArrayList();
    private static final int MAX_CAPACITY = 10;

    /**
     * 生产者生产
     *
     * @param data
     */
    public synchronized void add(Object data) {

        //仓库已满进入等待
        while (list.size() == MAX_CAPACITY) {
            try {
                this.wait();
                System.out.println(Thread.currentThread().getName() + "waitting .........");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存储数据
        list.add(data);
        System.out.println(Thread.currentThread().getName() + "，生产了" + data);
        //通知消费者消费
        this.notifyAll();
    }


    /**
     * 消费者消费
     */
    public synchronized void take() {
        //仓库为空等待
        while (list.isEmpty()) {
            try {
                this.wait();
                System.out.println(Thread.currentThread().getName() + "waitting..........");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //取数据
        Object data = list.remove(0);
        System.out.println(Thread.currentThread().getName() + "消费"+ data +"仓库的容量" + list.size());
        //通知生产者生产
        this.notifyAll();
    }

    /**
     * @author feng
     * @date 2021/1/7
     * @Description
     */
    @Data
    @AllArgsConstructor
    public static class Product implements Runnable{

        private MyStorage myStorage;

        @Override
        public void run() {
            Random random = new Random();
            for (int i = 0; i < 30; i++) {
                myStorage.add(random.nextInt(100));
            }
        }
    }

    /**
     * @author feng
     * @date 2021/1/7
     * @Description
     */
    @Data
    @AllArgsConstructor
    public static class Consumer implements Runnable {
        private MyStorage myStorage;

        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                myStorage.take();
            }
        }
    }
    /**
     * @author feng
     * @date 2021/1/7
     * @Description
     */
    public static class Test01 {
        public static void main(String[] args) {
            MyStorage myStorage = new MyStorage();
            Product product = new Product(myStorage);
            for (int i = 0; i < 3; i++) {
                new Thread(product,"生产者" + i).start();
            }
            Consumer consumer = new Consumer(myStorage);
            for (int i = 0; i < 3; i++) {
                new Thread(consumer,"消费者" + i).start();
            }
        }
    }

}

