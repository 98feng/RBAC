package com.bjpowernode.library.activity.dao;

import com.bjpowernode.library.activity.domain.Books;
import com.bjpowernode.library.annotation.Bean;
import com.bjpowernode.library.settings.domain.Author_Books_Relation;

import java.io.*;
import java.util.List;

/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
@Bean
public class BooksDaoImpl implements BooksDao {

    public BooksDaoImpl() {
    }

    /**
     * 查询所有图书
     *
     * @return
     * @throws Throwable
     */
    @Override
    public List<Books> getBooksList() {
        Object o = descSeri("books.txt");
        @SuppressWarnings("unchecked")
        List<Books> list = (List<Books>) o;
        return list;
    }


    /**
     * 添加图书
     *
     * @param books
     * @return 如果有该图书返回0, 没有则返回1
     */
    @Override
    public int addBooks(Books books) {
        List<Books> booksList = getBooksList();
        boolean contains = booksList.contains(books);

        if (!contains) {
            booksList.add(books);
            serialize(booksList, "books.txt");
        }
        return contains ? 0 : 1;
    }

    /**
     * 根据id删除图书
     *
     * @param booksId
     * @return 返回被删的书
     */
    @Override
    public Books rmBooksById(String booksId) {
        List<Books> booksList = getBooksList();
        for (Books books : booksList) {
            if (booksId.equals(books.getId())) {
                booksList.remove(books);
                serialize(booksList, "books.txt");
                return books;
            }
        }
        return null;
    }

    /**
     * 删除借阅记录
     *
     * @param booksId
     * @return
     */
    @Override
    public int rmAuthorBooksRelationByBooksId(String booksId) {
        List<Author_Books_Relation> allRelationsList = getAllRelationsList();
        for (Author_Books_Relation relation : allRelationsList) {
            if (booksId.equals(relation.getBooks().getId())) {
                getAllRelationsList().remove(relation);
            }
        }
        //删除成功后重新序列化
        serialize(allRelationsList, "abr.txt");
        return 1;
    }

    /**
     * 获取所有读者的借阅信息
     */
    public List<Author_Books_Relation> getAllRelationsList() {
        Object o = descSeri("Author.txt");
        @SuppressWarnings("unchecked")
        List<Author_Books_Relation> list = (List<Author_Books_Relation>) o;
        return list;
    }


    /**
     * 序列化
     *
     * @param obj
     * @param descPath
     */
    private void serialize(Object obj, String descPath) {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File(descPath)));
            oos.writeObject(obj);
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

    /**
     * 反序列化文件
     *
     * @param s
     * @return
     */
    private Object descSeri(String s) {
        ObjectInputStream ois = null;
        Object o = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File(s)));
            o = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                assert ois != null;
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return o;
    }
}
