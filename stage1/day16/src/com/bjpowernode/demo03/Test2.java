package com.bjpowernode.demo03;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/15
 * @Description
 */
public class Test2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符：");
        char c = scanner.next().charAt(0);

        if ('z' >= c && c >= 'a') {
            System.out.println("小写字母");
        } else if ('Z' >= c && c >= 'A') {
            System.out.println("大写字母");
        } else if ('0' <= c && c <= '9') {
            System.out.println("数字字符");
        } else {
            System.out.println("输入有误！");
        }
    }
}
