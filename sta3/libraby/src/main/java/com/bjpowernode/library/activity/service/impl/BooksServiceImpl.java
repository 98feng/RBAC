package com.bjpowernode.library.activity.service.impl;

import com.bjpowernode.library.activity.dao.BooksDao;
import com.bjpowernode.library.activity.domain.Books;
import com.bjpowernode.library.activity.service.BooksService;
import com.bjpowernode.library.annotation.AuthoWrite;
import com.bjpowernode.library.annotation.Bean;
import com.bjpowernode.library.exception.BooksNotFoundException;
import com.bjpowernode.library.exception.RmBooksByIdException;

import java.util.List;

import static mian.Main.objectApplicationContext;

/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
@Bean
public class BooksServiceImpl implements BooksService {
    public BooksServiceImpl() {}
    @AuthoWrite
    BooksDao bd;// = (BooksDao) objectApplicationContext.getBean(BooksDao.class);


    @Override
    public List<Books> getBooksList() throws BooksNotFoundException {
        List<Books> list = bd.getBooksList();
        if (list == null) {
            throw new BooksNotFoundException("图书未找到！");
        }
        return list;
    }

    /**
     * 添加图书
     *
     * @param books
     * @return
     */
    @Override
    public boolean addBooks(Books books) {
        boolean flag = true;
        int count = bd.addBooks(books);
        if (count != 1) {
            flag = false;
        }
        return flag;
    }


    @Override
    public Books rmBooksById(String booksId) throws RmBooksByIdException {
        Books books = bd.rmBooksById(booksId);
        if (books == null) {
            throw new RmBooksByIdException("删除图书错误！");
        }
        return books;
    }

    /**
     * 删除借阅记录
     *
     * @param booksId
     * @return
     */
    @Override
    public boolean rmAuthorBooksRelationByBooksId(String booksId) {
        boolean flag = true;
        int count = bd.rmAuthorBooksRelationByBooksId(booksId);
        if (count != 1) {
            flag = false;
        }
        return flag;

    }

}
