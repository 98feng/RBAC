package com.bjpowernode.day07.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author feng
 * @date 2020/12/25
 * @Description
 */
public class MapTest {

    @Test
    public void test(){

        HashMap<String, Integer> map = new HashMap<>();

        map.put("lisi",90);
        map.put("wangwu",90);
        map.put("zhaoliu",90);
        map.put("chengqi",90);
        map.put("zhuba",90);
        map.put("feifei",90);

        //7)
        System.out.println(map.containsKey("lisi"));//true
        System.out.println(map.replace("zhangsan", 12));

        //删除
        System.out.println(map.remove("zhangfei"));//null

        //查看
        Set<String> strings = map.keySet();
        System.out.println(strings);//[lisi, chengqi, zhaoliu, wangwu, zhuba, feifei]
        System.out.println(map.values());//[90, 90, 90, 90, 90, 90]
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        System.out.println(entries);//[lisi=90, chengqi=90, zhaoliu=90, wangwu=90, zhuba=90, feifei=90]

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry);
        }
        /*
        *   lisi=90
            chengqi=90
            zhaoliu=90
            wangwu=90
            zhuba=90
            feifei=90
        */
    }
}
