package com.bjpowernode.day07.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author feng
 * @date 2020/12/25
 * @Description
 */
public class TestSet {

    @Test
    public void test() {
        HashSet<Integer> set = new HashSet<>();
        set.add(123);
        set.add(123);
        set.add(234);
        set.add(456);
        set.add(456);

        for (Integer integer : set) {
            System.out.print(integer + "\t");
        }

        System.out.println();

        set.removeIf(next -> next == 123);
//        System.out.println(set);

        for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            System.out.println(next);
        }


    }


}
