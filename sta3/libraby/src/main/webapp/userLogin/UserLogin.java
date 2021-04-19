package userLogin;

import com.bjpowernode.library.activity.contoller.BooksController;
import com.bjpowernode.library.activity.domain.Books;
import com.bjpowernode.library.settings.controller.UserController;
import com.bjpowernode.library.settings.dao.AuthorDaoImpl;
import com.bjpowernode.library.settings.domain.Author;
import com.bjpowernode.library.settings.domain.Author_Books_Relation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
public class UserLogin {
    /**
     * 读者操作
     */
    public static void authorLogin() {
        System.out.println("===========读者操作界面=========");
        System.out.println("1、查看个人信息");
        System.out.println("2、查看借阅信息");
        System.out.println("3、修改密码");
        System.out.println("4、借书");
        System.out.println("5、还书");
        System.out.println("6、退出");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的操作：");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                UserController.getAuthorName();
                break;
            case 2:
                UserController.getAuthorBooksRelationByAuthor();
                break;
            case 3:
                UserController.updataAuthorLoginPwd();
                break;
            case 4:
                UserController.borrowBooksById();
                break;
            case 5:
                UserController.returnBooksById();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("输入有误！");
        }
    }

    /**
     * 管理员操作
     */
    public static void adminLogin() {
        System.out.println("=====================管理员操作界面===================");
        System.out.println("1、添加读者信息");
        System.out.println("2、删除读者信息");
        System.out.println("3、查询读者信息");
        System.out.println("4、添加图书信息");
        System.out.println("5、删除图书信息");
        System.out.println("6、退出");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的操作：");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                UserController.addAuthor();
                break;
            case 2:
                UserController.rmAuthorById();
                break;
            case 3:
                UserController.getAuthorList();
                break;
            case 4:
                BooksController.addBooks();
                break;
            case 5:
                BooksController.rmBooksById();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("输入有误！");
        }
    }
}
