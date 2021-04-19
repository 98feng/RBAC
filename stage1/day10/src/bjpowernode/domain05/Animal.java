package bjpowernode.domain05;

/**
 * @author feng
 * @date 2020/12/7
 * @Description 变量的赋值时机
 */
public class Animal {

    private String name = "Animal";

    public Animal() {
        a();
    }

    public void a() {
        System.out.println(name);
    }

}

class Dog extends Animal {

    private String name = "Dog";

    public void a() {
        //构造方法没有执行完毕，此时的name = null
        System.out.println(name);
    }

    public static void main(String[] args) {
        Animal animal = new Dog();//null
    }
}