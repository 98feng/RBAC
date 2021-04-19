package bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/11
 * @Description
 */
public class Cat extends Animal {

    String cBreed;

    /**
     *  当使用super关键字访问父类构造方法是小括号，没有内容则调用父类的无参构造方法
     *  默认不写等价于super();
     */


    public Cat() {
//        super();默认调用
    }

    public Cat(String cBreed) {
//        super();默认调用父类无参
        this.cBreed = cBreed;
    }

    public Cat(String aName, String aAge, String aColor, String cBreed) {
//        super(aName, aAge, aColor);默认调用父类三个参
        this.cBreed = cBreed;
    }

    /*@Override
    public String toString() {
        */
    /**
     * 使用this关键字访问实例变量是，查找顺序
     * 首先在当前类中找实例变量或者实例方法，
     * 若果找到则直接引用，没有找到则去父类中找
     *//*
        return "Cat{" +
                "cName='" + aName + '\'' +
                ", cAge='" + aAge + '\'' +
                ", cColor='" + aColor + '\'' +
                ", cBreed='" + cBreed + '\'' +
                '}';
    }*/

    /**
     * super关键字只能在子类中使用，访问父类的信息
     * super关键字可以访问父类中的实例变量和实例方法
     * super关键字访问父类中的实例变量或父类中的实例方法是
     *  直接去符类中找
     * 当访问子类独有的实例变量是，只能使用this.
     * 在子类中若果要调用父类中的方法是，只能使用super.否则出现递归调用
     * @return cat属性
     */
    @Override
    public String toString() {
        return super.toString() + ", cBreed='" + cBreed + '\'' +'}';
    }
}
