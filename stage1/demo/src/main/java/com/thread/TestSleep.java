package com.thread;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * @author feng
 * @date 2020/12/30
 * @Description
 * sleep不会释放锁，每个对象都有一把锁
 */
public class TestSleep {


    public static void main(String[] args) {


        while (true) {
            Date date = new Date(System.currentTimeMillis());
            String format = new SimpleDateFormat("HH:mm:ss").format(date);
            System.out.println(format);
            date = new Date(System.currentTimeMillis());

            //sleep放大问题的发生性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    private static void tenDown() throws InterruptedException {

        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            Thread.sleep(1000);
        }
    }
}
