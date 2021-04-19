package com.bjpowernode.day08.homework;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author feng
 * @date 2020/12/26
 * @Description
 */
public class Test01 {
    @Test
    public void test01() {
        /*ResourceBundle bundle = ResourceBundle.getBundle("config.txt");
        System.out.println(bundle.getString("username"));
        System.out.println(bundle.getString("password"));*/
        Properties pros = new Properties();

        String resource = "config.txt";
        InputStream inputStream = null;
        try {
//            inputStream = Test01.class.getClassLoader().getResourceAsStream(resource);
            inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
            pros.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println(pros.getProperty("username"));
        System.out.println(pros.getProperty("password"));
    }


}
