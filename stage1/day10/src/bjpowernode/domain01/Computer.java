package bjpowernode.domain01;

/**
 * @author feng
 * @date 2020/12/7
 * @Description 电脑实体类
 */
public class Computer {
    /**
     * 尺寸
     */
    double size;
    /**
     * 价格
     */
    double price;

    /**
     * 品牌
     */
    String brand;

    /**
     * 颜色
     */
    String color;

    /**
     * @param
     * @return String
     * @Description 返回电脑属性toString
     * @date 2020/12/7
     */
    public String toString() {
        return "尺寸：" + size +
                ", 价格：" + price +
                ", 品牌：'" + brand + '\'' +
                ", 颜色：'" + color + '\'';
    }
}
