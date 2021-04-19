package com.bjpowernode.demo01;

import java.util.Objects;

/**
 * @author feng
 * @date 2020/12/14
 * @Description 1.编写出版社类：
 * 属性：编号，出版社名称，地址
 * 方法：显示出版社的信息
 */
public class Press {

    int pNo;
    String pName;
    String pAddr;

    public Press() {
    }

    public Press(int pNo, String pName, String pAddr) {
        this.pNo = pNo;
        this.pName = pName;
        this.pAddr = pAddr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Press{");
        sb.append("pNo=").append(pNo);
        sb.append(", pName='").append(pName).append('\'');
        sb.append(", pAddr='").append(pAddr).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Press press = (Press) o;
        return pNo == press.pNo &&
                Objects.equals(pName, press.pName) &&
                Objects.equals(pAddr, press.pAddr);

    }


    @Override
    public int hashCode() {
        return Objects.hash(pNo, pName, pAddr);
    }
}
