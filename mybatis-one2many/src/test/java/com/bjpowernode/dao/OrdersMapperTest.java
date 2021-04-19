package com.bjpowernode.dao;

import com.bjpowernode.ioc.domain.Orders;
import com.bjpowernode.utils.SqlSessionUtil;
import org.junit.Test;

/**
 * @author feng
 * @date 2021/3/5
 * @Description
 */
public class OrdersMapperTest {

    OrdersMapper om = SqlSessionUtil.getSqlSession().getMapper(OrdersMapper.class);
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
        Orders orders = om.selectByPrimaryKey(11);
        System.out.println(orders);
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
