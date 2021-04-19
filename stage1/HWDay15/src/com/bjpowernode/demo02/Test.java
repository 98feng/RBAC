package com.bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/14
 * @Description
 */
public class Test {

    public static void main(String[] args) {

        System.out.println(new Car());

        Car car = new Car(null, null, null);
        Car car1 = new Car(null, null, null);
        System.out.println(car);
        System.out.println(car.equals(car1));
        System.out.println(car == car1);

    }
}
