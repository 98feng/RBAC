package com.bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/14
 * @Description
 */
public class Bus extends Vehicel{

    /**
     * 座位数
     */

    int bSeat;

    public Bus() {
    }

    public Bus(int bSeat) {
        this.bSeat = bSeat;
    }

    public Bus(String vBrand, String vId, int bSeat) {
        super(vBrand, vId);
        this.bSeat = bSeat;
    }

    @Override
    public double getSumRent(int days) {
        return bSeat <= 16 ? 400 * days : 600 * days;
    }
}
