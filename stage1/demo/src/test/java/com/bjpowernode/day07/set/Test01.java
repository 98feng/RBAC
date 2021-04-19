package com.bjpowernode.day07.set;

import org.junit.Test;

import java.util.*;

/**
 * @author feng
 * @date 2020/12/25
 * @Description 分别用list set集合存储10个【0-100）随机数
 */
public class Test01 {


    @Test
    public void test() {

        List<Integer> list = new ArrayList<>();

        Random random = new Random();
        boolean[] bool = new boolean[100];
        int randInt = 0;
        for (int i = 0; i < 10; i++) {
            do {
                randInt = random.nextInt(100);
            } while (bool[randInt]);
            bool[randInt] = true;
            list.add(randInt);
        }
        System.out.println(list);
        while (list.size() < 10) {
            int num = random.nextInt(100);
            if (!list.contains(num)) {
                list.add(num);
            }
        }
        System.out.println(list);

        System.out.println("===========================");

        HashSet<Integer> set = new HashSet<>();
        while (set.size() < 10) {
            set.add(random.nextInt(10));
        }
        System.out.println(set);


    }

    @Test
    public void test02() {
        HashSet<Person> set = new HashSet<>();
        set.add(new Person("123"));
        set.add(new Person("345"));
        set.add(new Person("456"));
        set.add(new Person("678"));
        set.add(new Person("123"));
        Person zhuba = new Person("zhuba");
        set.add(zhuba);
        System.out.println(set);
        System.out.println(set.contains(zhuba));

        zhuba.setpName("zhuxiaoba");
        System.out.println(set);

        System.out.println(set.contains(zhuba));


    }

    @Test
    public void test03() {
        TreeSet<Integer> set = new TreeSet<>();
        Integer data[] = new Integer[]{
                7, 4, 9, 2, 5, 8, 11, 3, 12, 1
        };

        for (int i = 0; i < data.length; i++) {
            set.add(data[i]);
        }
        System.out.println(set);//[1, 2, 3, 4, 5, 7, 8, 9, 11, 12]
    }


    @Test
    public void test04() {
        //年龄降序
        TreeSet<Person> treeSet = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {

                return o2.pAge - o1.pAge;
            }
        });
        treeSet.add(new Person("aaa", 7));
        treeSet.add(new Person("eee", 4));
        treeSet.add(new Person("ccc", 9));
        treeSet.add(new Person("fff", 2));
        treeSet.add(new Person("bbb", 5));
        treeSet.add(new Person("ggg", 8));
        treeSet.add(new Person("nnn", 11));
        treeSet.add(new Person("hhh", 12));
        Person zhuba = new Person("ddd", 3);
        treeSet.add(zhuba);
//        zhuba.setpName("zhuba");
        System.out.println(treeSet.contains(zhuba));//true
        zhuba.setpAge(5000);//
        System.out.println(treeSet.contains(zhuba));//true
        System.out.println("====================================");
        //名字升序
        TreeSet<Person> treeSet1 = new TreeSet<>();
        treeSet1.addAll(treeSet);
        System.out.println(treeSet1);
    }

    static class Person implements Comparable<Person> {
        String pName;
        int pAge;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return pAge == person.pAge &&
                    Objects.equals(pName, person.pName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(pName, pAge);
        }

        public Person setpName(String pName) {
            this.pName = pName;
            return this;
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

        public Person(String pName) {
            this.pName = pName;
        }

        public Person(String pName, int pAge) {
            this.pName = pName;
            this.pAge = pAge;
        }

        @Override
        public int compareTo(Person o) {
            return -o.pName.compareTo(pName);
        }

        public Person setpAge(int pAge) {
            this.pAge = pAge;
            return this;
        }

/*@Override
        public int compareTo(Object o) {
            if (o instanceof Person) {
                Person p = (Person) o;
                return -p.pName.compareTo(pName);
            }
            throw new ClassCastException("类型转换异常！");
        }*/
    }
}
