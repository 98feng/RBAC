package day02.com.bjpowerndoe.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author feng
 * @date 2020/12/19
 * @Description
 */
public class Test {

    public static void main(String[] args) {

        Person[] data = new Person[50];

        int size = 0;

        data[size++] = new Person("aaskndj", 18, 180.1);
        data[size++] = new Person("baskndj", 20, 186.2);
        data[size++] = new Person("caskndj", 17, 146.2);
        data[size++] = new Person("daskndj", 22, 176.3);
        data[size++] = new Person("easkndj", 23, 143.3);

        /*Arrays.sort(data, 2, size, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {

                return o1.age - o2.age;
            }
        });

        Arrays.sort(data, 1, size, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.height > o2.height) {
                    return -1;
                } else if (o1.height == o2.height) {
                    return 0;
                } else {
                    return 1;

                }
            }
        });

        Arrays.sort(data, 1, size, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return 0;
            }
        });*/

        Arrays.sort(data,0,size);
        System.out.println(Arrays.toString(data));
    }
}
