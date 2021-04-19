package com.bjpowernde.demo02;

/**
 * @author feng
 * @date 2020/12/11
 * @Description 员工表
 */
public class Emp {

    /**
     * 员工姓名
     */
    String eName;
    /**
     * 员工生日的月份
     */
    int eMonth;


    public Emp() {
    }

    public Emp(String eName, int eMonth) {
        this.eName = eName;
        this.eMonth = eMonth;
    }

    /**
     * @param month
     * @return double sal
     * @Description 根据月份拿工资，若果员工过生日+100
     * @date 2020/12/11
     */
    public double getSal(int month) {
        return month == eMonth ? 100 : 0;
    }
}
