package com.bjpowernde.demo01;

/**
 * @author feng
 * @date 2020/12/11
 * @Description
 */
public class Teacher extends Person {

    String tSal;

    public Teacher() {
    }

    public Teacher(String tSal) {
        this.tSal = tSal;
    }

    public Teacher(String pName, String pGender, String pAge, String tSal) {
        super(pName, pGender, pAge);
        this.tSal = tSal;
    }

    /**
     * @param
     * @return
     * @Description 教学
     * @date 2020/12/11
     */
    public void teach(){
        System.out.println("教学中。。。。。。。。。");
    }

    @Override
    public String toString() {
        return super.toString() + ",tSal='" + "'}";
    }
}
