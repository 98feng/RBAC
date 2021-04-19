package com.bjpowernode.demo04;

/**
 * @author feng
 * @date 2020/12/12
 * @Description 封装完成
 */
public class Date {

    private int year;
    private int month;
    private int day;

    public Date() {
    }

    public int getYear() {
        return year;
    }

    public Date setYear(int year) {
        this.year = year > 0 ? year : 2020;
        return this;
    }

    public int getMonth() {
        return month;
    }

    public Date setMonth(int month) {
        this.month = month;
        return this;
    }

    public int getDay() {
        return day;
    }

    public Date setDay(int day) {
        this.day = day;
        return this;
    }
}

