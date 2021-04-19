package com.bjpowernode.day09.hw.login;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */
public class TestLogin {

    static HashMap<String, String> map = new HashMap<>();
    static String loginAct;
    static String loginPwd;

    public static void login() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            print();
            Map<String, String> input = input();
            String str = scanner.next();
            switch (str) {
                case "1":
//                        login();
                    break;
                case "2":
//                        register();
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
     * 输入
     */
    public static Map<String,String> input() {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        System.out.println("请输入用户名：");
        loginAct = scanner.next();
        System.out.println("请输入密码：");
        loginPwd = scanner.next();
        map.put(loginAct,loginPwd);
        return map;
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



