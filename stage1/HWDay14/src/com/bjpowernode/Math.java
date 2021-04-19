package com.bjpowernode;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/12
 * @Description 6.计算n！
 */
public class Math {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个数n(计算其阶乘):");
        int num = scanner.nextInt();
        System.out.println(getNum(num));
    }

    private static int getNum(int num) {

        int num1 = 1;
        for (int i = 0; i < num; i++) {
            num1 *= (num - i);
        }
        return num1;
    }
}

