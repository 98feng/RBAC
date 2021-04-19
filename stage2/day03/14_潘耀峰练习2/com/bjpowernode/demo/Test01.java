package com.bjpowernode.demo;

import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/17
 * @Description 打印日历
 */
public class Test01 {

    /**
     * 月份不能超过12
     */
    private static final int MONTH_MAX = 12;
    /**
     * 超过12月返回错误天数-1
     */
    private static final int OUT_OF_NUMMONTH_ERROR = -1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请按照yyyy  mm   格式输入日期：");
        int year = scanner.nextInt();
        int month = scanner.nextInt();

        int days = getSumYearsDays(year) + sumMonthDays(year, month);
        int startDay = getWhatWeek(days);

        System.out.println("星期一\t星期二\t星期三\t星期四\t星期五\t星期六\t星期日");
        print(year, month, startDay);
    }

    /**
     * @param days 总天数
     * @return 星期几
     * @Description 计算从1900开始到现在是星期几
     * @date 2020/12/17
     */
    private static int getWhatWeek(int days) {
        int weekDay = days % 7;
        return weekDay == 0 ? 7 : weekDay;

    }

    /**
     * @param year 当前年份
     * @return 总天数
     * @Description 计算1900年开始到目前
     * @date 2020/12/17
     */
    private static int getSumYearsDays(int year) {
        int sumYearsDays = 0;
        if (year < 1900) {
            System.out.println("请输入大于1900年的年份！");
        } else {
            for (int i = 1900; i < year; i++) {

                sumYearsDays += isLeapYear(year) ? 366 : 365;
            }
        }
        return sumYearsDays;
    }

    /**
     * @param year month
     * @return 总天数
     * @Description 计算当前月份至1月1日之间的天数
     * @date 2020/12/17
     */

    private static int sumMonthDays(int year, int month) {
        int sumMonthDays = 0;
        if (month < 0 || month > MONTH_MAX) {
            System.out.println("输入的月份不合法！");
        } else {
            for (int i = 1; i < month; i++) {
                sumMonthDays += numMonth(year, i);
            }
        }
        return sumMonthDays;
    }

    /**
     * @param
     * @return
     * @Description
     * @date 2020/12/17
     */
    private static int numMonth(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return OUT_OF_NUMMONTH_ERROR;
        }

    }

    /**
     * @param year
     * @return 是=闰年返回true不是返回false
     * @Description 判断一个年份是否是闰年
     * @date 2020/12/17
     */
    private static boolean isLeapYear(int year) {

        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * @param year month day
     * @return
     * @Description 格式化日历
     * @date 2020/12/17
     */
    private static void print(int year, int month, int startDay) {

        for (int i = 0; i < startDay; i++) {
            System.out.print("\t\t");
        }

        int days = numMonth(year,month);
        for (int i = 1; i <= days; i++) {

            if ((i + startDay - 1) % 7 == 0) {
                System.out.println();
            }
            System.out.print(" " + i + "\t\t");

        }
    }
}
