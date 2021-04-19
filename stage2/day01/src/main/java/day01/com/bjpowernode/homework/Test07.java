package main.java.day01.com.bjpowernode.homework;

import java.util.Arrays;

/**
 * @author feng
 * @date 2020/12/17
 * @Description 练习3: 定义方法,把整数数组的各个元素连接为一个字符串, 数组元素放在一对方括弧中,各个元素之间使用逗号分隔
 * int [] data = {11, 22, 33 ,44 };
 * String txt = toString( data );
 * txt输出为:  [ 11, 22, 33, 44 ]
 */
public class Test07 {
    public static void main(String[] args) {

        int[] intsElement = new int[10];
        for (int i = 0; i < intsElement.length; i++) {
            intsElement[i] = i;
        }
        System.out.println(toString(intsElement));
        System.out.println(Arrays.toString(intsElement));


    }
    /**
     *
     * public String toString() {
     * 		StringBuilder string = new StringBuilder();
     * 		string.append("[");
     * 		for (int i = 0; i < intsElement.length; i++) {
     * 			if (i != 0) {
     * 				string.append(", ");
     *                        }
     *
     * 			string.append(intsElement[i]);
     *
//   * 		if (i != intsElement.length - 1) {
//   * 				string.append(", ");
//   *            }
     *      }
     * 		string.append("]");
     * 		return string.toString();
     *    }
     */
    public static String toString(int[] a) {
        if (a == null) {
            return "null";
        }
        int iMax = a.length - 1;
        if (iMax == -1) {
            return "[]";
        }

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax) {
                return b.append(']').toString();
            }
            b.append(", ");
        }
    }
}
