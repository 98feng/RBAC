package homework;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/5
 * @Description
 */
public class HW02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数字代表星期：");
        int week = scanner.nextInt();

        System.out.println(pudge(week));
    }

    /**
     * @Description 根据输入数字返回对应的星期
     * @author feng
     * @date 2020/12/5
     * @param week
     * @return String
     *
     */
    private static String pudge(int week) {
        switch (week){
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
            case 7:
                return "星期日";
            default:
                return "星期不合法！";
        }


    }
}
