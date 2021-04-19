package com.bjpowernode.day10.exception;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.junit.Test;

/**
 * @author feng
 * @date 2020/12/29
 * @Description
 */
public class TestException {

    @Test
    public void test01() {
        Person person = new Person();

        try {
            person.setAge(-18);
        } catch (MyException e) {
            String message = e.getMessage();
            System.out.println(message);
        }

        System.out.println(person);
        person.setGender("...");
        System.out.println(person);

    }


    @Data
    static class Person {

        private String name;
        private int age;
        private String gender;

        public void setAge(int age) throws MyException {
            if (age < 0 || age > 200) {
                throw new MyException("年零不合法！");
            }
            this.age = age;
        }


        public void setGender(String gender) {
            if (!("男".equals(gender) || "女".equals(gender))) {
                throw new MyRuntimeException("性别不合法！");
            }
            this.gender = gender;
        }

    }
}