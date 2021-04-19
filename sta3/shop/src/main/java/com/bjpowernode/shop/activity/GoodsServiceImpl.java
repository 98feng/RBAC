package com.bjpowernode.shop.activity;

import com.bjpowernode.shop.activity.dao.GoodsDao;
import com.bjpowernode.shop.activity.dao.GoodsDaoImpl;
import com.bjpowernode.shop.activity.domain.Goods;
import com.bjpowernode.shop.activity.service.GoodsService;
import com.bjpowernode.shop.exception.GoodsNotFoundException;

import java.util.List;

/**
 * @author feng
 * @date 2021/1/1
 * @Description
 */
public class GoodsServiceImpl implements GoodsService {
    GoodsDao goodsDao = new GoodsDaoImpl();


    @Override
    public boolean updateGoods(List<Goods> goodsList) {
        boolean flag = true;
        int count = goodsDao.updateGoods(goodsList);
        if (count != 1){
            flag = false;
        }
        return flag;

    }

    @Override
    public boolean delGoodsById(List<Goods> goodsList) {
        boolean flag = true;
        int count = goodsDao.delGoodsById(goodsList);
        if (count != 1){
            flag = false;
        }
        return flag;
    }

    @Override
    public List<Goods> getGoodsList() throws GoodsNotFoundException {
        List<Goods> goodsList = goodsDao.getGoodsList();
        if (goodsList == null) {
            throw new GoodsNotFoundException("对不起商品没有找到！");
        }

        return goodsList;
    }

    @Override
    public boolean addGoods(List<Goods> goodsList){
        boolean flag = true;
        int count = goodsDao.addGoods(goodsList);
        if (count != 1) {
            flag = false;
//            throw new AddGoodsException("添加失败！");
        }
        return flag;
    }
}
