package com.bjpowernode.shop.login.controller;


import com.bjpowernode.shop.login.domain.User;
import com.bjpowernode.shop.login.service.UserService;
import com.bjpowernode.shop.login.service.impl.UserServiceImpl;
import com.bjpowernode.shop.utils.ServiceFactory;
import mian.GoodsManage;

import java.util.Scanner;


/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */
public class UserController {

    /**
     * 注册
     */
    public static void register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String loginAct = scanner.next();
        System.out.println("请输入密码：");
        String loginPwd = scanner.next();
        //这里使用动态代理，增加打印日志功能
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        try {
            User user = us.register(loginAct, loginPwd);
            //业务层没有异常，则注册成功！
            System.out.println("注册成功！");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    /**
     * 登录
     */
    public static void login() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String loginAct = scanner.next();
        System.out.println("请输入密码：");
        String loginPwd = scanner.next();

        //这里使用动态代理，增加打印日志功能
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        try {
            User user = us.login(loginAct, loginPwd);
            //业务层没有异常，则登录成功！
            System.out.println("登录成功！");
            GoodsManage.success();
        } catch (Throwable e) {
            e.printStackTrace();
            String message = e.getMessage();
            if (message != null){
                System.out.println("账户或密码错误！\n是否重新登录(y/n)");
                Scanner scanner1 = new Scanner(System.in);
                String str = scanner1.next();
                if ("y".equalsIgnoreCase(str)){
                    login();
                }else if("n".equalsIgnoreCase(str)){
                    System.exit(0);
                }else {
                    System.out.println("输入有误！");
                }

            }
        }
    }


}
