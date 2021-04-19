package bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/11
 * @Description
 */
public class Dog extends Animal {


    String dGender;


    @Override
    public String toString() {
        return "Dog{" +
                "dName='" + aName + '\'' +
                ", dAge='" + aAge + '\'' +
                ", dColor='" + aColor + '\'' +
                ", dGender='" + dGender + '\'' +
                '}';
    }
}
