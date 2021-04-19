package com.bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/14
 * @Description
 */
public class Mian extends Computer {

    String sMize;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Mian{");
        sb.append("sMize='").append(sMize).append('\'');
        sb.append(", Color='").append(Color).append('\'');
        sb.append(", Price='").append(Price).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
