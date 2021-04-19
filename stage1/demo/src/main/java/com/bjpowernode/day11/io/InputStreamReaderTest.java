package com.bjpowernode.day11.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author feng
 * @date 2020/12/30
 * @Description \
 */
public class InputStreamReaderTest {

    public static void main(String[] args) throws IOException {

        File srcFile = new File("java.txt");
        File descFile = new File("javaGBK.txt");
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(descFile);

        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"GBK");

        char[] chars = new char[1024];
        int len;
        while((len = isr.read(chars)) != -1){
            osw.write(chars,0,len);
        }

        isr.close();
        osw.close();


    }


}
