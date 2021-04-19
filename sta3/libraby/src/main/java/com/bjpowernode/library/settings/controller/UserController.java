package com.bjpowernode.library.settings.controller;

import com.bjpowernode.library.activity.contoller.BooksController;
import com.bjpowernode.library.annotation.AuthoWrite;
import com.bjpowernode.library.exception.*;
import com.bjpowernode.library.settings.domain.Admin;
import com.bjpowernode.library.settings.domain.Author;
import com.bjpowernode.library.settings.domain.Author_Books_Relation;
import com.bjpowernode.library.settings.service.UserService;
import com.bjpowernode.library.utils.ApplicationContext;
import com.bjpowernode.library.utils.ServiceFactory;
import userLogin.UserLogin;

import javax.security.auth.login.LoginException;
import java.util.List;
import java.util.Scanner;

import static mian.Main.objectApplicationContext;

/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
@SuppressWarnings("unchecked")
public class UserController {
    /**
     * 在容器中取UserServiceImpl对象并使用动态代理打印错误信息
     */
    static UserService us = (UserService) ServiceFactory.getService(objectApplicationContext.getBean(UserService.class));
    /**
     * 读者登录,将读者信息暂时保存在成员变量中
     */
    static Author author = null;

    public static void authorLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入编号、密码：");
        String authorLonginId = scanner.next();
        String authorLonginPwd = scanner.next();
        try {
            author = us.authorLogin(authorLonginId, authorLonginPwd);
            UserLogin.authorLogin();
        } catch (AuthorLoginException e) {
            e.printStackTrace();
        }
    }

    /***
     * 显示读者信息
     */
    public static void getAuthorName() {
        System.out.println(author.getAuthorLoginId());
    }


    /**
     * 获取所有读者信息
     */
    public static List<Author> getAuthorList() {
        List<Author> list = null;
        try {
            list = us.getAuthorList();

            for (Author author1 : list) {
                System.out.println(author1);
            }
            getAllRelatiosList();
        } catch (GetAuthorException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取所有的借阅记录
     */
    public static List<Author_Books_Relation> getAllRelatiosList() {
        List<Author_Books_Relation> relations = null;
        try {
            relations = us.getAllRelationsList();
        } catch (GetRelationsException e) {
            e.printStackTrace();
        }
        assert relations != null;
        for (Author_Books_Relation relation : relations) {
            System.out.println(relation);
        }
        return relations;
    }


    /**
     * 修改读者密码
     */
    public static void updataAuthorLoginPwd() {
        String authorLoginPwd1 = null;
        String authorLoginPwd2 = null;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入修改后的密码：");
            authorLoginPwd1 = scanner.next();
            System.out.println("请再次输入修改后的密码：");
            authorLoginPwd2 = scanner.next();
            //两次密码相同则修改
            if (authorLoginPwd1.equals(authorLoginPwd2)) {
                author.setAuthorLoginPwd(authorLoginPwd1);
            } else {
                System.out.println("两次密码不一致请重新输入：");
            }
        } while (!authorLoginPwd1.equals(authorLoginPwd2));

        try {
            Author au = us.updataAuthorLoginPwd(author);
            System.out.println("密码修改成功！");
        } catch (UpdataAuthorLoginPwdException e) {
            e.printStackTrace();
        }
    }

    /**
     * 借书
     */
    public static void borrowBooksById() {
        Author_Books_Relation abr = new Author_Books_Relation();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入借的书编号：");
        String borrowBooksId = scanner.next();
        switch (borrowBooksId) {
            case "b001":
                abr.setAuthor(author);
                abr.setBooks(BooksController.selectBooksById(borrowBooksId));
                break;
            case "b002":
                abr.setAuthor(author);
                abr.setBooks(BooksController.selectBooksById(borrowBooksId));
                break;
            case "b003":
                abr.setAuthor(author);
                abr.setBooks(BooksController.selectBooksById(borrowBooksId));
                break;
            default:
                System.out.println("没有编号" + borrowBooksId + "的书！");
        }
        Boolean flag = us.addAuthorBooksRelation(abr);
        System.out.println(flag ? "借阅成功！" : "借阅失败！");
    }

    /**
     * 查看当前读者的借阅记录
     */
    public static List<Author_Books_Relation> getAuthorBooksRelationByAuthor() {
        List<Author_Books_Relation> list = null;
        try {
            list = us.getAuthorBooksRelationByAuthor(author);
            for (Author_Books_Relation authorBooksRelation : list) {
                System.out.println(authorBooksRelation);
            }
        } catch (GetAuthorBooksRelationException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 管理员登录
     */
    public static void adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号密码");
        String adminLoginAct = scanner.next();
        String adminLoginPwd = scanner.next();
        try {
            Admin admin = us.adminLogin(adminLoginAct, adminLoginPwd);
            System.out.println("登录成功！");
            UserLogin.adminLogin();
        } catch (LoginException e) {
            e.printStackTrace();
            String message = e.getMessage();
            System.out.println(message);
        }
    }

    /**
     * 还书就是删除借阅记录
     */
    public static void returnBooksById() {
        rmAuthorBooksRelationByAuthorId(author.getAuthorLoginId());
    }

    /**
     * 添加读者
     */
    public static void addAuthor() {

        Author author = new Author();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入读者的编号和密码");
        String authorId = scanner.next();
        String authorPwd = scanner.next();
        author.setAuthorLoginId(authorId);
        author.setAuthorLoginPwd(authorPwd);

        boolean flag = us.addAuthor(author);
        System.out.println(flag ? "添加成功！" : "添加失败！");
    }

    /**
     * 删除读者同时删除读者的借阅信息
     */
    public static void rmAuthorById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入读者编号");
        String authorId = scanner.next();
        boolean flag = us.rmAuthorById(authorId);
        if (flag) {
            //删除读者的借阅信息
            rmAuthorBooksRelationByAuthorId(authorId);
            System.out.println("删除成功！");
        } else {
            System.out.println("删除失败！");
        }
    }

    /**
     * 删除借阅记录
     */
    private static void rmAuthorBooksRelationByAuthorId(String authorId) {
        boolean flag = us.rmAuthorBooksRelationByAuthorId(authorId);
        System.out.println(flag ? "删除借阅记录成功！" : "没有借阅记录！");
    }


}
