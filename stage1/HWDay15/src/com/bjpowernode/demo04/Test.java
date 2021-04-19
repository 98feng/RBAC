package com.bjpowernode.demo04;

/**
 * @author feng
 * @date 2020/12/14
 * @Description
 */
public class Test {

    public static void main(String[] args) {

        Instrument instrument = new Scachs();

        Student student = new Student();
        student.play(instrument);

        if (instrument instanceof Scachs){
            instrument.play();
        }else if (instrument instanceof Pinao){
            instrument.play();
        }else if (instrument instanceof Violin){
            instrument.play();
        }

    }
}
