package com.bjnote.java1;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试MinorGC、MajorGC、FullGC
 * -Xms10m -Xmx10m -XX:+PrintGCDetails
 * @author feng
 * @date 2021/2/11
 * @Description
 */
public class GCTest {
    public static void main(String[] args) {


        int i = 0;
        try{
            List<String> list = new ArrayList<>();
            String str = "bjnote";
            while(true){
                list.add(str);
                str = str + str;
                i ++;
            }
        }catch(Exception e){
            System.out.println(i);
            e.printStackTrace();
        }finally {
            System.out.println(i);
        }
    }
}
