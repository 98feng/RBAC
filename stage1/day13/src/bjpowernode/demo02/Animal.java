package bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/11
 * @Description
 */
public class Animal {

    String aName;
    String aAge;
    String aColor;

    public Animal() {
        System.out.println("Animal无参构造");
    }

    public Animal(String aName, String aAge, String aColor) {
        this.aName = aName;
        this.aAge = aAge;
        this.aColor = aColor;
        System.out.println("Animal带三个参数的构造方法");
    }

    public String toString() {
        return "Animal{" +
                "aName='" + aName + '\'' +
                ", aAge='" + aAge + '\'' +
                ", aColor='" + aColor + '\'';
    }
}
