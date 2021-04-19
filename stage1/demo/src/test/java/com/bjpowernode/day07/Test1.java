package com.bjpowernode.day07;

import org.junit.Test;

import java.util.*;

/**
 * @author feng
 * @date 2020/12/24
 * @Description 练习1    修改公司类, 使用List集合存储员工对象,其他操作不变
 * 练习2: 已知有十六支男子足球队参加2023 北极世界杯。写一个程序，
 * 把这16 支球队随机分为4 个组。采用List集合和随机数 男足参赛国家：
 * 科特迪瓦，阿根廷，澳大利亚，塞尔维亚，荷兰，尼日利亚，日本，美国，中国，新西 兰，
 * 巴西，比利时，韩国，喀麦隆，洪都拉斯，意大利
 */
public class Test1 {
    //方案一
    /*@Test
    public void test() {
        String footCon = "科特迪瓦，阿根廷，澳大利亚，塞尔维亚，荷兰，尼日利亚，日本，美国，中国，新西 兰，巴西，比利时，韩国，喀麦隆，洪都拉斯，意大利";
        String trim = footCon.trim();
        String[] split = trim.split("[，]");

        String[] strings = new String[split.length];

        Random random = new Random();
        boolean[] bool = new boolean[split.length];
        int randInt = 0;
        for (int i = 0; i < split.length; i++) {
            do {
                randInt = random.nextInt(split.length);
            } while (bool[randInt]);
            bool[randInt] = true;
            strings[i] = split[randInt];
        }

        List<String> team = Arrays.asList(strings);

        List<List<String>> result = createList(team, 4);


        for (List<String> subArr : result) {
            for (String str : subArr) {
                System.out.print(str);
            }
            System.out.println();
        }
    }

    */

    /**
     * @param
     * @return
     * @Description 将一个list集合按照指定份数分割
     * @date 2020/12/24
     *//*
    public static List<List<String>> createList(List<String> targe, int size) {
        List<List<String>> listArr = new ArrayList<List<String>>();
        //获取被拆分的数组个数
        int arrSize = targe.size() % size == 0 ? targe.size() / size : targe.size() / size + 1;
        for (int i = 0; i < arrSize; i++) {
            List<String> sub = new ArrayList<String>();
            //把指定索引数据放入到list中
            for (int j = i * size; j <= size * (i + 1) - 1; j++) {
                if (j <= targe.size() - 1) {
                    sub.add(targe.get(j));
                }
            }
            listArr.add(sub);
        }
        return listArr;
    }*/
    //方案二
    //数组乱序，重写toString
    @Test
    public void test1() {
        String footCon = "科特迪瓦，阿根廷，澳大利亚，塞尔维亚，荷兰，尼日利亚，日本，美国，中国，新西 兰，巴西，比利时，韩国，喀麦隆，洪都拉斯，意大利";
        String trim = footCon.trim();
        String[] split = trim.split("[，]");
        //乱序
        Collections.shuffle(split,new Random());

        List<String> list = new CircleArray<>(split.length,4);

        for (int i = 0; i < 16; i++) {
            list.add(split[i]);
        }
        System.out.print(list);

    }


}
