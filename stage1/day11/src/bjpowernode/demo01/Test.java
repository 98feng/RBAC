package bjpowernode.demo01;

/**
 * @author feng
 * @date 2020/12/8
 * @Description
 */
public class Test {

    public static void main(String[] args) {

        Grade grade = new Grade("2014","Java基础","3楼2教室");
        Student student1 = new Student("2014001","Jack","19","男",grade);


        Student student = new Student("2014001","Jack","19","男",
                new Grade("2014","Java基础","3楼2教室"));

        System.out.println(student);
        System.out.println(student1);


        String str = "Hi";
        String str1 = "Hi";
        System.out.println(str == str1);//true
    }
}
