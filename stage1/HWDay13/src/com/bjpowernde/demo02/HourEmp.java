package com.bjpowernde.demo02;

/**
 * @author feng
 * @date 2020/12/11
 * @Description 小时工
 */
public class HourEmp extends Emp {
    /**
     * 超过160h工作时间
     */
    static double hour;
    /**
     * 每小时的工资
     */
    double hourSal;
    /**
     * 工作的时间
     */
    double hours;


    public HourEmp(double hourSal, double hours) {
        this.hourSal = hourSal;
        this.hours = hours;
    }

    public HourEmp(String eName, int eMonth, double hourSal, double hours) {
        super(eName, eMonth);
        this.hourSal = hourSal;
        this.hours = hours;
    }

    /**
     * @param month
     * @return 工资
     * @Description 超过160小时的部分1.5倍工资
     * @date 2020/12/11
     */
    @Override
    public double getSal(int month) {
        hour = hours - 16;
        double sal = hour > 0 ? (hour * 1.5 * hourSal + 160 * hourSal) : hourSal * hours;
        return sal + super.getSal(month);
    }
}
