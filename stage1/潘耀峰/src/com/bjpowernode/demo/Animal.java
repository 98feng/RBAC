package com.bjpowernode.demo;

/**
 * @author feng
 * @date 2020/12/10
 * @Description 动物类
 * 3.编写动物类，属性：昵称、年龄、体重、性别，方法：输出动物所有信息；
 * 编写动物测试类，创建动物对象同时执行无参构造方法，并调用方法输出动物所有信息
 * ；创建动物对象执行带参构造方法完成对所有属性赋值，并调用方法输出动物所有信息。
 */
public class Animal {


    String aName;
    String aAge;
    String aWeight;
    String aGender;

    public Animal() {
    }

    public Animal(String aName, String aAge, String aWeight, String aGender) {
        this.aName = aName;
        this.aAge = aAge;
        this.aWeight = aWeight;
        this.aGender = aGender;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "aName='" + aName + '\'' +
                ", aAge='" + aAge + '\'' +
                ", aWeight='" + aWeight + '\'' +
                ", aGender='" + aGender + '\'' +
                '}';
    }
}
