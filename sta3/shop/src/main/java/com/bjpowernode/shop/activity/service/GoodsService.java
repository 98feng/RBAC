package com.bjpowernode.shop.activity.service;

import com.bjpowernode.shop.activity.domain.Goods;
import com.bjpowernode.shop.exception.GoodsNotFoundException;

import java.util.List;

/**
 * @author feng
 * @date 2021/1/1
 * @Description
 */
public interface GoodsService {
    List<Goods> getGoodsList() throws GoodsNotFoundException;

    boolean addGoods(List<Goods> goodsList);

    boolean updateGoods(List<Goods> goodsList);

    boolean delGoodsById(List<Goods> goodsList);
}
