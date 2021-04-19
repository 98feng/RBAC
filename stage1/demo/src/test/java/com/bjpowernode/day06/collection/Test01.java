package com.bjpowernode.day06.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author feng
 * @date 2020/12/24
 * @Description
 */
public class Test01 {


    @Test
    public void test01(){

        Collection<Person> persons = new ArrayDeque<>();

        persons.add(new Person());
        persons.add(new Person("1"));
        persons.add(new Person("2"));
        persons.add(new Person("3"));
        persons.add(new Person("4"));
        persons.add(new Person("5"));

        for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext(); ) {
            Person next = iterator.next();
            System.out.print(next);
        }
        System.out.println();
        persons.remove(new Person("1"));
        for (Person person : persons) {
            System.out.print(person);
        }
        System.out.println();
        persons.remove(new Person("2"));
        for (Person person : persons) {
            System.out.print(person);
        }
            System.out.println();
        persons.remove(new Person("3"));
        for (Person person : persons) {
            System.out.print(person);
        }


        System.out.println("==========================");
        Collection<Person> person1 = new ArrayList<>(persons);
        Collection<Person> person2 = new ArrayList<>(persons);
        Collection<Person> person3 = new ArrayList<>(persons);
        System.out.println(person1);
        System.out.println("=========================");
        person1.addAll(persons);
        System.out.println(person1);
        System.out.println("===================");
        System.out.println(person2.addAll(persons)+ "person2");
        System.out.println(person2.addAll(persons)+ "person2");
        System.out.println(person2);
        System.out.println("============================");
        System.out.println(person2.retainAll(persons)+ "person2");
        System.out.println(person2);
        persons.addAll(person2);
        /*
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.pName.compareTo(o2.pName);
            }
        });*/

        System.out.println(person1+ "per");
        for (Iterator<Person> iterator = person1.iterator(); iterator.hasNext(); ) {
            Person next = iterator.next();
            if ("5".equals(next.pName)){
                iterator.remove();
            }
        }
        System.out.println(person1+"213");
        person1.removeIf(next ->"5".equals(next.pName));
        System.out.println(person1);


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
