package com.bjpowernode.demo03;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/15
 * @Description
 */
public class Test4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入时间：");
        int h = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();


        if (h >= 0 && h <= 23 && m >= 0 && m <= 59 && s >= 0 && s <= 59) {
            if (h == 0 && m == 0 && s == 0) {
                System.out.println(23 + ":" + 59 + ":" + 59);
            } else if (m == 0 && s == 0) {
                System.out.println((h - 1) + ":" + 59 + ":" + 59);
            } else if (s == 0) {
                System.out.println(h + ":" + (m - 1) + ":" + 59);
            } else {
                System.out.println(h + ":" + m + ":" + (s - 1));
            }
        } else {
            System.out.println("输入有误！");

        }


    }
}
