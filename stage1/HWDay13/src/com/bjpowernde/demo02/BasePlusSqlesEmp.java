package com.bjpowernde.demo02;

/**
 * @author feng
 * @date 2020/12/11
 * @Description 有底薪的销售员
 */
public class BasePlusSqlesEmp extends SalesEmp {

    /**
     * 底薪
     */
    double baseSalary;

    public BasePlusSqlesEmp() {
    }

    public BasePlusSqlesEmp(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public BasePlusSqlesEmp(double sals, double commission, double baseSalary) {
        super(sals, commission);
        this.baseSalary = baseSalary;
    }

    public BasePlusSqlesEmp(String eName, int eMonth, double sals, double commission, double baseSalary) {
        super(eName, eMonth, sals, commission);
        this.baseSalary = baseSalary;
    }


    @Override
    public double getSal(int month) {
        return super.getSal(month) + baseSalary;
    }
}
