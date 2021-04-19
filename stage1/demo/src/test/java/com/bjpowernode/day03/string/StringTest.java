package com.bjpowernode.day03.string;

import org.junit.Test;

/**
 * @author feng
 * @date 2020/12/21
 * @Description
 */
public class StringTest {

    @Test
    public void test() {

        String s1 = "hello";

        byte[] bytes = new byte[]{
                65, 66, 67, 68, 69, 70, 71, 72, 73, 126, (byte) 128
        };

        String s2 = new String(bytes);
        System.out.println(s2);

        char[] chars = {'a', 'b', 'c', 'd', 'e', 'e', 32268, 32269, 65535, '中', '国'};

        String s3 = new String(chars);
        System.out.println(s3);

        long bits = Double.doubleToLongBits(123213123213.213);
        System.out.println(bits);
    }

    @Test
    public void Test02() {
        String strPath = "E:\\bjpowernode\\demo\\src\\main";

        System.out.println(strPath.lastIndexOf('\\'));
        System.out.println(strPath.indexOf('\\'));

        String s1 = "12321231";
        System.out.println(s1.charAt(0));
    }

    @Test
    public void test03() {
        String str = "1.wqeqwrewedfs              " +
                "2.werqwrerwer               " +
                "3.sdsoirjhlk               " +
                "4.好好学习                   ";
        String newStr = str.replaceAll("[ .,。]" ,"||");
        System.out.println(newStr);
        str.trim();
        String[] split = str.split("[\\d.]");
        for (String s : split) {
            System.out.print(s);
        }

    }
}
