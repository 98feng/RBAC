package com.bjpowernode.demo01;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/14
 * @Description
 */
public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请选择租的车：");
        String strVeh = scanner.next();

        System.out.println("请选择租的天数：");
        int days = scanner.nextInt();

        getRent(strVeh, days);

    }

    private static void getRent(String strVeh, int days) {

        Vehicel vehicel = null;

        switch (strVeh) {
            case "小轿车":
                vehicel = new Car(null, null);
                break;
            case "大巴车":
                vehicel = new Bus(null, null, 22);
                break;
            default:
                System.out.println("输入有误！");
                break;
        }
        if (vehicel != null)
        System.out.println("总租金:" + vehicel.getSumRent(days));
    }
}
