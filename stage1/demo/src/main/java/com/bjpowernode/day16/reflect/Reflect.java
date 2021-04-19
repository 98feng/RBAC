package com.bjpowernode.day16.reflect;

/**
 * @author feng
 * @date 2021/1/8
 * @Description
 */
public class Reflect {

    //1获取Class实例
    public static void main(String[] args) {
        //1不会执行静态代码块
        Class clazz = String.class;
        System.out.println(clazz);

        //2
        Class clazz1 = "string".getClass();
        System.out.println(clazz1);
        //3会执行静态代码块
        try {
            Class clazz2 = Class.forName("java.lang.String");
            System.out.println(clazz2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //基本类型和数组的class
        Class clazz3 = int .class;
        System.out.println(clazz3);
        Class clazz4 = int[].class;
        System.out.println(clazz4);
    }


}
