package com.bjpowernode.day16.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author feng
 * @date 2021/1/8
 * @Description
 */
public class ReflectTest01 {

    public static void main(String[] args) throws Exception {
        //获取类的实例
        Class<?> myClass = Class.forName("com.bjpowernode.day16.reflect.MyClass");//这是静态代码块

        Class<MyClass> aClass = MyClass.class;
        MyClass obj1 = aClass.newInstance();
        System.out.println("interfaces = " + obj1);/*空参构造器执行
                                                    interfaces = MyClass{x=0, y=0}*/

        //通过无参构造器创建实例
        Constructor<MyClass> constructor = aClass.getConstructor();
        MyClass obj2 = constructor.newInstance();
        System.out.println(obj2);/*空参构造器执行
                                    MyClass{x=0, y=0}*/
        //有参构造器创建实例
        Constructor<MyClass> constructor1 = aClass.getConstructor(int.class, int.class);
        MyClass obj3 = constructor1.newInstance(10,20);
        System.out.println(obj3);

        //公共字段
        Field x = aClass.getField("x");
        x.set(obj1,10);
        x.set(obj2,30);
        System.out.println(obj1);
        System.out.println(obj2);

        //私有字段
        Field y = aClass.getDeclaredField("y");
        y.setAccessible(true);//access访问
        y.set(obj1,70);
        y.set(obj2,30);
        System.out.println(obj1);
        System.out.println(obj2);

        //反射静态字段
        Field s = aClass.getField("s");
        s.set(null,23);//静态成员 跟对象没有关系 , 在set()/get()访问静态成员时,在实例名位置传递null
        System.out.println(s.get(null));


    }
}
