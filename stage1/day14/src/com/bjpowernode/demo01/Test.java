package com.bjpowernode.demo01;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/11
 * @Description
 */
public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择要租的车：");
        String strCar = scanner.next();

        System.out.println("请输入租的天数");
        int days = scanner.nextInt();

        switch (strCar) {
            case "小轿车":
                Car car = new Car();
                System.out.println("总租金：" + car.getSumRent(days));
                break;
            case "大巴车":
                Bus bus = new Bus("大巴车1号", "陕A1123", 21);
                System.out.println("总租金" + bus.getSumRent(days));
                break;
            default:
                System.out.println("输入有误！");
                break;
        }
    }
}
