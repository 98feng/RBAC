package com.bjpowernde;

import java.util.Random;
import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/11
 * @Description 3.猜数游戏，生成一个[1,100]之间的随机整数，
 * 提示用户输入猜测的数字，如果不相等提示用户大了还是小了，
 * 输出用户共猜测了多少次。
 */
public class Game {
    public static void main(String[] args) {


        Random random = new Random();
        int num = random.nextInt(101);
        System.out.println(num);

        Scanner scanner = new Scanner(System.in);
        System.out.println("请猜测这个数字的多少：");
        int n = scanner.nextInt();

        pudge(num, scanner, n);


    }

    private static void pudge(int num, Scanner scanner, int n) {
        for (int i = 1;; i++) {
            if (n > num) {
                System.out.println("大了，共猜测了(次)：" + i);
                n = scanner.nextInt();
            } else if (n < num) {
                System.out.println("小了，共猜测了(次)：" + i);
                n = scanner.nextInt();
            } else {
                System.out.println("正确，共猜测了(次)：" + i);
                return;
            }
        }
    }


}
