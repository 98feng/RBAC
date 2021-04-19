package bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/11
 * @Description
 */
public class Cat extends Animal{

    String cBreed;

    @Override
    public String toString() {
        return "Cat{" +
                "cName='" + aName + '\'' +
                ", cAge='" + aAge + '\'' +
                ", cColor='" + aColor + '\'' +
                ", cBreed='" + cBreed + '\'' +
                '}';
    }



}
