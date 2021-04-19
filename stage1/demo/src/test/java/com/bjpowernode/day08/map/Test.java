package com.bjpowernode.day08.map;


import com.sun.istack.internal.NotNull;
import lombok.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author feng
 * @date 2020/12/26
 * @Description
 */
public class Test {

    @org.junit.Test
    public void test01() {
        TreeMap<Student, String> map = new TreeMap<>();/*(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        });*/
        map.put(new Student("213",123,9),"isi");
        map.put(new Student("zhangsan",132,9),"gsan");
        map.put(new Student("ccc",3221,9),"ccc");
        map.put(new Student("aaa",32122,9),"aaa");
        map.put(new Student("ddd",32,9),"ddd");

        System.out.println(map);
        System.out.println("=====================");
        for (Map.Entry<Student, String> stringIntegerEntry : map.entrySet()) {
            System.out.println(stringIntegerEntry);
        }


        TreeMap<Student,String> treeMap = new TreeMap<>(map);
        System.out.println(treeMap);

        System.out.println("=========================");


        for (Map.Entry<Student, String> stringIntegerEntry : treeMap.entrySet()) {
            System.out.println(stringIntegerEntry);
        }


    }

    @ToString
    @EqualsAndHashCode
    @Getter
    @Setter
    @NoArgsConstructor
//    @RequiredArgsConstructor
    @AllArgsConstructor
    static class Student implements Comparable<Student>{
        @NotNull
        private String no;
        @NotNull
        private int grade;
        @NotNull
        private Integer score;

        @Override
        public int compareTo(Student o) {
            return o.getGrade() - getGrade();
        }
    }

}
