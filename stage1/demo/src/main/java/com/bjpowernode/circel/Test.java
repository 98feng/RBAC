package com.bjpowernode.circel;

import java.util.Objects;

/**
 * @author feng
 * @date 2020/12/21
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        CircleDeque<Person> queue = new CircleDeque<>();
        // 头5 4 3 2 1  100 101 102 103 104 105 106 8 7 6 尾

        // 头 8 7 6  5 4 3 2 1  100 101 102 103 104 105 106 107 108 109 null null 10 9 尾
        /*for (int i = 0; i < 10; i++) {
            queue.enQueueFront(i + 1);
            queue.enQueueRear(i + 100);
        }*/
        /*queue.add(new Person("213",231));
        queue.add(new Person("211322",131));
        queue.add(new Person("21213",2311));
        queue.add(new Person(null,2311));
        System.out.println(queue);

        queue.remove(new Person("212",12));
        queue.remove(new Person("213",231));
        queue.remove(new Person(null,2311));
        System.out.println(queue);*/

        /*// 头 null 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null null 尾
        for (int i = 0; i < 3; i++) {
            queue.deQueueFront();
            queue.deQueueRear();
        }
        System.out.println(queue);

        // 头 11 7 6  5 4 3 2 1  100 101 102 103 104 105 106 null null null null null null 12 尾
        queue.enQueueFront(11);
        queue.enQueueFront(12);
        System.out.println(queue);
        while (!queue.isEmpty()) {
            System.out.println(queue.deQueueFront());
        }*/
        CircleQueue<Object> queue1 = new CircleQueue<>();
        for (int i = 0; i < 10; i++) {
            queue1.enQueue(i + 1);
        }
        System.out.println(queue1);

    }

    static class Person{
        String name;
        int age;

        public Person() {
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
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
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
}
