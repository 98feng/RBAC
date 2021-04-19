package com.bjpowernode.demo04;

import java.util.Objects;

/**
 * @author feng
 * @date 2020/12/14
 * @Description
 */
public class Person {

    int age;
    int height;
    String name;

    public Person() {
    }

    public Person(int age, int height, String name) {
        this.age = age;
        this.height = height;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Double.compare(person.height, height) == 0 &&
                //return (a == b) || (a != null && a.equals(b));
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, height, name);
    }

    /*public boolean equals(Object obj) {
        // 内存地址
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        // if (obj == null || !(obj instanceof Person)) return false;

        // 比较成员变量
        Person person = (Person) obj;
        return person.age == age
                && person.height == height
//                return (a == b) || (a != null && a.equals(b));
                && (person.name == null ? name == null : person.name.equals(name));
    }
    @Override
    public int hashCode() {
        int hashCode = Integer.hashCode(age);
        hashCode = hashCode * 31 + Float.hashCode(height);
        hashCode = hashCode * 31 + (name != null ? name.hashCode() : 0);
        return hashCode;
    }*/

}
