package com.bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/15
 * @Description
 */
public class Test {

    public static void main(String[] args) {

        Pet pet = new Dog();
        pet.eat();

        pet = new Cat();//向上转型
        pet.eat();//优先调用子类重写以后的方法
    }
}
