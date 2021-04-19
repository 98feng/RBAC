package com.bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/12
 * @Description
 */
public class Test {

    public static void main(String[] args) {

        Computer computer = new Computer();
        computer.setcName(null).setcColor(null).setcSize(null).setcPrice(5000);

        System.out.println("品牌：" + computer.getcName() + "\t颜色：" + computer.getcColor() + "\t尺寸：" + computer.getcSize() + "\t价格：" + computer.getcPrice());
    }
}
