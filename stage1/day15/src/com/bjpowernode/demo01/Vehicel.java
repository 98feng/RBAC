package com.bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/14
 * @Description
 */
public abstract class Vehicel {


    /**
     * 品牌
     */

    String vBrand;

    /**
     * 车牌号
     */

    String vId;

    public Vehicel() {
    }

    public Vehicel(String vBrand, String vId) {
        this.vBrand = vBrand;
        this.vId = vId;
    }



    /**
     * @Description 根据局的天数返回总租金
     * @date 2020/12/14
     * @param days
     * @return 总租金
     *
     */
    public abstract double getSumRent(int days);
}
