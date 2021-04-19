package com.bjpowernde.demo02;

/**
 * @author feng
 * @date 2020/12/11
 * @Description 拿固定工资的员工
 */
public class SalariedEmployee extends Emp {

    /**
     * 月工资
     */
    double monthSal;

    public SalariedEmployee() {
    }

    public SalariedEmployee(double monthSal) {
        this.monthSal = monthSal;
    }

    public SalariedEmployee(String eName, int eMonth, double monthSal) {
        super(eName, eMonth);
        this.monthSal = monthSal;
    }

    @Override
    public double getSal(int month) {
            return super.getSal(month) + monthSal;

    }
}
