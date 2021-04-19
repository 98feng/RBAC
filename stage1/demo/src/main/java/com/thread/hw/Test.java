package com.thread.hw;

/**
 * 宋秋宇
 * 日期:2021/1/4
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Person p1 = new Person(100);
        Person p2 = new Person(100);
        Person p3 = new Person(100);
        Person p4 = new Person(100);
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        Thread.sleep(100);
        System.out.println("银行余额：" + Person.allMoney);
        System.out.println("p1现有资金：" + p1.nowMoney);
        System.out.println("p2现有资金：" + p2.nowMoney);
        System.out.println("p3现有资金：" + p3.nowMoney);
        System.out.println("p4现有资金：" +p4.nowMoney);
    }
}
