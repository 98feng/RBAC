package main.java.day01.com.bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/17
 * @Description
 */
public class Test {

    public static void main(String[] args) {

        int[] intArr = new int[20];
        intArr[0] = 1;

        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = i * i;
        }
        for (int i = 0; i < intArr.length; i++) {
            System.out.println(intArr[i]);
        }
        /*System.out.println(intArr[111]);*/


        for (int ints : intArr) {
            System.out.println(ints);

        }
    }
}