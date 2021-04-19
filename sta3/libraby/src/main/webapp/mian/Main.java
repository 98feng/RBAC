package mian;

import com.bjpowernode.library.activity.contoller.BooksController;
import com.bjpowernode.library.settings.controller.UserController;
import com.bjpowernode.library.utils.ApplicationContext;

import java.util.Scanner;

import static com.bjpowernode.library.utils.ApplicationContext.initContextByAnnotation;

/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
public class Main {
    public static ApplicationContext<Object> objectApplicationContext = new ApplicationContext<>();

    public static void main(String[] args) {
        //初始化容器,加载全部的类的实例
        objectApplicationContext.initContext();
//        initContextByAnnotation();
        System.out.println("图书管理系统v0.0");
        System.out.println("1、图书查询");
        System.out.println("2、读者登录");
        System.out.println("3、管理员登录");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的操作：");
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                BooksController.selectBooksList();
                break;
            case 2:
                UserController.authorLogin();
                break;
            case 3:
                UserController.adminLogin();
                break;
            default:
                System.out.println("输入有误！");
        }

    }
}
