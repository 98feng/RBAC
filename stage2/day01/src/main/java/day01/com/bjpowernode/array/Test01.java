package main.java.day01.com.bjpowernode.array;

/**
 * @author feng
 * @date 2020/12/18
 * @Description
 */
public class Test01 {
    public static void main(String[] args) {

        sum();
        sum(1,2,3,4,5,6);
        sum(1,2,4,4,3,5,6);
        sum(2,1,3,2,3);
        sum(2,3,5,4,3,4);
        int[] arr = {12,213,123,453};
        sum(arr);
    }

    private static void sum(int... data) {
        //在方法中，可以把边长参数作为数组使用
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        System.out.println("sum = " + sum);
    }

    /*public static void sum(String... data){
        String sum = "";
        for (int i = 0; i < data.length; i++) {

        }
        System.out.println("sum = " + sum);
    }*/
}
