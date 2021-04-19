package com.bjpowernode.arrayList;


import java.util.Objects;
import java.util.ArrayList;

/**
 * @author feng
 * @date 2020/12/20
 * @Description
 */
public class Test {
    public static void main(String[] args) {

        ArrayList<Person> arr = new ArrayList<>();
        arr.add(new Person("aaa", 112));
        arr.add(new Person("aaa", 116));
        arr.add(new Person("aaa", 113));
        arr.add(new Person("bbb", 113));
        arr.add(new Person("ccc", 113));
        arr.add(new Person("eee", 115));
        arr.add(new Person("ddd", 114));
        for (int i = 0; i < 100; i++) {
            arr.add(null);
        }
        arr.add(5, new Person("fff", 114));


        System.out.println(arr);

        arr.remove(null);
        System.out.println(arr);

        arr.remove(new Person("aaa", 112));
        System.out.println(arr);
    }


}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
