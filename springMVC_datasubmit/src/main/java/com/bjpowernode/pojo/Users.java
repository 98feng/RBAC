package com.bjpowernode.pojo;

/**
 * 动力节点
 * 2021/3/9
 */
public class Users {
    private String uname;
    private int uage;

    @Override
    public String toString() {
        return "Users{" +
                "uname='" + uname + '\'' +
                ", uage=" + uage +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUage() {
        return uage;
    }

    public void setUage(int uage) {
        this.uage = uage;
    }

    public Users(String uname, int uage) {
        this.uname = uname;
        this.uage = uage;
    }

    public Users() {
    }
}
