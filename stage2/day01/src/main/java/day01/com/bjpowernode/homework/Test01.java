package main.java.day01.com.bjpowernode.homework;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/17
 * @Description 从键盘上输入10个同学的成绩保存到数组中,
 * 计算所有同学的平均成绩,
 * 统计成绩高于平均分学生的人数,
 * 找出数组中最高分同学的索引值
 */
public class Test01 {

    static double[] arr;
    static double sumScore = 0.0;
    static double avgScore = 0.0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请连续输入10个同学成绩：");

        arr = new double[10];
        for (int i = 0; i < arr.length; i++) {
            double score = scanner.nextDouble();
            arr[i] = score;
            sumScore += score;
        }
        avgScore = sumScore / arr.length;
        System.out.println("平均成绩：" + avgScore);

        int maxThanAvgScore = getMaxThanAvgScore(avgScore);
        System.out.println("高于平均分的人数：" + maxThanAvgScore);

        int maxScoreIndex = getMaxScoreIndex(arr);
        System.out.println("最高分的下标是:" + maxScoreIndex + "对应的成绩是：" + arr[maxScoreIndex]);
    }

    private static int getMaxScoreIndex(double[] arr) {

        int maxScoreIndex = 0;
        for (int i = maxScoreIndex + 1; i < arr.length; i++) {
            if (arr[i] > arr[maxScoreIndex]) {
                maxScoreIndex = i;
            }

        }
        return maxScoreIndex;
    }

    private static int getMinScoreIndex(double[] arr){
        int minScoreIndex = 0;
        for (int i = minScoreIndex + 1; i < arr.length; i++) {
            if (arr[i] < arr[minScoreIndex]){
                minScoreIndex = i;
            }

        }
        return minScoreIndex;
    }

    private static int getMaxThanAvgScore(double avgScore) {
        int maxThanAvgScore = 0;
        for (int i = 0; i < arr.length; i++) {
            if (avgScore < arr[i]) {
                maxThanAvgScore++;
            }
        }
        return maxThanAvgScore;
    }


}
