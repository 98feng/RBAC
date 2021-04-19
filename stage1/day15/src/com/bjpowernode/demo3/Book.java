package com.bjpowernode.demo3;

/**
 * @author feng
 * @date 2020/12/14
 * @Description
 */
public class Book {

    String bNo;
    String bName;
    String bPrice;
    String bAtu;

    public Book() {
    }

    public Book(String bNo, String bName, String bPrice, String bAtu) {
        this.bNo = bNo;
        this.bName = bName;
        this.bPrice = bPrice;
        this.bAtu = bAtu;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("bNo='").append(bNo).append('\'');
        sb.append(", bName='").append(bName).append('\'');
        sb.append(", bPrice='").append(bPrice).append('\'');
        sb.append(", bAtu='").append(bAtu).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
