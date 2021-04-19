package com.bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/12
 * @Description
 */
public class Monkey extends Animal {

    @Override
    public void shout() {
        System.out.println("Monkey shotting......");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public Monkey() {
    }

    public Monkey(String aName, int aAge) {

        super(aName, aAge);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("等待回收....." + this);
    }
}
