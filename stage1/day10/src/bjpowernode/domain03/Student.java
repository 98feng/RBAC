package bjpowernode.domain03;

/**
 * @author feng
 * @date 2020/12/7
 * @Description
 */
public class Student {
    /**
     * 学号
     */
    int stuNo;
    /**
     * 姓名
     */
    String name;
    /**
     * 年龄
     */
    int age;
    /**
     * 性别
     */
    char gender;
    /**
     * 成绩
     */
    double score;
    /**
     * 住址
     */
    String addr;

    public Student() {
        System.out.println("学生类的空参构造器执行。。。。。。。。。。。。。");
    }

    public Student(int stuNo, String name, int age, char gender, double score, String addr) {
        this.stuNo = stuNo;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.score = score;
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "学号：" + stuNo +
                ", 姓名：'" + name + '\'' +
                ", 年龄：" + age +
                ", 性别：" + gender +
                ", 成绩：" + score +
                ", 住址：'" + addr + '\'';
    }
}
