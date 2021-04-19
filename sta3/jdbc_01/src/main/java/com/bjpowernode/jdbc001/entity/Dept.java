package com.bjpowernode.jdbc001.entity;

/**
 * 实体类属性的数据类型必须都是高级引用类型，目的方便存储null值
 * 2021/1/23
 */
public class Dept {

    private Integer deptNo ;
    private String  dname;
    private String  loc;

    public Integer getDeptNo() {
        return deptNo;
    }

    public Dept setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
        return this;
    }

    public String getDname() {
        return dname;
    }

    public Dept setDname(String dname) {
        this.dname = dname;
        return this;
    }

    public String getLoc() {
        return loc;
    }

    public Dept setLoc(String loc) {
        this.loc = loc;
        return this;
    }

    public Dept(Integer deptNo, String dname, String loc) {
        this.deptNo = deptNo;
        this.dname = dname;
        this.loc = loc;
    }

    public Dept() {
    }
}
