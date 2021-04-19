package homework;

import java.util.Scanner;

public class Hw03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = sc.nextInt();
        System.out.println(pudge(num));
    }

    /**
     * @Description 判断一个数
     * @author feng
     * @date 2020/12/5 - 9:21
     * @param null
     * @return
     *
     */

    private static int pudge(int num) {

        return num > 0 ? 1 : (num == 0 ? 0 : -1);

    }
}
