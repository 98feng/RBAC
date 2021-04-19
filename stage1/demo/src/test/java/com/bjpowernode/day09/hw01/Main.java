package com.bjpowernode.day09.hw01;

import
        java.util.HashMap;
import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */
public class Main {

    static HashMap<String, String> map = new HashMap<>();
    static String str1;
    static String str2;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            print();
            String str = scanner.next();
            switch (str) {
                case "1":
                    login();
                    break;
                case "2":
                    register();
                    break;
                case "0":
                    /*System.exit(0);结束Java虚拟机*/
                    Runtime.getRuntime().exit(0);
                default:
                    System.out.println("输入有误！！");
                    break;
            }
        }
    }

    public static void print() {
        System.out.println("--------------------*****主界面*****--------------------");
        System.out.println("                         1.登录 ");
        System.out.println("                         2.注册 ");
        System.out.println("                         0.退出 ");
        System.out.println("--------------------*****请选择功能：");
    }


    /**
     * 检测到重复返回false,否则返回true
     */
    public static boolean check() {
        input();
        return !map.containsKey(str1);
    }

    /**
     * 登录
     */
    public static void login() {
        input();
        if (map.containsKey(str1)) {
            String value = map.get(str1);
            if (value.equals(str2)) {
                System.out.println("登录成功！");
            } else {
                System.out.println("密码和用户名不一致，请重新输入！");
            }
        } else {
            System.out.println("用户名不存在！");
        }
    }

    /**
     * 注册
     */
    public static void register() {
        if (check()) {
            map.put(str1, str2);
            System.out.println("注册成功！");
        } else {
            System.out.println("用户名已存在，请重新注册！");
        }
    }


    /**
     * 输入
     */
    public static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        str1 = scanner.next();
        System.out.println("请输入密码：");
        str2 = scanner.next();
    }
    /**
     * 显示
     * @param map
     */
    /*public static void show(HashMap<String, String> map) {
        Set<String> keys = map.keySet();
        for (String key : keys) {
            String value = map.get(key);
            System.out.println("key:" + key + ",value:" + value);
        }
    }*/

}

