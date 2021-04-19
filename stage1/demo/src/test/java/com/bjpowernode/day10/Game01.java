package com.bjpowernode.day10;

import org.junit.Test;

import java.util.*;

/**
 * @author feng
 * @date 2020/12/29
 * @Description
 */
public class Game01 {

    @Test
    public void test() {

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        String[] num = new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] color = new String[]{"♦", "♥", "♠", "♣"};

        int count = 1;
        for (String n : num) {
            for (String c : color) {
                treeMap.put(count, c + n);
                count++;
            }
        }

        treeMap.put(count++, "大王");
        treeMap.put(count++, "小王");

        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.print(entry);
        }
        System.out.println();

        //发牌
        ArrayList<Integer> zhnagsan = new ArrayList<Integer>();
        ArrayList<Integer> lisi = new ArrayList<Integer>();
        ArrayList<Integer> wangwu = new ArrayList<Integer>();

        Set<Integer> keys = treeMap.keySet();
        List<Integer> list = new ArrayList<>(keys);

        Collections.shuffle(list);

        for (int i = 0; i < list.size(); i++) {
            if (i < 3) {
                zhnagsan.add(list.get(i));
            } else if (i % 3 == 1) {
                lisi.add(list.get(i));
            } else if (i % 3 == 2) {
                wangwu.add(list.get(i));
            } else {
                zhnagsan.add(list.get(i));
            }
        }

        Collections.sort(zhnagsan);
        Collections.sort(lisi);
        Collections.sort(wangwu);

        //看牌
        System.out.println(showCard(treeMap, zhnagsan));
        System.out.println(showCard(treeMap, lisi));
        System.out.println(showCard(treeMap, wangwu));


    }

    private String showCard(TreeMap<Integer, String> treeMap, ArrayList<Integer> list) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i != 0){
                sb.append(",");
            }
            sb.append(treeMap.get(list.get(i)));
        }

        return sb.toString();
    }

}
