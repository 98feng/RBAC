package day02.com.bjpowerndoe.homowork01.circleArrayQueue;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author feng
 * @date 2020/12/22
 * @Description 创建Collection集合, 存储Student对象
 * 向集合中添加5个Student对象
 * 判断集合中是否包含指定的Student对象
 * 判断集合中是否包含指定姓名的同学
 * 遍历集合中的所有对象··
 */
public class HomeWork {


    public static void main(String[] args) {

        /*Collection<Student> students = new CircleArray<>();
        students.add(new Student("0", 100));
        students.add(new Student("1", 103));
        students.add(new Student("2", 88));
        students.add(new Student("3", 200));
        students.add(new Student("4", 90));
        System.out.println(students);
        students.add(1,new Student("5", 90));
        System.out.println(students);
        students.add(1,new Student("6", 90));
        System.out.println(students);
        students.remove(1);
        System.out.println(students);
        students.remove(2);
        System.out.println(students);
        students.remove(3);
        System.out.println(students);
        students.remove(new Student("5",90));
        System.out.println(students);

        String strName= null;
        System.out.println(students.contains(new Student(strName)));*/


        /*这个排序用不了大神帮忙解决下*//*增强for循环也用不了*/
        /*for (Object o : cirArr) {
        }*//*CircleArray<Student> cirArr = new CircleArray<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                return o1.getsName().compareTo(o2.getsName());
            }
        });*/

        CircleArray<Student> cirArr = new CircleArray<>();
        cirArr.add(new Student("8", 100));
        cirArr.add(new Student("1", 103));
        cirArr.add(new Student("7", 88));
        cirArr.add(new Student("3", 200));
        cirArr.add(new Student("4", 90));
        System.out.println(cirArr);
        System.out.println("=========================");

        cirArr.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //姓名升序
                return -o1.getsName().compareTo(o2.getsName());
            }
        });
        System.out.println(cirArr);
        /**
         * 输出结果
         *   capcacity=10 size=5 front=0, [Student{sName='8', sAge=100},
         *   Student{sName='7', sAge=88},
         *   Student{sName='4', sAge=90},
         *   Student{sName='3', sAge=200},
         *   Student{sName='1', sAge=103},
         *   null,
         *   null,
         *   null,
         *   null,
         *   null]
         *
         */


    }

    static class Student {
        String sName;
        int sAge;

        public Student(String sName) {
            this.sName = sName;
        }

        public String getsName() {
            return sName;
        }

        public int getsAge() {
            return sAge;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Student student = (Student) o;
            return Objects.equals(sName, student.sName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sName, sAge);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Student{");
            sb.append("sName='").append(sName).append('\'');
            sb.append(", sAge=").append(sAge);
            sb.append('}');
            return sb.toString();
        }

        public Student(String sName, int sAge) {
            this.sName = sName;
            this.sAge = sAge;
        }

        public Student() {
        }

    }


}
