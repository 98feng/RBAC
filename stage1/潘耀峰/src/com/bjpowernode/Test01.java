package com.bjpowernode;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/10
 * @Description 1.编写Java代码，根据输入存款金额，输出是富裕家庭、中产家庭、小康家庭还是困难家庭。
 */
public class Test01 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入存款：");

        double v = scanner.nextDouble();
        if(v < 0) return;

        if(v > 1000000000.0){
            System.out.println("富裕家庭");

        }else if(v > 10000000.0){
            System.out.println("中产家庭");
        }else if(v > 1000000.0){
            System.out.println("小康家庭");
        }else{
            System.out.println("困难家庭");
        }
    }
}
