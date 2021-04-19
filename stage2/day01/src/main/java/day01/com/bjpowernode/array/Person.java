package main.java.day01.com.bjpowernode.array;

/**
 * @author feng
 * @date 2020/12/18
 * @Description
 */
public class Person {
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
