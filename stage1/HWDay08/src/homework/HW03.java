package homework;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/5
 * @Description
 */
public class HW03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个年龄：");
        int age = scanner.nextInt();

        System.out.println(pudge(age));
    }

    private static String pudge(int age) {
        if(age < 0) return "年龄不合法";
        if(age >= 70){
            return "老年";

        }else if (age >= 40){
            return "中年";
        }else if(age >= 20){
            return "青年";
        }
        return "少年";

    }
}
