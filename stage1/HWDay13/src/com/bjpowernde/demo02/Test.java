package com.bjpowernde.demo02;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/11
 * @Description
 */
public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入当前的月份：");
        int month = scanner.nextInt();

        SalariedEmployee salariedEmployee = new SalariedEmployee(null,1,8888);
        System.out.println("拿固定工资员工工资：" + salariedEmployee.getSal(month));

        HourEmp hourEmp = new HourEmp(null,12,70,170);
        System.out.println("小时工工资：" + hourEmp.getSal(month));

        SalesEmp salesEmp = new SalesEmp(null, 11, 2000, 1000);
        System.out.println("销售员人员工资：" + salesEmp.getSal(month));

        BasePlusSqlesEmp basePlusSqlesEmp = new BasePlusSqlesEmp(null,12,5000,5000,3000);
        System.out.println("有底薪的销售人员工资：" + basePlusSqlesEmp.getSal(month));
    }
}
