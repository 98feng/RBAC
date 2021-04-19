package com.bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/14
 * @Description
 */
public class Monkey extends Animal {


    public Monkey() {
    }

    public Monkey(String aName, String aAge) {
        super(aName, aAge);
    }

    @Override
    public void shot() {
        System.out.println("Monkey is shotting.....");
    }
}
