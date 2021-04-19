package com.bjpowernode.demo03;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/15
 * @Description
 */
public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入三个数：");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int flag = 0;

        if (a > b){
            flag = a;
            a = b;
            b = flag;
        }

        if (b > c){
            flag = b;
            b = c;
            c = flag;
        }

        if (a > c){
            flag = a;
            c = a;
            c = flag;
        }

        System.out.println(a + "<" + b + "<" + c);


    }
}
