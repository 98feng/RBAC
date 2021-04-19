package homework;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/5
 * @Description
 */
public class HW01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入成绩：");
        double score = scanner.nextDouble();

        String result = pudge(score);
        System.out.println("结果为" + result);
    }

    /**
     * @Description 判断成绩等级
     * @author feng
     * @date 2020/12/5
     * @param score
     * @return String
     *
     */
    private static String pudge(double score) {

        if(score > 100 || score < 0) return "成绩不合法！";
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        }
        return "C";
    }

}
