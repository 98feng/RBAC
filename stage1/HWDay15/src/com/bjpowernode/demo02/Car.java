package com.bjpowernode.demo02;

import java.util.Objects;

/**
 * @author feng
 * @date 2020/12/14
 * @Description 编写车类，属性：品牌、颜色、价格，构造方法：无参、带参，方法：显示车的信息
 */
public class Car {


    String cName;
    String cColor;
    String cPrice;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(cName, car.cName) &&
                Objects.equals(cColor, car.cColor) &&
                Objects.equals(cPrice, car.cPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cName, cColor, cPrice);
    }

    public Car(String cName, String cColor, String cPrice) {
        this.cName = cName;
        this.cColor = cColor;
        this.cPrice = cPrice;
    }

    public Car() {
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("cName='").append(cName).append('\'');
        sb.append(", cColor='").append(cColor).append('\'');
        sb.append(", cPrice='").append(cPrice).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
