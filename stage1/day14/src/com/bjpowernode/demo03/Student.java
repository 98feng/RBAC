package com.bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/11
 * @Description 学生类
 */
public class Student extends Person {

    String sNo;

    public Student() {
    }

    public Student(String sNo) {
        this.sNo = sNo;
    }

    public Student(String pName, String pGender, String pAge, String sNo) {
        super(pName, pGender, pAge);
        this.sNo = sNo;
    }

    public void learn(){
        System.out.println("学习中。。。");
    }

    @Override
    public String toString() {
        return super.toString() + ",sNo='" + "'}";
    }
}
