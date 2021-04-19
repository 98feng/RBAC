package main.java.day01.com.bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/17
 * @Description
 */
public class Test01 {

    private static final int DEFAULT_CAPACITY = 10;

    public static void main(String[] args) {

        int[] arr = new int[10];
        int[] arr1 = arr;

        for (int x : arr) {
            System.out.print(x + "  ");
        }
        System.out.println();

        pritnArr(arr);

        int[] arr2 = getArr(9);
        System.out.println(arr2.length);

    }

    private static int[] getArr(int capaticy) {
        capaticy = (capaticy < DEFAULT_CAPACITY) ? 10 : capaticy;
        return new int[capaticy];
    }

    private static void pritnArr(int[] arr) {
        for(int x : arr){
            System.out.print(x + "  ");
        }
        System.out.println();
    }


}
