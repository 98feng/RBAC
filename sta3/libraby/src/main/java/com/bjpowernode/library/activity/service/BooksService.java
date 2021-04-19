package com.bjpowernode.library.activity.service;

import com.bjpowernode.library.activity.domain.Books;
import com.bjpowernode.library.exception.BooksNotFoundException;
import com.bjpowernode.library.exception.RmBooksByIdException;

import java.util.List;

/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
public interface BooksService {


    /**
     * 获取所有的图书
     *
     * @return
     * @throws BooksNotFoundException
     */
    List<Books> getBooksList() throws BooksNotFoundException;

    /**
     * 添加图书
     *
     * @param books1
     * @return
     */
    boolean addBooks(Books books1);

    /**
     * 删除图书
     *
     * @param booksId
     * @return
     * @throws RmBooksByIdException
     */
    Books rmBooksById(String booksId) throws RmBooksByIdException;

    /**
     * 删除图书对应的借阅信息
     *
     * @param booksId
     * @return
     */
    boolean rmAuthorBooksRelationByBooksId(String booksId);
}
