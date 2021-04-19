package bjpowernode.domain04;

/**
 * @author feng
 * @date 2020/12/7
 * @Description 汽车实体类
 */
public class Car {
    /**
     * 车牌号
     */
    int carNo;
    /**
     * 品牌
     */
    String brand;
    /**
     * 颜色
     */
    String color;
    /**
     * 价格
     */
    int price;

    public Car() {
    }

    public Car(int carNo, String brand) {
        this.carNo = carNo;
        this.brand = brand;
    }

    public Car(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    public Car(String brand, String color, int price) {
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public Car(int carNo, String brand, String color, int price) {
        this.carNo = carNo;
        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public String toString() {
        return "Car{" +
                "carNo=" + carNo +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
