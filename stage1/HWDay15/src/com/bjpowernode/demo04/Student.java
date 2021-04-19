package com.bjpowernode.demo04;

/**
 * @author feng
 * @date 2020/12/15
 * @Description
 */
public class Student implements HowDo{


    public Student() {
    }


    @Override
    public void play(Instrument instrument) {
        instrument.play();
    }

    @Override
    public void cook() {

    }
}
