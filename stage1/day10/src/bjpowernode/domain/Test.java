package bjpowernode.domain;



/**
 * @author feng
 * @date 2020/12/7
 * @Description 测试类
 */
public class Test {

    public static void main(String[] args) {

        Student student = new Student();

        System.out.println(student.name);
        System.out.println(student.age);
        System.out.println(student.gender);
        System.out.println(student.weight);
        System.out.println(student.height);

        student.name = "lisi";
        student.age = 18;
        student.gender = '男';
        student.weight = 60;
        student.height = 1.78;

        System.out.println("姓名：" + student.name + "\n年龄：" + student.age + "\n性别：" + student.gender + "\n身高：" + student.height + "\n体重：" + student.weight);

    }
}
