package com.bjpowernode.demo02;

import java.util.Objects;

/**
 * @author feng
 * @date 2020/12/14
 * @Description
 */
public class Computer {

    String Color;
    String Price;

    public Computer() {
    }

    public Computer(String color, String price) {
        Color = color;
        Price = price;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "Color='" + Color + '\'' +
                ", Price='" + Price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Color.equals(computer.Color) &&
                Price.equals(computer.Price);
    }

}
