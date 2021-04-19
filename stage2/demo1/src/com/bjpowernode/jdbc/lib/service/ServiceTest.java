package com.bjpowernode.jdbc.lib.service;

import com.bjpowernode.jdbc.service.Engine;
import com.bjpowernode.jdbc.service.Sportmpl;

/**
 * @author feng
 * @date 2021/1/20
 * @Description
 */
public class ServiceTest {

    public static void main(String[] args) {

        Engine engine = new Sportmpl();
        Car car = new Car(engine);
        car.run();

    }
}


class Car{
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void run(){
        this.engine.run();
    }
}
