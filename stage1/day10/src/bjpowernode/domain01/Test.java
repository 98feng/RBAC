package bjpowernode.domain01;


/**
 * @author feng
 * @date 2020/12/7
 * @Description 测试类
 */
public class Test {

    public static void main(String[] args) {

        //这是注释
        Computer computer = new Computer();
        System.out.println(computer);
        //注释
        Computer computer1 = new Computer();
        //注释1
        computer1.size = 24.0;
        computer1.price = 24.0;
        computer1.brand = "华硕";
        computer1.color = "黑白";
        //注释2
        System.out.println("=====================================================");
        System.out.println(computer1);

    }
}
