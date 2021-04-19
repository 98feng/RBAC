package homework;

import java.util.Scanner;


public class Hw02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个数：");
        int num = sc.nextInt();

        System.out.println(pudge(num));
    }

    private static String pudge(int num) {


        return num % 2 == 0 ? num + "是偶数" : num + "是奇数";

    }
}
