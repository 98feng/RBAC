package bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/10
 * @Description
 *  封装
 *  概念隐藏类的内部信息，不允许外部类直接访问，而是通过方法完成
 *  第一步，将实例变量编写为private 表示只能在本类中使用
 *  第二步，编写对应方法（赋值、取值方法）
 *  按Alt + Insert键，选择第二项。也就是取值方法，比如getXxx()
 *  注意一般一个实例变量对应一个取值方法
 *  选择第三项Setter就是赋值方法，比如：setXxx();
 *  注意：一般一个实例变量对应一个赋值方法
 *  光标放在类中，按Alt + Insert键，选择第四项Getter and Setter,也就是取值和赋值方法
 *  注意一个实例变量对应一个取值和赋值方法
 *  根据情况在赋值方法中判断语句
 *  比如年龄在1--150岁合法，否则实例变量为18岁
 *  性别只能是男或女，否则
 *
 *
 */
public class Test01 {
    public static void main(String[] args) {

        Student student = new Student();
    }
}
