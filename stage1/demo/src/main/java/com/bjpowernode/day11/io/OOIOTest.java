package com.bjpowernode.day11.io;

import lombok.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author feng
 * @date 2020/12/30
 * @Description
 */
public class OOIOTest {

    public static void main(String[] args) throws IOException {

        Person person = new Person("zghab", 12, "男");
        Person person1 = new Person("zghab", 12);
        List<Person> list = new ArrayList<>();
        list.add(person);
        list.add(person1);

        File file = new File("obj.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(list);
        oos.close();

    }
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(exclude = {"name", "age"})
class Person implements Serializable {
    private static final long serialVersionUID = 6433582252453531370L;
    String name;
    int age;
    String gender;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
