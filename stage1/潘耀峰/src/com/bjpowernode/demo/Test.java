package com.bjpowernode.demo;

/**
 * @author feng
 * @date 2020/12/10
 * @Description 测试类
 *  编写动物测试类，创建动物对象同时执行无参构造方法，并调用方法输出动物所有信息
 *  创建动物对象执行带参构造方法完成对所有属性赋值，并调用方法输出动物所有信息。
 */
public class Test {

    public static void main(String[] args) {

        Animal animal = new Animal();
        System.out.println(animal);

        Animal animal1 = new Animal("Jack", "3", "7kg", "公");
        System.out.println(animal1);
    }

}
