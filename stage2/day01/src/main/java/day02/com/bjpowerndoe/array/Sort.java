package day02.com.bjpowerndoe.array;

import java.util.Arrays;

/**
 * @author feng
 * @date 2020/12/19
 * @Description
 */
public class Sort {
    public static void main(String[] args) {

        int[] data = {65, 43, 87, 21, 6, 32};
        //有n个数的数组,进行n-1轮选择
        for (int x = 0; x < data.length - 1; x++) {
            int min = x;       //保存最小元素的下标
            //从min+1开始遍历数组中后面的元素,如果有某个元素小于min标识的元素就把该元素的下标保存到min变量中
            for (int i = min + 1; i < data.length; i++) {
                if (data[i] < data[min]) {
                    min = i;
                }
            }
            //上面的for循环结束,找到当前最小元素的下标min
            //如果min保存的下标与x不一样就交换
            if (min != x) {
                int t = data[x];
                data[x] = data[min];
                data[min] = t;
            }
        }

        int[] data1 = {123, 231, 4, 3, 544, 53, 2, 12, 34};
        for (int i = 0; i < data1.length - 1; i++) {
            int min = i;
            for (int j = min + 1; j < data1.length; j++) {
                if (data1[j] < data1[min]) {
                    min = j;
                }
            }
            int flag = 0;
            if (min != i) {
                flag = data1[i];
                data1[i] = data1[min];
                data1[min] = flag;
            }
        }


        System.out.println(Arrays.toString(data1));
    }
}
