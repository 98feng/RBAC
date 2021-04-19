package mian;

import com.bjpowernode.shop.activity.controller.GoodsController;

import java.util.Scanner;

/**
 * @author feng
 * @date 2021/1/1
 * @Description
 */
public class GoodsManage {
    public static void success() {
        System.out.println("============产品管理界面============");
        System.out.println("1、显示所有商品");
        System.out.println("2、添加商品");
        System.out.println("3、修改商品");
        System.out.println("4、删除商品");
        System.out.println("5、查找商品");
        System.out.println("6、退出");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入您的选择：");
        int num = scanner.nextInt();
        switch (num) {
            case 1:
                Main.show();
                break;
            case 2:
                GoodsController.addGoods();
                break;
            case 3:
                GoodsController.updateGoods();
                break;
            case 4:
                GoodsController.delGoodsById();
                break;
            case 5:
                GoodsController.selectGoodsByName();
                break;
            case 6:
                System.exit(0);
                break;
            default:
                System.out.println("输入信息有误！");

        }

    }

}
