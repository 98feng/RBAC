package bjpowernode.demo01;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/11
 * @Description
 */
public class Test01 {

    static String result;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个年龄：");

        int age = scanner.nextInt();
        result = judge(age);
    }

    private static String judge(int age) {
        if (age >= 60) {
            result = "老年";
        } else if (age >= 40) {
            result = "中年";
        } else {
            result = age >= 20 ? "青年" : "少年";
        }
        return result;

    }
}
