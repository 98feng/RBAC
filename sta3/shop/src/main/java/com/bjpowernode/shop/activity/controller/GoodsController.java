package com.bjpowernode.shop.activity.controller;

import com.bjpowernode.shop.activity.GoodsServiceImpl;
import com.bjpowernode.shop.activity.domain.Goods;
import com.bjpowernode.shop.activity.service.GoodsService;
import com.bjpowernode.shop.exception.GoodsNotFoundException;
import com.bjpowernode.shop.utils.ServiceFactory;
import mian.GoodsManage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author feng
 * @date 2021/1/1
 * @Description
 */
public class GoodsController {

    /**
     * 根据编号删商品
     */
    public static void delGoodsById() {
        GoodsService gs = (GoodsService) ServiceFactory.getService(new GoodsServiceImpl());
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品编号：");
        String gi = scanner.next();
        List<Goods> goodsList = showGoods();
        for (Goods goods : goodsList) {
            if (gi.equals(goods.getGoodsNo())) {
                goodsList.remove(goods);
                System.out.println("删除成功！");
            } else {
                System.out.println("删除失败！");
            }
           boolean flag =  gs.delGoodsById(goodsList);
        }

    }

    /**
     * 修改商品信息
     */
    public static void updateGoods() {
        GoodsService gs = (GoodsService) ServiceFactory.getService(new GoodsServiceImpl());
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品编号：");
        String no = scanner.next();
        List<Goods> goodsList = showGoods();
        for (Goods goods : goodsList) {
            if (no.equals(goods.getGoodsNo())) {
                System.out.println("请输入商品编号");
                String gn = scanner.next();
                goods.setGoodsNo(gn);
                System.out.println("请输入商品名称");
                String gName = scanner.next();
                goods.setGoodsName(gName);
                System.out.println("请输入商品价格");
                String gp = scanner.next();
                goods.setGoodsPrice(gp);
                System.out.println("请输入商品销量");
                String gse = scanner.next();
                goods.setGoodsSales(gse);
            } else {
                System.out.println("没有该商品！");
            }
        }
        boolean flag = gs.updateGoods(goodsList);
    }

    /**
     * 根据名称查询商品
     */
    public static void selectGoodsByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品名称：");
        String name = scanner.next();
        List<Goods> goodsList = showGoods();
        for (Goods goods : goodsList) {
            if (name.equals(goods.getGoodsName())) {
                System.out.println(goods);
                return;
            }else {
                System.out.println("没有该商品");
            }
        }
    }

    /***
     * 添加商品
     */
    static List<Goods> goodsList = new ArrayList<>();

    public static void addGoods() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品编号：");
        String goodsId = scanner.next();
        System.out.println("请输入商品名称：");
        String goodsName = scanner.next();
        System.out.println("请输入商品价格：");
        String goodsPrice = scanner.next();
        System.out.println("请输入商品销量：");
        String goodsSales = scanner.next();
        Goods goods = new Goods(goodsId, goodsName, goodsPrice, goodsSales);
        goodsList.add(goods);
        System.out.println("是否继续?(y/n)");
        String isContinue = scanner.next();
        switch (isContinue) {
            case "y":
                addGoods();
                break;
            case "n":
                GoodsManage.success();
                break;
            default:
                System.out.println("输入有误！");
        }
        GoodsService gs = (GoodsService) ServiceFactory.getService(new GoodsServiceImpl());
        boolean flag = gs.addGoods(goodsList);

    }

    /**
     * 显示商品
     *
     * @return
     */
    public static List<Goods> showGoods() {
        GoodsService gs = null;
        List<Goods> goodsList = null;
        try {
            gs = (GoodsService) ServiceFactory.getService(new GoodsServiceImpl());
            goodsList = gs.getGoodsList();
        } catch (GoodsNotFoundException e) {
            String message = e.getMessage();
            System.out.println(message);
        }
        return goodsList;
    }

}
