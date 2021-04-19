package bjpowernode.demo02;

import bjpowernode.demo01.Grade;

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

    public Student(String stuNo) {
        this.stuNo = stuNo;
    }

    public void print() {
        System.out.println("Student{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuAge='" + stuAge + '\'' +
                ", stuGender='" + stuGender + '\'' +
                ", stuGrade=" + stuGrade +
                '}');
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("等待回收。。。。。。。" + this);
        super.finalize();
    }
}
