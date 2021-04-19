package com.bjpowernode.dao;


import com.bjpowernode.ioc.domain.Book;
import com.bjpowernode.utils.SqlSessionUtil;
import org.junit.Test;

/**
 * @author feng
 * @date 2021/3/4
 * @Description
 */
public class BookMapperTest {

    BookMapper bm = SqlSessionUtil.getSqlSession().getMapper(BookMapper.class);
    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        Book book = bm.selectByPrimaryKey(1);
        System.out.println(book);
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }

    @Test
    public void updateBatch() {
    }

    @Test
    public void batchInsert() {
    }
}
