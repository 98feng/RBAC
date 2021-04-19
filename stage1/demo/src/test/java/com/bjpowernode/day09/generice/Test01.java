package com.bjpowernode.day09.generice;

import org.junit.Test;


/**
 * @author feng
 * @date 2020/12/28
 * @Description
 */
public class Test01 extends ArrayList<Person> {

    /*@Test
    public void test01() {

        ArrayList<String> strings = new ArrayList<>();
        addAll(strings, "213", "213");
        ArrayList<Integer> ints = new ArrayList<>();
        addAll(ints, 213, 213);


    }


    @SafeVarargs
    private final <T> void addAll(ArrayList<T> list, T... args) {
        list.addAll(list);

    }

    @Test
    public void test02() {
        ArrayList<Comparable<Person>> list = new ArrayList<>();
    }*/


}

class ArrayList<T extends Comparable<Person>> {

}

class Person implements Comparable<Person> {

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
