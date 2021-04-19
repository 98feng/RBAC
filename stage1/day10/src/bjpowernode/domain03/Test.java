package bjpowernode.domain03;

/**
 * @author feng
 * @date 2020/12/7
 * @Description
 */
public class Test {
    public static void main(String[] args) {

        Student student = new Student();
        System.out.println(student);
        System.out.println("==============================================================");

        Student student1 = new Student(001,"lisi",20,'男',100.0,"北京市");
        System.out.println(student1);
        //使用构造方法完成赋值,在同一个类中，参数列表不同个数不同、类型不同、顺序不同，至少编写2个构造方法
        //当创建对象是，根据实参自动找相匹配的构造方法执行，否则出现编译错误，构造方法重载：在使用时相对更灵活
        //构造方法没有返回值类型

    }
}
