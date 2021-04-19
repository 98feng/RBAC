package com.bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/12
 * @Description this.mm = 0 < mm && mm < 60 ? mm : -1;
 */
public class Test {

    public static void main(String[] args) {

        Date date = new Date();
        date.setHh(12).setMm(59).setSs(0);

        System.out.println("时：" + date.getHh());
        System.out.println("分：" + date.getMm());
        System.out.println("秒：" + date.getSs());

    }
}
