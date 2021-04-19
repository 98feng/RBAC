package bjpowernode.demo02;

/**
 * @author feng
 * @date 2020/12/8
 * @Description
 */
public class Test {

    public static void main(String[] args) {

        Student s1 = new Student("213");
        System.out.print(s1);//bjpowernode.demo02.Student@1b6d3586
//        Test.change();
    }

    /*private static void change() {
        String[] str = new String[10];

        Test.main(str);//Exception in thread "main" java.lang.StackOverflowError
    }*/

}
