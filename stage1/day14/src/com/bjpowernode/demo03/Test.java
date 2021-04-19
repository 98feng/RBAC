package com.bjpowernode.demo03;

/**
 * @author feng
 * @date 2020/12/12
 * @Description
 */
public class Test {

    public static void main(String[] args) {
        /*
            向上转型，自动类型转换
         */
        Person p = new Student();
//        p = new Teacher();
        /*
        当向下转型，强制类型转换，如果对象名中存放的是哪个子类对象，则就可以强制转换为哪个子类的类型
        如果非要转换为其他子类的数据类型，则就出现类型转换异常
         */
        if (p instanceof Student){
            /*Student stu = (Student)p;
            System.out.println(stu.sNo);*/
            System.out.println(((Student) p).sNo);
            ((Student)p).learn();
        }else if (p instanceof Teacher){
            Teacher t = (Teacher)p;
            System.out.println(t.tSal);
            t.teach();
        }
    }
}
