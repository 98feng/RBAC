package com.bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/12
 * @Description
 */
public class Lion extends Animal {

    public Lion() {
    }

    public Lion(String aName, int aAge) {
        super(aName, aAge);
    }

    @Override
    public void shout() {
        System.out.println("Lion shoutting....");
    }

    /*@Override
    public String toString() {
        return super.toString();
    }*/

    @Override
    protected void finalize() throws Throwable {
        System.out.println("等待回收....." + this);
    }
}
