package bjpowernode.homework03;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/8
 * @Description 4.输入一个正整数，逆序输出，比如：123逆序结果：321    ，12345逆序结果54321
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数：");


        String num = scanner.next();

        char[] chars = num.toCharArray();


        for (int i = chars.length-1; i >= 0; i--) {
            System.out.print(chars[i] + "\t");
        }


    }

}

