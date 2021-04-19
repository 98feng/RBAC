package com.bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/12
 * @Description 日期类1.编写时间类，属性：时、分、秒
 * 使用封装完成，要求：时在0---23范围内，分和秒在0---59范围内
 * 编写测试类，通过调用set方法连缀操作完成对属性赋值，调用get方法输出属性的值
 */
public class Date {


    private int hh;
    private int mm;
    private int ss;

    public Date() {
    }

    public int getHh() {
        return hh;
    }

    public Date setHh(int hh) {
        this.hh = (0 <= hh && hh < 24) ? hh : -1;
        return this;
    }

    public int getMm() {
        return mm;
    }

    public Date setMm(int mm) {
        this.mm = (0 <= mm && mm < 60) ? mm : -1;
        return this;
    }

    public int getSs() {
        return ss;
    }

    public Date setSs(int ss) {
        this.ss = (0 <= ss && ss < 60) ? ss : -1;
        return this;
    }
}
