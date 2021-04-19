package bjpowernode.demo04;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/10
 * @Description
 */
public class Test01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入一个数字：");
            int week = scanner.nextInt();
            if (week == 0) return;
            System.out.println(print(week));
        }
    }


    private static String print(int week) {
        if (week < 0 || week > 7) return "输入的星期不合法！请重新输入：";
        switch (week) {
            case 1:
                return "星期一";
            case 2:
                return "星期二";
            case 3:
                return "星期三";
            case 4:
                return "星期四";
            case 5:
                return "星期五";
            case 6:
                return "星期六";
            default:
                return "星期日";
        }
    }
}
