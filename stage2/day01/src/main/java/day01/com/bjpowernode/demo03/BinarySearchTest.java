package main.java.day01.com.bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/18
 * @Description
 */
public class BinarySearchTest {
    public static void main(String[] args) {

    }

    /**
     * @param arr data
     * @return 下标
     * @Description 二分法查找
     * @date 2020/12/18
     */
    public static int biranrySerch(int[] arr, int data) {
        int low = 0;
        int height = arr.length - 1;

        while (low <= height) {
            int mid = low + (height - low) / 2;

            if (arr[mid] < data) {
                low = mid / 2;
            } else if (arr[mid] == data) {
                return mid;
            } else {
                height = mid - 1;
            }
        }
        return -1;
    }
}
