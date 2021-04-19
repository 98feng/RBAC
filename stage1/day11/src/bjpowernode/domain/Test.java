package bjpowernode.domain;


/**
 * @author feng
 * @date 2020/12/8
 * @Description
 */
public class Test {



    public static void main(String[] args) {


        String name;//表示声名一个String类型变量name；也就是可以使用类型作为java中的类型因此得到，
        //我们可以使用类名作为java中的数据类型。grade，book car 拘捕变量没有默认值
        //除了String用户自定义的类型Car、Computer、Student类
        //类就是引用数据类型
        Car c = new Car();
        Car cc = new Car();
        //解决办法，当我们在访问对象中的属性或对象中的方法之前，必须保证对象名中存放的是对象的内存地址
        //空指针异常运行错误
        //原因当前对象存储的是null，也就是没有在纸箱某个对象，因此·就不能访问对象中的方法
        //解决办法：在访问之前必须保证对象保存的内存地址不为空
        c = cc = null;

        System.gc();



    }

}
