package homework;

import java.util.Scanner;

public class Hw05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个年龄：");
        int age = scanner.nextInt();

        if (0 > age) return;

        if (age > 60) {
            System.out.println("老年");
        } else if (age > 40) {
            System.out.println("中年");
        } else if (age > 20) {
            System.out.println("青年");
        } else {
            System.out.println("少年");
        }
    }
}
