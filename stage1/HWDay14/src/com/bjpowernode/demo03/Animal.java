package com.bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/12
 * @Description 5.编写程序实现动物园中各种动物叫的功能
 * 动物类： 		属性：昵称，年龄
 * 方法：叫的方法 	         显示信息的方法
 * 通过父类扩展不同的子类： 		老虎类 		狮子类 		猴子类等
 * 测试类： 	根据选择输出不同动物的信息，并输出叫的声音。使用多态完成
 */
public class Animal {

    String aName;
    int aAge;

    public Animal() {
    }

    public Animal(String aName, int aAge) {
        this.aName = aName;
        this.aAge = aAge;
    }

    public void shout() {
    }

    @Override
    public String toString() {
        return "Name='" + aName + '\'' +
                ", Age=" + aAge;
    }
}
