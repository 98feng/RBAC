package com.bjpowernode.crm.commons.utils;

/**
 * 动力节点
 * 2021/3/20
 */
public class md5test {
    public static void main(String[] args) {
        String username=MD5Util.getMD5("ls");
        System.out.println(username);
    }
}
