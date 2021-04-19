package com.thread.hw.syn;

/**
 * @author feng
 * @date 2021/1/5
 * @Description
 */
public class DeadLock {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if ("a".equals(Thread.currentThread().getName())){
                    synchronized("资源1"){
                        synchronized("资源2"){

                        }
                    }
                }else if ("b".equals(Thread.currentThread().getName())){
                    synchronized ("资源2"){
                        synchronized("资源1"){

                        }
                    }
                }
            }
        };
        new Thread(runnable,"a").start();
        new Thread(runnable,"b").start();
    }

}
