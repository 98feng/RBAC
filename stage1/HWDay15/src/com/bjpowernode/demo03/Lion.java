package com.bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/14
 * @Description
 */
public class Lion extends Animal {


    public Lion() {
    }

    public Lion(String aName, String aAge) {
        super(aName, aAge);
    }

    @Override
    public void shot() {
        System.out.println("Lion is shotting.....");
    }
}
