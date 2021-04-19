package com.bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/14
 * @Description
 */
public class Car extends Vehicel{

    /**
     * 车型
     */

    String cType;

    public Car() {
    }

    public Car(String vBrand, String vId) {
        super(vBrand, vId);
    }

    @Override
    public double getSumRent(int days) {

        if ("两厢".equals(cType)){
            return 300 * days;
        }else if ("三厢".equals(cType)){
            return 350 * days;
        }
        return 500 * days;
    }
}
