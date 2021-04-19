package mian;

import com.bjpowernode.shop.activity.controller.GoodsController;
import com.bjpowernode.shop.activity.domain.Goods;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/31
 * @Description
 */
public class Main {
    static List<Goods> goodsList = GoodsController.showGoods();

    public static void show() {
        print();
        System.out.println("请选择排序方式：1、名称升序\t2、价格升序\t3、销量降序");
        Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                sortByName();
                break;
            case 2:
                sortByPrice();
                break;
            case 3:
                sortBySales();
                break;
            default:
                System.out.println("输入有误！");
        }

    }

    private static void print() {
        System.out.println("==================商品信息=====================");
        System.out.println("商品编号\t商品名称\t\t商品价格\t销量");
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }

    private static void sortBySales() {
        goodsList.sort(new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                return o2.getGoodsSales().compareTo(o1.getGoodsSales());
            }
        });
        print();
    }

    private static void sortByPrice() {
        goodsList.sort(new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                return o1.getGoodsPrice().compareTo(o2.getGoodsPrice());
            }
        });
        print();
    }

    private static void sortByName() {
        goodsList.sort(new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                return o1.getGoodsName().compareTo(o2.getGoodsName());
            }
        });
        print();
    }

}

