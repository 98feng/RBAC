package com.bjpowernode.day10.exception;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author feng
 * @date 2020/12/29
 * @Description
 */
public class ExceptionTest {

    @Test
    public void test01() {
        convert("动力节点", "GBK");
        convert("动力节点", "UTF--8");

        System.out.println("mianxiancheng");
    }

    public void convert(String stringText, String charSetName) {
        try {
            byte[] bytes = stringText.getBytes(charSetName);
            System.out.println(Arrays.toString(bytes));
        } catch (UnsupportedEncodingException e) {
            System.out.println("Exception");
        } finally {
            System.out.println("===============");
        }

    }
}
