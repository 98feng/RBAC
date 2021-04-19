package main.java.day01.com.bjpowernode.homework;

import java.util.*;

/**
 * @author feng
 * @date 2020/12/17
 * @Description 练习1: 定义方法, 实现数组中各个元素的乱序,
 * 遍历数组的每个元素,把该元素与另外一个随机下标的元素进行交换交换
 */
public class Test05 {


    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] =  i;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        /*System.out.println("=================");

        List<String> stringList = Arrays.asList(arr);
        Collections.shuffle(stringList);

        stringList.toArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }*/

        shuffle(arr,new Random());
        System.out.println(Arrays.toString(arr));
    }
    public static void shuffle(int[] ints, Random rnd) {
        for (int i = ints.length; i > 1; i--) {
            swap(ints, i - 1, rnd.nextInt(i));
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
