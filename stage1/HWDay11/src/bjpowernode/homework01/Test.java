package bjpowernode.homework01;

/**
 * @author feng
 * @date 2020/12/8
 * @Description 测试类： 	创建图书对象通过调用带参构造方法完成对属性赋值，并调用显示信息方法 	创建图书对象调用无参构造方法，并调用显示信息方法
 */
public class Test {

    public static void main(String[] args) {
        Book book = new Book("1001", "Java基础", "20", "1000", "Jack", new Press("001", "动力节点", "北京"));
        System.out.println(book);

        Book book1 = new Book();
        System.out.println(book1);
    }
}
