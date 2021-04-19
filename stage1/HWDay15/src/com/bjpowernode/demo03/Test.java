package com.bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/14
 * @Description
 */
public abstract class Test {

    public static void main(String[] args) {

        Animal animal = new Tiger();

        if (animal instanceof Tiger) {
            animal.shot();
        }else if (animal instanceof Monkey){
            animal.shot();
        }else if (animal instanceof Lion){
            animal.shot();
        }


    }
}
