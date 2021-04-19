package com.bjnote.java;

/**
 * @author feng
 * @date 2021/2/11
 * @Description
 */
public class Demo02 {
    public static void main(String[] args) {
        //返回Java虚拟机中的堆内存总量
        long initialMemory = Runtime.getRuntime().totalMemory()/1024/1024;
        //返回Java虚拟机试图使用的最大堆内存量
        long maxMemory = Runtime.getRuntime().maxMemory()/1024/1024;
        System.out.println("-Xms："+initialMemory+"M");
        System.out.println("-Xmx："+maxMemory+"M");
        //TimeUnit.SECONDS.sleep(1000000);
    }
}
