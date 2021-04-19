package com.bjpowernode.shop.activity.dao;

import com.bjpowernode.shop.activity.domain.Goods;

import java.io.*;
import java.util.List;

/**
 * @author feng
 * @date 2021/1/1
 * @Description
 */
public class GoodsDaoImpl implements GoodsDao {

    /***
     * 根据id删商品
     * @return
     */
    @Override
    public int delGoodsById(List<Goods> goodsList) {
        ObjectOutputStream oos = null;
        String message = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("goods.txt")));
            oos.writeObject(goodsList);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            message = e.getMessage();
//            throw e.getCause();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return message == null ? 1 : -1;
    }
    /**
     * 修改商品
     * @param goodsList
     * @return
     */
    @Override
    public int updateGoods(List<Goods> goodsList) {
        ObjectOutputStream oos = null;
        String message = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("goods.txt")));
            oos.writeObject(goodsList);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            message = e.getMessage();
//            throw e.getCause();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return message == null ? 1 : -1;
    }




    /**
     * 添加商品
     *
     * @param goodsList
     * @return
     */
    @Override
    public int addGoods(List<Goods> goodsList) {
        ObjectOutputStream oos = null;
        String message = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("goods.txt")));
            oos.writeObject(goodsList);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
             message = e.getMessage();
//            throw e.getCause();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return message == null ? 1 : -1;
    }


    /**
     * 查询
     *
     * @return
     */
    @Override
    public List<Goods> getGoodsList() {
        List<Goods> goodsList = null;
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("goods.txt")));

            goodsList = (List<Goods>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return goodsList;
    }

}
