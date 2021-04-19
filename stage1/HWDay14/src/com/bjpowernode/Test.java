package com.bjpowernode;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/12
 * @Description 7.键盘输入正数和负数，分别统计正数的个数和负数的个数，计算所有数的和，当输入0时程序结束
 */
public class Test {
    /**
     * 输入的数
     */
    static int num1;
    /**
     * 正整数的个数
     */
    static int num2;
    /**
     * 负数的个数
     */
    static int num3;
    /**
     * 输入的数之和
     */
    static int flag;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("请输入一个数: ");
            num1 = scanner.nextInt();
            System.out.println(pudge(num1));
            System.out.println("和为：" + sum());
            if (num1 == 0) return;
         }
    }

    private static String pudge(int num1) {
        return num1 > 0 ? "正数个数：" + (++num2) : "负数的个数为：" + (++num3);
    }

    private static int sum() {

        return flag += num1;
    }
}
