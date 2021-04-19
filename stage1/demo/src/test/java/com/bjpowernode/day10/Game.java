package com.bjpowernode.day10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author feng
 * @date 2020/12/28
 * @Description 模拟斗地主
 */
public class Game {

    @Test
    public void Test() {
        // 创建牌、2345678910 JQK A 大王、小王
        ArrayList<String> poke = new ArrayList<>();
        String[] num = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] color = new String[]{"♦", "♥", "♠", "♣"};
        for (String c : color) {
            for (String n : num) {
                poke.add(c + n);
            }
        }
        poke.add("大王");
        poke.add("小王");
        System.out.println(poke);
        //洗牌 shuffer
        Collections.shuffle(poke);
        System.out.println(poke);
        //发牌 定义四个TreeSet对象、前序遍历及可排序输出，仅仅是输出！
       /* TreeSet<String> zhangsan = new TreeSet<>();
        TreeSet<String> lisi = new TreeSet<>();
        TreeSet<String> wangwu = new TreeSet<>();
        TreeSet<String> hole_cards = new TreeSet<>();

        for (int i = 0; i < poke.size(); i++) {
            if (i < 3) {
                hole_cards.add(poke.get(i));
            } else if (i % 3 == 0) {
                zhangsan.add(poke.get(i));
            } else if (i % 3 == 1) {
                lisi.add(poke.get(i));
            } else {
                wangwu.add(poke.get(i));
            }
        }
        //看牌
        System.out.println("zhangsan:" + zhangsan);
        System.out.println("lisi:" + lisi);
        System.out.println("wangwu:" + wangwu);
//        System.out.println("底牌:" + hole_cards);
        //叫地主 + 3张底
        String landLord = "zhangsan";
        switch (landLord) {
            case "zhangsan":
                zhangsan.add("底牌" + hole_cards.toString());
                break;
            case "lisi":
                lisi.add("底牌" + hole_cards.toString());
                break;
            case "wangwu":
                wangwu.add("底牌" + hole_cards.toString());
            default:
                zhangsan.add("底牌" + hole_cards.toString());
        }
*/


        //排序
        ArrayList<String> zhangsan = new ArrayList<>();
        ArrayList<String> lisi = new ArrayList<>();
        ArrayList<String> wangwu = new ArrayList<>();
        ArrayList<String> hole_cards = new ArrayList<>();

        for (int i = 0; i < poke.size(); i++) {
            if (i < 3) {
                hole_cards.add(poke.get(i));
            } else if (i % 3 == 0) {
                zhangsan.add(poke.get(i));
            } else if (i % 3 == 1) {
                lisi.add(poke.get(i));
            } else {
                wangwu.add(poke.get(i));
            }
        }
        //叫地主 + 3张底
        String landLord = "zhangsan";
        switch (landLord) {
            case "zhangsan":
                zhangsan.add("底牌" + hole_cards.toString());
                break;
            case "lisi":
                lisi.add("底牌" + hole_cards.toString());
                break;
            case "wangwu":
                wangwu.add("底牌" + hole_cards.toString());
            default:
                zhangsan.add("底牌" + hole_cards.toString());
        }

        zhangsan.sort(new PokeComparator());
        lisi.sort(new PokeComparator());
        wangwu.sort(new PokeComparator());
        //看牌
        System.out.println("zhangsan:" + zhangsan);
        System.out.println("lisi:" + lisi);
        System.out.println("wangwu:" + wangwu);
        System.out.println("底牌:" + hole_cards);

    }

}
//给每张牌指定大小
class PokeComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return getNumOfPoke(o1) - getNumOfPoke(o2);
    }

    private int getNumOfPoke(String poke) {

        if ("大王".equals(poke)){
            return 17;
        }else if ("小王".equals(poke)){
            return 16;
        }

        String numStr = poke.substring(1);
        switch (numStr){
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            case "2":
                return 15;
        }
        return 0;
    }
}
