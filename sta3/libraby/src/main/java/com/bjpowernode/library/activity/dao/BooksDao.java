package com.bjpowernode.library.activity.dao;

import com.bjpowernode.library.activity.domain.Books;

import java.util.List;

/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
public interface BooksDao {
    /**
     * 获取所有的图书
     *
     * @return
     */
    List<Books> getBooksList();

    /**
     * 添加图书
     *
     * @param books
     * @return
     */
    int addBooks(Books books);

    /**
     * 删除图书
     *
     * @param booksId
     * @return
     */
    Books rmBooksById(String booksId);

    /**
     * 删除图书对应的借阅信息
     *
     * @param booksId
     * @return
     */
    int rmAuthorBooksRelationByBooksId(String booksId);
}
