package com.thread.hw;

/**
 * 宋秋宇
 * 日期:2021/1/4
 */
public class Person extends Thread{
    static int allMoney = 100;
    int nowMoney;
    int getMoney;

    public Person() {

    }

    public Person(int getMoney) {
        this.getMoney = getMoney;
    }

    @Override
    public void run() {
            //放大问题的发生性
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        if(allMoney < getMoney){
            System.out.println("对不起，银行余额不足");
            return;
        }
        allMoney -= getMoney;
        nowMoney += getMoney;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
