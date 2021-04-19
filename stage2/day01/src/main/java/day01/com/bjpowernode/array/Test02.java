package main.java.day01.com.bjpowernode.array;

/**
 * @author feng
 * @date 2020/12/18
 * @Description
 */
public class Test02 {

    public static void main(String[] args) {

        Person[] people = new Person[10];
        int size = 0;

        Person p = new Person("lisi");
        Person p2 = new Person("zhangsan");
        Person p3 = new Person("wangwu");

        people[size++] = p;
        people[size++] = p2;
        people[size++] = p3;

        /*for (Person person : people) {
            System.out.println(person);
        }*/
        for (int i = 0; i < size; i++) {

            System.out.println(people[i]);
        }

        String str = "wangwu";
        /*boolean flag = false;
        //indexOf
        for (int i = 0; i < size; i++) {

            if (str.equals(people[i].name)){
                flag = true;
            }
        }

        if (flag) {
            System.out.println(str + "存在");
        }else {
            System.out.println(str + "不存在");
        }*/

        int index = -1;
        str = "wangwu";
        for (int i = 0; i < size; i++) {
            if (str.equals(people[i].name)) {
                index = i;
                break;
            }
        }

        if (index > 0) {
            System.arraycopy(people, index + 1, people, index, size - index - 1);
            people[size - 1] = null;
            size--;
        } else {
            System.out.println(str + "不存在");
        }
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (str.equals(people[i].name)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println(str + "cunzai");
        } else {
            System.out.println("bu");
        }



    }
}
