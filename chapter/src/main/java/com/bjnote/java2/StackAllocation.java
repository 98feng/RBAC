package com.bjnote.java2;

import com.sun.org.apache.xpath.internal.operations.String;

/**
 * @author feng
 * @date 2021/2/14
 * @Description -Xmx1G -Xms1G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails
 */
public class StackAllocation {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100000000; i++) {
            newInstance();
        }

        long end = System.currentTimeMillis();

        System.out.println("花费时间" + (end - start) + "ms");

        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void newInstance() {
        new String();//为发生逃逸
    }
}
