package bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/10
 * @Description
 */
public class Test {
    public static void main(String[] args) {

        Book book = new Book();
        book.setbId("213");
        book.setbName("Java基础");
        book.setbNum(213);
        book.setbPrice(-1);

        String id = book.getbId();
        String name = book.getbName();
        int num = book.getbNum();
        int price = book.getbPrice();

        System.out.println("id" + id + "\tname" + name + "\tnum" + num + "\tprice" + price);

    }
}
