package main.java.day01.com.bjpowernode.homework;

import java.util.Random;

/**
 * @author feng
 * @date 2020/12/17
 * @Description 随机生成100个小写字母保存到字符数组中, 统计每个字母出现的次数
 * int xx = (int)( Math.random() * 26 ) ;  	// 返回一个[0,26 )范围内的随机整数
 * char cc = (char)  ( ‘a’ + xx ) ; 		//小写字母
 */
public class Test03 {

    public static void main(String[] args) {

        Random random = new Random();
        int randomNumber = 0;
        char[] arr = new char[100];
        int num = 0;
        char letter = '0';
        for (int i = 0; i < 100; i++) {
            randomNumber = random.nextInt(26);
            letter = (char) ('a' + randomNumber);
            arr[i] = letter;
        }

        /*for (char j = 'a'; j <= 'z'; j++) {
            int numLetter = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == j) {
                    numLetter++;
                }

            }
            System.out.println("字母" + j + "出现了" + numLetter + "次");
        }*/
//        统计每个字母出现的次数
        int[] countArr = new int[26];
        //约定a的次数保存到countArr[0]元素中
        //约定b的次数保存到countArr[1]元素中
        //约定c的次数保存到countArr[2]元素中...
        //规律：对于任意一个字符cc，他出现的次数保存到countArr[cc -'a']中
        for (char cc : arr) {
            countArr[cc - 'a']++;
        }
        for (char cc = 'a'; cc <= 'z'; cc++) {
            System.out.println(cc + "字符出现的次数：" + countArr[cc - 'a']);
        }


    }

}
