package bjpowernode.domain;

/**
 * @author feng
 * @date 2020/12/7
 * @Description 学生类
 */
public class Student {

    /**
     * 姓名
     */
    String name;
    /**
     * 性别
     */
    char gender;
    /**
     * 年龄
     */
    int age;
    /**
     * 身高
     */
    double height;
    /**
     * 体重
     */
    double weight;

    /**
     * @Description 空参构造器
     * @date 2020/12/7
     * @param
     * @return
     *
     */
    public Student(){
        System.out.println("====================");
    }



    /**
     * @param
     * @return void
     * @Description 学习
     * @date 2020/12/7
     */
    public void study() {
        System.out.println("正在学习中。。。。。。。。。。。");
    }

}
