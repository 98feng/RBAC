package homework2;

import java.util.Scanner;
/**
 * @author feng
 * @date 2020/12/5
 * @Description
 */
public class HW02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个年份：");
        int year = scanner.nextInt();

        print1(year);
    }

    /**
     * @Description 判断一个年份是否是闰年
     * @author feng
     * @date 2020/12/5
     * @param year
     * @return
     *
     */
    private static void print1(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0){
            System.out.println("闰年");
        }else{
            System.out.println("不是闰年");
        }
    }
    public static void print1() {
        for (char i = 'Z'; i >= 'A' ; i--) {
            System.out.print(i);
        }

    }
}
