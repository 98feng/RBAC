package login;

import com.bjpowernode.shop.activity.domain.Goods;
import com.bjpowernode.shop.login.controller.UserController;
import mian.Main;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author feng
 * @date 2020/12/31
 * @Description
 */
public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====================主界面=====================");
        System.out.println("1、浏览所有商品\t2、注册\t3、登录\t4、退出");
        System.out.println("请选择您的操作：");
        int operate = scanner.nextInt();
        switch (operate) {
            case 1:
                Main.show();
                break;
            case 2:
                UserController.register();
                break;
            case 3:
                UserController.login();
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("输入有误请重新输入！");
        }
    }


    /**
     * 确保用户不为null！默认的用户名密码为admin
     */
    /*public static void main(String[] args) {
        ObjectOutputStream oos = null;
        List<User> list = new ArrayList<>();
        User user1 = new User("admin", "123");
        User user2 = new User("admin", "admin");
        list.add(user1);
        list.add(user2);
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("user.txt")));
            oos.writeObject(list);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    /**
     * 保证商品不为null
     */
    @Test
    public void addGoods() {
        Goods goods1 = new Goods("1001", "Mate30", "8900", "50000");
        Goods goods2 = new Goods("1002", "novo", "4500", "15000");
        Goods goods3 = new Goods("1003", "vivo", "8700", "36000");
        Goods goods4 = new Goods("1002", "oppo", "1200", "78000");
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        goodsList.add(goods4);
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("goods.txt")));
            oos.writeObject(goodsList);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
