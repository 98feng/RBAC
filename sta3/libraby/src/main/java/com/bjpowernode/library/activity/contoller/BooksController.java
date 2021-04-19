package com.bjpowernode.library.activity.contoller;

import com.bjpowernode.library.activity.domain.Books;
import com.bjpowernode.library.activity.service.BooksService;
import com.bjpowernode.library.annotation.AuthoWrite;
import com.bjpowernode.library.exception.BooksNotFoundException;
import com.bjpowernode.library.exception.RmBooksByIdException;
import com.bjpowernode.library.utils.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static mian.Main.objectApplicationContext;


/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
public class BooksController {
    /**
     * 从容器中获取BooksServiceImpl对象并使用动态代理打印异常信息
     */
    static BooksService bs = null;
    {
        bs = (BooksService) ServiceFactory.getService(objectApplicationContext.getBean(BooksService.class));
    }
    /**
     * 图书查询
     */
    public static void selectBooksList() {
        System.out.println("===========图书查询==============");
        System.out.println("1、按图书编号查询\t2、按图书名称查询");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                System.out.println("请输入编号：");
                String id = scanner.next();
                System.out.println(selectBooksById(id));
                break;
            case 2:
                System.out.println("请输入名称：");
                String name = scanner.next();
                List<Books> books = selectBooksByName(name);
                for (Books book : books) {
                    System.out.println(book);
                }
                break;
            default:
                System.out.println("输入有误！");
        }
    }

    public static Books selectBooksById(String id) {
        List<Books> list = getBooksList();
        for (Books books : list) {
            if (id.equals(books.getId())) {
                return books;
            }
        }
        System.out.println(id + "图书未找到！");
        return null;
    }

    private static List<Books> selectBooksByName(String name) {

        List<Books> list = getBooksList();
        ArrayList<Books> booksByNameList = new ArrayList<>();
        for (Books books : list) {
            if (books.getName().contains(name)) {
                booksByNameList.add(books);
            }
        }
        return booksByNameList;
    }

    /**
     * 获取所有的图书信息
     */
    public static List<Books> getBooksList() {


        List<Books> list = null;
        try {
            list = bs.getBooksList();
        } catch (BooksNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void addBooks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书编号：");
        String bookId = scanner.next();
        System.out.println("请输入图书名字：");
        String bookName = scanner.next();
        System.out.println("请输入图书作者：");
        String bookAuthor = scanner.next();
        System.out.println("请输入图书价格：");
        String bookPrice = scanner.next();
        Books books1 = new Books(bookId, bookName, bookAuthor, bookPrice);

        boolean flag = bs.addBooks(books1);
        System.out.println(flag ? "添加成功！" : "添加失败！");
    }

    /**
     * 删除图书同时要删除借阅记录
     */
    public static Books rmBooksById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入图书编号：");
        String booksId = scanner.next();
        Books books = null;
        try {
            books = bs.rmBooksById(booksId);
            System.out.println("图书删除成功！");
            bs.rmAuthorBooksRelationByBooksId(booksId);
            System.out.println("借阅记录删除成功！");
        } catch (RmBooksByIdException e) {
            e.printStackTrace();
        }
        return books;
    }

}
