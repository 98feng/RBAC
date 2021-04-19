package com.bjpowernode.demo04;

/**
 * @author feng
 * @date 2020/12/12
 * @Description
 */
public class Car extends Vehicel {

    /**
     * 车型
     */
    String cType;

    public Car() {
    }

    public Car(String cType) {
        this.cType = cType;
    }

    public Car(String vBrand, String vId, String cType) {
        super(vBrand, vId);
        this.cType = cType;
    }

    /**
     * @param 天数
     * @return 总租金
     * @Description 计算租金
     * @date 2020/12/11
     */
    @Override
    public double getSumRent(int days) {
        /**
         * 日租金 * 天数
         * 日租金根据车型得到，因此必须进行判断
         */
        if ("两厢".equals(cType)) {
            return 300 * days;
        } else if ("三厢".equals(cType)) {
            return 350 * days;
        }
        return 500 * days;
    }
}
