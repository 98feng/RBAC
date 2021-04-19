package com.bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/14
 * @Description
 */
public class Tiger extends Animal {

    public Tiger() {
    }

    public Tiger(String aName, String aAge) {
        super(aName, aAge);
    }

    @Override
    public void shot() {
        System.out.println("tiger is shotting.......");
    }
}
