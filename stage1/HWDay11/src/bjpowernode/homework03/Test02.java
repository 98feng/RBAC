package bjpowernode.homework03;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/10
 * @Description
 */
public class Test02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数：");
        String str = scanner.next();

        /*print(str);

        rev(str);*/

    }
    /**
     * @Description
     * @date 2020/12/10
     * @param
     * @return
     *
     */
    private static void rev(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {

            System.out.println(str.charAt(i));
        }
    }
    /**
     * @Description 逆序输出
     * @date 2020/12/10
     * @param 输入的字符串
     * @return
     *
     */

    private static void print(String str) {
        for (int i = 0; i < str.length(); i++) {

            System.out.println(str.charAt(i));

        }
    }

}
