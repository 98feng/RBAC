package com.bjpowernode.day11.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author feng
 * @date 2020/12/30
 * @Description
 */
public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File file = new File("obj.txt");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        Object o = ois.readObject();

        ois.close();

        List<Person> list = (List)o;

        for (Person person : list) {
            System.out.println(person);
        }
        System.out.println("=======================");
        System.out.println("o = " + o);
    }
}
