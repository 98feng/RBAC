package com.bjpowernode.dao;


import com.bjpowernode.ioc.domain.Customer;
import com.bjpowernode.utils.SqlSessionUtil;
import org.junit.Test;

/**
 * @author feng
 * @date 2021/3/5
 * @Description
 */
public class CustomerMapperTest {

    CustomerMapper cm = SqlSessionUtil.getSqlSession().getMapper(CustomerMapper.class);
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
        Customer customer = cm.selectByPrimaryKey(1);
        System.out.println(customer);
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
