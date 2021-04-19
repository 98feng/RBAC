package com.bjpowernode.library;

import com.bjpowernode.library.activity.domain.Books;
import com.bjpowernode.library.settings.domain.Admin;
import com.bjpowernode.library.settings.domain.Author;
import com.bjpowernode.library.settings.domain.Author_Books_Relation;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author feng
 * @date 2021/1/22
 * @Description
 */
public class TestApp {
    @Test
    public void test02() {
        Books books1 = new Books("b001", "java入门", "菲菲", "40.0");
        Books books2 = new Books("b002", "java提高", "老崔", "30.0");
        Books books3 = new Books("b003", "java web", "老杨", "20.0");
        List<Books> list = new ArrayList<Books>();
        list.add(books1);
        list.add(books2);
        list.add(books3);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("books.txt")));
            oos.writeObject(list);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 读者信息注册
     */
    @Test
    public void test() {
        Author r001 = new Author("r001", "123456");
        Author r002 = new Author("r002", "123456");
        ArrayList<Author> list = new ArrayList<>();
        list.add(r001);
        list.add(r002);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("Author.txt")));
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 初始化管理员信息admin，密码123
     */
    @Test
    public void test01() {
        Admin admin = new Admin("admin", "123");
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("Admin.txt")));
            oos.writeObject(admin);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 添加借阅记录
     * @param args
     */
    public static void main(String[] args) {
        Books books1 = new Books("b001", "java入门", "菲菲", "40.0");
        Books books2 = new Books("b002", "java提高", "老崔", "30.0");
        Books books3 = new Books("b003", "java web", "老杨", "20.0");
        Author r001 = new Author("r001", "123456");
        Author r002 = new Author("r002", "123456");
        Author_Books_Relation abs1 = new Author_Books_Relation(r001, books1);
        Author_Books_Relation abs2 = new Author_Books_Relation(r001, books2);
        Author_Books_Relation abs3 = new Author_Books_Relation(r001, books3);
        List<Author_Books_Relation> list = new ArrayList<>();
        list.add(abs1);
        list.add(abs2);
        list.add(abs3);


        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("abr.txt")));
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert oos != null;
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
