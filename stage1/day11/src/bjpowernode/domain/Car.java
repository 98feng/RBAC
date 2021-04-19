package bjpowernode.domain;

/**
 * @author feng
 * @date 2020/12/8
 * @Description
 */
public class Car {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("当前对象即将释放：" + this);
    }
}
