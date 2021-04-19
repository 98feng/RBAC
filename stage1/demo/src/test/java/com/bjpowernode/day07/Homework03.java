/*
package com.bjpowernode.day07;

import java.util.*;

*/
/**
 * 宋秋宇
 * 日期:2020/12/24
 *//*

public class Homework03 {
    public static void main(String[] args) {
        String countries = "科特迪瓦，阿根廷，澳大利亚，塞尔维亚，" +
                "荷兰，尼日利亚，日本，美国，中国，新西兰，巴西，比利时，" +
                "韩国，喀麦隆，洪都拉斯，意大利";
        //字符串转集合
        List<String> teamList = getTeamList(countries);
        printGroup(teamList);

    }
    //打印小组队伍
    public static void printGroup(List<String> teamList) {
        Random random = new Random();
        LinkedList<String> randomTeamList = new LinkedList<>();
        while(true){
            if(teamList.size() == 0){
                break;
            }
            int i = random.nextInt(teamList.size());
            randomTeamList.add(teamList.get(i));
            teamList.remove(i);
            if(randomTeamList.size() % 4 == 0){
                System.out.println(randomTeamList);
                randomTeamList = new LinkedList<>();
            }
        }
    }
    //字符串转可操作的数组
    public static List<String> getTeamList(String countries) {
        String[] splitCountries = countries.split("，");
        for (int i = 0; i < splitCountries.length; i++) {
            splitCountries[i] = splitCountries[i] + "队";
        }
        List<String> splitList = Arrays.asList(splitCountries);
        return new ArrayList<>(splitList);
    }
}
*/
