package com.bjpowernode.day06.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author feng
 * @date 2020/12/24
 * @Description
 */
public class Test05 {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(101);

            if (num == 66) {
                System.out.println("包含66");
            }
            list.add(num);
        }
        System.out.println(list.contains(66));
        System.out.println(list.size());

        int rmNum = list.indexOf(99);
        if (rmNum != -1) {
            list.remove(rmNum);
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.print(list + "\t");

        for (Integer integer : list) {
            System.out.println(integer);
        }

        list.removeIf(next -> next < 50);

        System.out.println(list);

    }

    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add("gg");
        list.add("xx");
        list.add("jj");
        list.add("mm");
        list.add("xx");
        list.add("gg");
        System.out.println(list);   //[gg, xx, jj, mm, xx, gg]

        /*1)
            ListIterator<E> listIterator()  返回ListIterator迭代器, ListIterator迭代器继承了Iterator, 即ListIterator也hasNext(), next(), remove()等方法. ListIterator还增加了:
            hasPrevious()判断游标前面是否还元素,
            previous() 返回游标前面的元素,
            add() 在游标位置添加元素,
            set() 修改刚刚获得的元素
         */
        ListIterator<String> listIterator = list.listIterator();    //获得ListIterator迭代器
        //向后迭代
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            System.out.print(next + "  ");
        }
        System.out.println();
        //上个while循环结束后, listIterator的游标就会指向最后一个元素的后面了, 现在再向前迭代
        while (listIterator.hasPrevious()) {
            String previous = listIterator.previous();
            System.out.print(previous + "       ");
        }
        System.out.println();   //gg       xx       mm       jj       xx       gg
        //现在listIterator的游标又指向 一个元素的前面了,再向后迭代
        while (listIterator.hasNext()) {
            String next = listIterator.next();
            if ("gg".equals(next)) {
                listIterator.remove();  //迭代删除
            } else if ("xx".equals(next)) {
                listIterator.add("oo");     //在游标位置添加
            } else if ("mm".equals(next)) {
                listIterator.set("MMMM");   //修改的是刚刚拿到的元素
            }
        }
        System.out.println(list);   //[ xx, oo, jj, MMMM, xx, oo]

        /*2)
            List<E> subList(int fromIndex, int toIndex)  返回list集合[fromIndex, toIndex)范围内元素的一个视图, 即这个subList只能访问原来list集合[from,to)范围内的元素,
            注意:
                并没创建新的集合,修改list集合中的元素再通过subList查看就是修改后的数据
                修改subList集合中的元素,其实就是修改list集合中的数据
         */
        List<String> subList = list.subList(1, 4);
        System.out.println(subList);    //[oo, jj, MMMM]
        //修改list集合中的元素,再通过sublist查看就修改后的数据
        list.set(2, "JJJJJJJ");
        System.out.println(list);   //[xx, oo, JJJJJJJ, MMMM, xx, oo]
        System.out.println(subList);    //[oo, JJJJJJJ, MMMM]
        //修改subList集合中的元素其实就是修改list集合中的元素
        subList.set(0, "OOOOOO");
        System.out.println(subList);        //[OOOOOO, JJJJJJJ, MMMM]
        System.out.println(list);           //[xx, OOOOOO, JJJJJJJ, MMMM, xx, oo]
        //向list集合中插入/删除元素, 可以操作成功,但是再通过subList集合查看元素时,会抛并发修改异常
//        list.add(0, "hhh");
//        list.add("hhhh");
//        list.remove(0);
//        System.out.println(list);   //
//        System.out.println(subList);
        //通过subList插入/删除元素,其实就是在list集合中插入/删除元素
        subList.add(0, "YY");
        System.out.println(subList);    //[YY, OOOOOO, JJJJJJJ, MMMM]
        System.out.println(list);   //[xx, YY, OOOOOO, JJJJJJJ, MMMM, xx, oo]

        /*3)
            toArray(T[] a)  可以把list集合中的数据复制到a数组中
            Arrays.asList( T ... data ) 可以把参数若干数据转换为List集合
         */
        //根据 List集合中元素的个数创建一个数组
        String[] strings = new String[list.size()];
        //把list集合中的元素复制到数组中
        list.toArray(strings);
        for (String str : strings) {
            System.out.println(str);
        }
        //现在Strings数组与list集合是两个不同的容器, 修改了list集合,对string数组没影响, 在strings数组中修改了数组元素对list集合也没影响

        //Arrays.asList( 数组名 )可以返回一个List集合,
        //注意, 并没创建一个新的List容器, 仅仅是提供了一种使用List集合查看数组元素的方式, 即这个返回的List集合是查看数组元素的一个视图, 修改数组元素再通过asList查看就是修改后的元素,  通过asList修改元素就是修改了数组中的元素,  这个asList集合不支持添加/删除操作
        List<String> asList = Arrays.asList(strings);
        System.out.println(asList);   //[xx, YY, OOOOOO, JJJJJJJ, MMMM, xx, oo]
        //修改数组元素后,通过asList查看到的就是修改后的数据
        strings[0] = "6666";
        System.out.println(asList);   //[6666, YY, OOOOOO, JJJJJJJ, MMMM, xx, oo]
        asList.set(2, "oo");
        //通过asList修改元素其实就是修改的数组元素
        System.out.println(Arrays.toString(strings));
        //[6666, YY, oo, JJJJJJJ, MMMM, xx, oo]
//        asList.add("789");  //UnsupportedOperationException,不支持

    }


}
