package com.bjpowernode.day16.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author feng
 * @date 2021/1/8
 * @Description
 */
public class ReflectMethod {

    public static void main(String[] args) throws Exception {
        //创建实例对象
        Class<String> aClass = String.class;
        String s1 = aClass.newInstance(); //相当于new String()


        Constructor<String> constructor = aClass.getConstructor(byte[].class);
        byte[] bytes = {1,23,3,4,5,6,7,8};
        String s2 = constructor.newInstance(bytes); //new String(byte[] )

        //反射某个公共的成员方法
        Method length = aClass.getMethod("length");//public int length()

        //有参数的方法
        Method equals = aClass.getMethod("equals", Object.class);

        //多个参数
        Method valueOf = aClass.getMethod("valueOf", char[].class, int.class, int.class);


        //方法调用
//        public Object invoke(Object obj, Object... args)
        Object invoke = length.invoke(s1); //s1.length
        Object invoke1 = length.invoke(s2); //s2.length


        //调用静态方法是对象名传null
        char[] chars = {'1','1','a','b','b','c','d','v'};
        Object invoke2 = valueOf.invoke(null,chars , 0, 6);
        System.out.println("invoke2 = " + invoke2);
    }
}
