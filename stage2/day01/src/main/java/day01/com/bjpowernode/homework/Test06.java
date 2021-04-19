package main.java.day01.com.bjpowernode.homework;

/**
 * @author feng
 * @date 2020/12/17
 * @Description 练习2: 定义方法把整数数组的元素逆序 ,
 * 第0个元素与length-1元素交换,第1个元素与length-2交换 ....
 */
public class Test06 {
    public static void main(String[] args) {

        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
            System.out.print(ints[i] + "\t");
        }
        System.out.println("=======================");
        int flag;
        for (int i = 1; i <= ints.length / 2; i++) {
            flag = ints[ints.length - i];
            ints[ints.length - i] = ints[i];
            ints[i] = flag;

        }


        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "\t");
        }
    }
}
