package com.bjpowernode.demo06;

/**
 * @author feng
 * @date 2020/12/11
 * @Description
 */
public class Person {

    String pName;
    String pGender;
    String pAge;

    public Person() {
    }

    public Person(String pName, String pGender, String pAge) {
        this.pName = pName;
        this.pGender = pGender;
        this.pAge = pAge;
    }

    /**
     * @Description 自我介绍
     * @date 2020/12/11
     * @param
     * @return
     *
     */
    public String toString() {
        return "Person{" +
                "pName='" + pName + '\'' +
                ", pGender='" + pGender + '\'' +
                ", pAge='" + pAge;
    }
}
