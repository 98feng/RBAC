package com.bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/11
 * @Description
 */
public class Vehicel {

    /**
     * 车品牌
     */
    String vBrand;
    /**
     * 车牌号
     */
    String vId;

    public Vehicel() {}

    public Vehicel(String vBrand, String vId) {
        this.vBrand = vBrand;
        this.vId = vId;
    }

    /**
     * @Description 根据租的天数返回总租金
     * @date 2020/12/11
     * @param 租的天数
     * @return 返回总租金
     *
     */
    public double getSumRent(int days){
        return 0;
    }
}
