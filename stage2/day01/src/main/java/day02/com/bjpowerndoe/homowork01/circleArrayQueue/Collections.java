package day02.com.bjpowerndoe.homowork01.circleArrayQueue;

import java.util.Random;

/**
 * @author feng
 * @date 2020/12/25
 * @Description
 */
public class Collections {

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
