package com.thread.hw.syn.producer.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author feng
 * @date 2021/1/7
 * @Description
 */
public class TimerTest {

    public static void main(String[] args) {
        //创建timer对象
        Timer timer = new Timer();
//        Timer timer1 = new Timer(true);//把定时器设置为守护线程

//        timer.schedule(TimerTask task,Date time);//在指定的时间执行任务
//        timer.schedule(TimerTask task,long delay);//在delay毫秒后执行任务
        //
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //在3s之后打印一个时间，以后每个1s打印一次
                System.out.println(new Date() +"=========="+ System.currentTimeMillis());
            }
        },3000,1000);
    }
}
