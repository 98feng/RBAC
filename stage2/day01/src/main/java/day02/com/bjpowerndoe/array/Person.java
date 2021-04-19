package day02.com.bjpowerndoe.array;

import java.util.Objects;

/**
 * @author feng
 * @date 2020/12/19
 * @Description
 */
public class Person implements Comparable<Person>{
    String name;
    int age;
    double height;

    public Person() {

    }

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", height=").append(height);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age &&
                Double.compare(person.height, height) == 0 &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, height);
    }

    @Override
    public int compareTo(Person o) {

        /*if (this.height > o.height){
            return 1;
        }else if(this.height == o.height){
            return 0;
        }else{
            return -1;
        }*/
        return Double.compare(this.height,o.height);
    }
}
