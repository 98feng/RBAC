package com.bjpowernode.homework02;

/**
 * @author feng
 * @date 2020/12/7
 * @Description 测试
 */
public class Test {

    public static void main(String[] args) {


        Cat cat = new Cat();
        Cat Tom = new Cat("Tom","3岁","布偶");
        System.out.println(Tom);
        Cat Jack = new Cat("Jack","3岁","公","10kg","波斯");
        System.out.println(Jack);
        Cat katty = new Cat("Katty", "9kg");
        System.out.println(katty);

    }
}
