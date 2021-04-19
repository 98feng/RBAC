package bjpowernode.demo04;

import java.util.Scanner;


/**
 * @author feng
 * @date 2020/12/10
 * @Description
 */
public class Test {
    public static void main(String[] args) {

        counter();
    }

    /**
     * @param
     * @return
     * @Description 计算器
     * @date 2020/12/10
     */
    private static void counter() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎使用计算器v1.0：");
            System.out.println("请输入第一个数字num1：");
            double num1 = scanner.nextDouble();

            System.out.println("请输入 + — * /：");
            String operator = scanner.next();


            while (!("+".equals(operator) || "-".equals(operator) || "*".equals(operator) || "/".equals(operator))) {
                System.out.println("输入的符号不合法请重新输入：");
                System.out.println("请输入 + — * /：");
                operator = scanner.next();
            }
            System.out.println("请输入第二个数num2：");
            double num2 = scanner.nextDouble();

            switch (operator) {
                case "+":
                    System.out.println(add(num1, num2));
                    break;
                case "-":
                    System.out.println(sub(num1, num2));
                    break;
                case "*":
                    System.out.println(mul(num1, num2));
                    break;
                case "/":
                    System.out.println(div(num1, num2));
                    break;
            }
            System.out.println("输入\"退出\"即可退出计算器");
            String exit = scanner.next();

            while (!("退出".equals(exit))) {
                System.out.println("输入有误请重新输入：");
                System.out.println("输入\"退出\"即可退出计算器");
                exit = scanner.next();
            }

            System.out.println("确定要退出吗？y / n");
            exit = scanner.next();
            while (!("y".equals(exit) || "n".equals(exit))) {
                System.out.println("输入有误请重新输入(y / n)：");
                exit = scanner.next();
            }
            if ("y".equals(exit)) {
                System.out.println("感谢使用再见！");
                return;
            } else {
                counter();
            }

        }
    }


    /**
     * @param num1
     * @param num2
     * @return 两个数的商
     * @Description 计算两个数的商
     */
    private static double div(double num1, double num2) {
        return num1 / num2;
    }

    private static double div(int num1, double num2) {
        return num1 / num2;
    }

    /**
     * @param num1
     * @param num2
     * @return 两个数的乘积
     * @Description 乘法
     * @date 2020/12/10
     */
    private static double mul(double num1, double num2) {
        return num1 * num2;
    }

    private static double mul(int num1, double num2) {
        return num1 * num2;
    }


    /**
     * @param num1
     * @param num2
     * @return 两个数的差
     * @Description 减法
     * @date 2020/12/10
     */
    private static double sub(double num1, double num2) {
        return num1 - num2;
    }

    private static double sub(int num1, double num2) {
        return num1 - num2;
    }

    /**
     * @param num1
     * @param num2
     * @return 两个数的和
     * @Description 加法
     * @date 2020/12/10
     */
    private static double add(double num1, double num2) {

        return num1 + num2;

    }

    private static double add(int num1, double num2) {

        return num1 + num2;

    }

}
