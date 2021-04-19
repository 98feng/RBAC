package homework3;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/5
 * @Description
 */
public class HW03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入底数：");
        int num = scanner.nextInt();
        System.out.println("请输入指数：");
        int n = scanner.nextInt();

        int result = getResult(num, n);
        System.out.println(num + "的" + n + "次方" + "结果为：" + result);

        /*result = (int) Math.pow(2,4);
        System.out.println(result);*/
    }

    private static int getResult(int num, int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= num;
        }
        return result;
    }


}
