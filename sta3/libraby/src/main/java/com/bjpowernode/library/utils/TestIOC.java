package com.bjpowernode.library.utils;

import com.bjpowernode.library.annotation.AuthoWrite;

import java.lang.reflect.Field;

/**
 * @author feng
 * @date 2021/1/9
 * @Description
 */
public class TestIOC {


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

        assebleObject();


    }

    private static void assebleObject() throws IllegalAccessException, InstantiationException {
        Class<?> aClass = Person.class;
        Object obj = aClass.newInstance();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            AuthoWrite annotation = field.getAnnotation(AuthoWrite.class);
            //判断该属性上是否有AuthorWrite注解
            if (annotation != null) {
                field.setAccessible(true);
                //把obj对象转换成代理对象
                Object proxyKey = ServiceFactory.getService(obj);
                System.out.println(obj == proxyKey);
            }
        }
    }
}

class Person {
    @AuthoWrite
    private String name;
}