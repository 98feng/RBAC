package homework03;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/7
 * @Description
 */
public class HW01 {
    public static void main(String[] args) {

        //输出键盘输入行数的菱形
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入要打印的菱形行数：");
        int line = scanner.nextInt();

        int row = line / 2 + 1; //row = 3;

        for (int i = 0; i < row; i++) {
            //输出每行的空格
            for (int j = 0; j < row - i; j++) {
                System.out.print(" ");

            }
            //输出每行的*
            for (int k = 0; k < 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //下半部分
        for (int i = row -1; i >= 1; i--) {
            for (int j = 0; j < row - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < 2 * i -1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
