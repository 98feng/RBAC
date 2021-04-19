package com.bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/14
 * @Description 动物类：
 * 	属性：昵称，年龄
 * 	方法：叫的方法
 * 	          显示信息的方法
 */
public abstract class Animal {

    String aName;
    String aAge;

    public Animal() {
    }

    public Animal(String aName, String aAge) {
        this.aName = aName;
        this.aAge = aAge;
    }

    public abstract void shot();


}
