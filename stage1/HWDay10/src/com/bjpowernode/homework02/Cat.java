package com.bjpowernode.homework02;

/**
 * @author feng
 * @date 2020/12/7
 * @Description 2、 猫类： 属性：昵称、年龄、性别、体重、品种 方法：显示猫的信息
 * 测试类： 1）创建猫对象同时执行无参构造方法，调用方法显示猫的信息
 * 2）创建猫对象同时执行带参构造方法完成对所有属性赋值，调用方法显示猫的信息
 * 3）创建猫对象同时执行带参构造方法完成对昵称、年龄和品种赋值，调用方法显示猫的信息
 * 4）创建猫对象同时执行带参构造方法完成对昵称和体重赋值，调用方法显示猫的信息
 */
public class Cat {


    private String name;
    private String age;
    private String gender;
    private String weight;
    private String var;

    public Cat() {
        System.out.println(toString());
    }

    public Cat(String name, String age, String var) {
        this.name = name;
        this.age = age;
        this.var = var;
    }

    public Cat(String name, String weight) {
        this.name = name;
        this.weight = weight;
    }

    public Cat(String name, String age, String gender, String weight, String var) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.var = var;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", weight='" + weight + '\'' +
                ", var='" + var + '\'' +
                '}';
    }
}
