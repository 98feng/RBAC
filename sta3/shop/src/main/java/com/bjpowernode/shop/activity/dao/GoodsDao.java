package com.bjpowernode.shop.activity.dao;

import com.bjpowernode.shop.activity.domain.Goods;

import java.util.List;

/**
 * @author feng
 * @date 2021/1/1
 * @Description
 */
public interface GoodsDao {
    List<Goods> getGoodsList();

    int addGoods(List<Goods> goodsList);

    int updateGoods(List<Goods> goodsList);

    int delGoodsById(List<Goods> goodsList);
}
