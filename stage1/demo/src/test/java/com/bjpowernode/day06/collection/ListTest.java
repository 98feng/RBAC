package com.bjpowernode.day06.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * @author feng
 * @date 2020/12/24
 * @Description
 */
public class ListTest {

    @Test
    public void test01(){

        List<Person> list = new ArrayList<>();
        list.add(new Person());
        list.add(new Person("1"));
        list.add(new Person("2"));
        list.add(new Person("3"));
        list.add(new Person("4"));
        list.add(new Person("5"));


        list.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.pName.compareTo(o2.pName);

            }
        });

        System.out.println(list);

        List<Person> subList = list.subList(1, 4);
        System.out.println(subList);

        //修改/插入/删除subList中的元素就是修改list集合中的元素
        //subList与list共享同一个容器
        //向list集合中插入/删除元素，可以操作成功，但是在通过sublist集合查看元素是会跑出   并发修改异常
        subList.set(0,new Person("11"));
        subList.add(0,new Person("11"));
        subList.remove(0);
        System.out.println(subList);
        System.out.println(list);


        //toArray将集合中的元素赋值到新数组中
        //Arrays.asList()把参数若干数据转换为list集合
        //String数组与list集合是两个不同的容器

        String[] strings = new String[list.size()];
        //把list集合中元素复制到数组中
        list.toArray(strings);
        for (String string : strings) {
            System.out.println(string);
        }



    }

    static class Person{

        private String pName;
        private int pAge;

        public Person(String pName) {
            this.pName = pName;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Person{");
            sb.append("pName='").append(pName).append('\'');
            sb.append(", pAge=").append(pAge);
            sb.append('}');
            return sb.toString();
        }

        public Person() {
        }

        public Person(String pName, int pAge) {
            this.pName = pName;
            this.pAge = pAge;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(pName, person.pName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(pName, pAge);
        }
    }
}
