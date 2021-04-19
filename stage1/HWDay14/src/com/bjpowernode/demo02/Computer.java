package com.bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/12
 * @Description 2.编写电脑类，属性：品牌、颜色、价格、尺寸
 * 使用封装完成，要求：价格在0以上
 * 编写测试类，通过set方法连缀操作完成对属性赋值，调用get方法输出属性的值
 */
public class Computer {

    private String cName;
    private String cColor;
    private int cPrice;
    private String cSize;

    public Computer() {
    }

    public String getcName() {
        return cName;
    }

    public Computer setcName(String cName) {
        this.cName = cName;
        return this;
    }

    public String getcColor() {
        return cColor;
    }

    public Computer setcColor(String cColor) {
        this.cColor = cColor;
        return this;
    }

    public int getcPrice() {
        return cPrice;
    }

    public Computer setcPrice(int cPrice) {
        this.cPrice = cPrice > 0 ? cPrice : -1;
        return this;
    }

    public String getcSize() {
        return cSize;
    }

    public Computer setcSize(String cSize) {
        this.cSize = cSize;
        return this;
    }
}
