package com.bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/17
 * @Description 弹弓
 */
public class Util {

    Bird bird;

    public Util() {
    }

    public Util(Bird bird) {
        this.bird = bird;
    }

    public void shot(Flyable flyable){
        flyable.flay();
    }
}
