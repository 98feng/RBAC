package com.bjpowernde.demo02;

/**
 * @author feng
 * @date 2020/12/11
 * @Description 销售员工
 */
public class SalesEmp extends Emp {
    /**
     * 月销售额
     */
    double sals;
    /**
     * 提成
     */
    double commission;


    public SalesEmp() {
    }

    public SalesEmp(double sals, double commission) {
        this.sals = sals;
        this.commission = commission;
    }

    public SalesEmp(String eName, int eMonth, double sals, double commission) {
        super(eName, eMonth);
        this.sals = sals;
        this.commission = commission;
    }

    @Override
    public double getSal(int month) {
        return sals + commission + super.getSal(month);
    }

}
