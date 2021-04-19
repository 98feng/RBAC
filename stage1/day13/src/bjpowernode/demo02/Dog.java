package bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/11
 * @Description
 */
public class Dog extends Animal {

    String dBreed;


    public Dog() {
        System.out.println("Dog无参构造");
    }

    public Dog(String dBreed) {
        this.dBreed = dBreed;
        System.out.println("dog一个参的构造");
    }

    public Dog(String aName, String aAge, String aColor, String dBreed) {
        super(aName, aAge, aColor);
        this.dBreed = dBreed;
        System.out.println("dog四个参数的构造器");
    }

    @Override
    public String toString() {
        return super.toString() + ", cBreed='" + dBreed + '\'' +'}';
    }
}
