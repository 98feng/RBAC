package bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/8
 * @Description 学生类
 */
public class Student {
    /**
     * 学生编号
     */
    String stuNo;
    /**
     * 学生姓名
     */
    String stuName;
    /**
     * 学生年龄
     */
    String stuAge;
    /**
     * 学生性别
     */
    String stuGender;
    /**
     * 学生所在的年级
     */
    Grade stuGrade;

    public Student() {
    }

    public Student(String stuNo, String stuName, String stuAge, String stuGender, Grade stuGrade) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuGender = stuGender;
        this.stuGrade = stuGrade;
    }

    @Override
    public String toString() {
        return "学生{" +
                "编号：'" + stuNo + '\'' +
                ", 姓名：'" + stuName + '\'' +
                ", 年龄：'" + stuAge + '\'' +
                ", 性别：'" + stuGender + '\'' +
                ", 年级名称：'" + (stuGrade == null ? null : stuGrade.gradeName) + '\'' +
                ", 年级地址：'" + (stuGrade == null ? null : stuGrade.gradeAddr) + '\'' +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("等待回收。。。。。。。" + this);
        super.finalize();
    }
}
