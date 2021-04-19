package homework04;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/7
 * @Description
 */
public class HW01 {
    public static void main(String[] args) {
        //实现两个var中的值进行互换
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入第一个数num1：");
        int num1 = scanner.nextInt();
        System.out.println("请输入第一个数num2：");
        int num2 = scanner.nextInt();
        /*
        //互换
        int num3 = num1;
        num1 = num2;
        num2 = num3;*/


        //不借助中间变量//num1 = 11 ; num2 = 6
        num1 = num1 + num2;//17
        num2 = num1 - num2;//11
        num1 = num1 - num2;//6

    }
}
