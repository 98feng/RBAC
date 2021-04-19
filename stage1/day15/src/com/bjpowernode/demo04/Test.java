package com.bjpowernode.demo04;

import java.util.HashMap;

/**
 * @author feng
 * @date 2020/12/14
 * @Description
 */
public class Test {

    public static void main(String[] args) {

        Person person = new Person(19,180,"Jack");
        Person person1 = new Person(19,180,"Jack");

        System.out.println(person.equals(person1));
        System.out.println(person == person1);


        HashMap<Person,Person> map = new HashMap<>();
        map.put(person,null);
        map.put(person1,new Person(19,180,"Jack"));

        System.out.println(map.size());

    }
}
