package com.bjpowernode.day03.homework;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/21
 * @Description
 */
public class HomeWork {
    //1 从键盘上输入身份证号61052319981218xxxx, 判断出生日期,性别(倒数第二位是奇数表示男,偶数代表女)
    @Test
    public void test01() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入身份证号：");
//        String id = scanner.next();
        String id = "61052319981231324x";
        id.trim();
        String pattern = "^[1-9]\\d{5}(18|19|20|(3\\d))\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
//                    ^开头 1-9   5位数字  18年之前没身份证        01 或者 12 月      29  日     | 或者     三位数字 0-9Xx $ 结尾
        while (!id.matches(pattern)) {
            System.out.println("身份证号有误！请重新输入：");
//            id = scanner.next();
        }

        String birth = id.substring(6, 14);
        System.out.println("出生日期" + birth);
        char gender = id.charAt(16);
        System.out.println(gender);
        if (gender % 2 == 0) {  // gender - (gender >= 2 ? 2 : 0);
            System.out.println("女");
        } else {
            System.out.println("男");
        }


    }

    @Test
    public void test() {
        String str = "2 定义方法把字符串逆序 String s = reverse(“ABC”) ;     s返回的值是”CBA”";
        char[] value = str.toCharArray();
        reverse(value);
        for (char c1 : value) {
            System.out.print(c1);
        }
        reverse(value);
        for (char c1 : value) {
            System.out.print(c1);
        }

        re(value);
        for (char c1 : value) {
            System.out.print(c1);
        }
        re(value);
        for (char c1 : value) {
            System.out.print(c1);
        }
    }

    /**
     * @param
     * @return
     * @Description 时间复杂度：O(N)O(N)，其中 NN 为字符数组的长度。一共执行了 N/2
     * N/2 次的交换。
     * 空间复杂度：O(1)O(1)。只使用了常数空间来存放若干变量。
     * @date 2020/12/21
     */
    private void reverse1(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; ++left, --right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }

    private void re(char[] s) {
        for (int left = 0, right = s.length - 1; left < right;left++,right--) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }


    /**
     * 导致此字符序列被*序列的反序替换。如果*序列中包含任何代理对，则将它们视为*反向操作的单个字符。
     * 因此，从高到低的替代*的顺序永远不会颠倒。 *
     * *假设<i> n </ i>是此字符序列的字符长度*（而不是{@code char}值中的长度），即在执行{@code reverse}方法之前。
     * 那么，新字符序列中索引<i> k </ i>处的*字符*等于旧*字符序列中索引<i> n-k-1 </ i>处的字符。 *
     * * <p>请注意，反向操作可能会导致*代理对在操作之前产生未配对的低代理和*高代理。
     * 例如，反转*“ \ u005CuDC00 \ u005CuD800”会产生“ \ u005CuD800 \ u005CuDC00”，这是一个有效的代理对。
     *
     * @Description xiedeshenmebwanyi1
     * 执行用时：
     * 1 ms, 在所有 Java 提交中击败了99.99%的用户内存消耗：45.1 MB, 在所有 Java 提交中击败了84.20%的用户
     * @date 2020/12/21
     */
    private void reverse(char[] value) {
        boolean hasSurrogates = false;
        int count = value.length;
        int n = count - 1;
        for (int j = (n - 1) >> 1; j >= 0; j--) {
            int k = n - j;
            char cj = value[j];
            char ck = value[k];
            value[j] = ck;
            value[k] = cj;
            if (Character.isSurrogate(cj) ||
                    Character.isSurrogate(ck)) {
                hasSurrogates = true;
            }
        }
        if (hasSurrogates) {
            reverseAllValidSurrogatePairs(value);
        }
    }

    /**
     * Outlined helper method for reverse()
     */
    private void reverseAllValidSurrogatePairs(char[] value) {
        int count = value.length;
        for (int i = 0; i < count - 1; i++) {
            char c2 = value[i];
            if (Character.isLowSurrogate(c2)) {
                char c1 = value[i + 1];
                if (Character.isHighSurrogate(c1)) {
                    value[i++] = c1;
                    value[i] = c2;
                }
            }
        }
    }


    @Test
    public void test3() {
        //3 有字符串:”101,lisi,98;202,wangwu,76;303,chenqi,84;404,zhangsan,49;505,xiaoming,67”,
        // 保存的学生的学号,姓名,成绩信息. 要求把字符串中学生信息取出来,创建Student对象, 把Student对象保存到数组中;
        // 遍历学生对象数组;在数组中查找名字为xiaoxiao同学是否存在.对数组中学生对象根据成绩降序排序
        String str = "101,lisi,98;202,wangwu,76;303,chenqi,84;404,zhangsan,49;505,xiaoming,67";
        String[] split = str.split("[,;]");
        Student[] stu = new Student[str.split("[;]").length];
        for (int i = 0, j = 0; i < split.length && j < stu.length; i = i + 3, j++) {
            stu[j] = new Student().setsNo(split[i]).setsName(split[i + 1]).setsScore(split[i + 2]);
        }

        for (Student student1 : stu) {
            System.out.println(student1);
        }
        String strName = "xiaoxiao";

        if (contains(stu, strName)) {
            System.out.println(strName + "在");
        } else {
            System.out.println(strName + "不在");
        }

        Arrays.sort(stu, 0, stu.length, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o2.getsScore().compareTo(o1.getsScore());
            }
        });
        System.out.println(Arrays.toString(stu));
    }

    /**
     * @param stu strName
     * @return
     * @Description 是否存在某个姓名的学生
     * @date 2020/12/21
     */
    private boolean contains(Student[] stu, String strName) {
        if (strName == null) {
            for (int i = 0; i < stu.length; i++) {
                if (strName == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < stu.length; i++) {
                if (strName.equals(stu[i].getsName())) {
                    return true;
                }
            }
        }
        return false;
    }


}

class Student {
    private String sNo;
    private String sName;
    private String sScore;

    public Student() {
    }

    public String getsNo() {
        return sNo;
    }

    public Student setsNo(String sNo) {
        this.sNo = sNo;
        return this;
    }

    public String getsName() {
        return sName;
    }

    public Student setsName(String sName) {
        this.sName = sName;
        return this;
    }

    public String getsScore() {
        return sScore;
    }

    public Student setsScore(String sScore) {
        this.sScore = sScore;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("sNo='").append(sNo).append('\'');
        sb.append(", sName='").append(sName).append('\'');
        sb.append(", sScore='").append(sScore).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

