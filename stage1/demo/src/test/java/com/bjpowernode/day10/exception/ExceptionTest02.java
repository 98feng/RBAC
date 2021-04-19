package com.bjpowernode.day10.exception;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author feng
 * @date 2020/12/29
 * @Description
 */
public class ExceptionTest02 {

    @Test
    public void test01() {


    }

    @Test
    public void fileRead() {
        FileReader fr = null;
        try {
            fr = new FileReader(new File("Test.txt"));
            char[] chars = new char[1024];
            int len;
            while ((len = fr.read(chars)) != -1) {
                String str = new String(chars, 0, len);
                System.out.println(str);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void fileWrite() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File("Test.txt"),false);
            fw.write("hello world! \n");
            fw.write("you need to hava a dream！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
