package com.bjpowernode.day09.hw01;

import lombok.*;
import org.junit.Test;

import java.util.*;

/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */
public class Test01 {

    @Test
    public void test() {

        TreeMap<Car, String> treeMap = new TreeMap<>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.getPrice() - o1.getPrice();
            }
        });
        treeMap.put(new Car(7), "1");
        treeMap.put(new Car(8), "2");
        treeMap.put(new Car(5), "3");
        treeMap.put(new Car(3), "4");
        treeMap.put(new Car(11), "5");
        Car car = new Car(9);


        /*返回价格最高小汽车的拥有者姓名*/
        System.out.println(treeMap.firstEntry().getValue());//5
        treeMap.put(car,"6");
        System.out.println("=========修改对象的属性之后============");
        car.price = 4;
        for (Map.Entry<Car, String> entry : treeMap.entrySet()) {
            System.out.println(entry);

        }
        System.out.println(treeMap.get(car));//null

        /*
         * 判断是否有超过100万的小汽车
         * 	删除所有低于10万的所有小汽车
         */
        boolean flag = false;
        for (Map.Entry<Car, String> entry : treeMap.entrySet()) {
            flag = entry.getKey().getPrice() > 100;
        }
        System.out.println(flag ? "有" : "没有");//没有

        List<Car> list = new ArrayList<>(treeMap.keySet());
        list.removeIf(next -> next.getPrice() < 10);
        System.out.println(list);
    }

    @ToString
    @EqualsAndHashCode
    @Getter
    @Setter
    @NoArgsConstructor
//@RequiredArgsConstructor
    @AllArgsConstructor
    static class Car {
        private int price;
    }
}
