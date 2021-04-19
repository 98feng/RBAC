package bjpowernode.domain04;

/**
 * @author feng
 * @date 2020/12/7
 * @Description 测试类
 */
public class Test {
    public static void main(String[] args) {

        Car car = new Car();
        System.out.println(car);


        Car car1 = new Car(123, "奥迪");
        System.out.println(car1);

        Car car2 = new Car("宝马", 200000);
        System.out.println(car2);

        Car car3 = new Car("大众", "黑色", 100000);
        System.out.println(car3);

        Car car4 = new Car(123, "五菱宏光", "白色", 1000);
        System.out.println(car4);
    }
}
