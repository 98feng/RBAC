package com.bjpowernode.day11.io;

import java.io.*;

/**
 * @author feng
 * @date 2020/12/30
 * @Description
 */
public class FileKey {
    public static void main(String[] args) throws IOException {

        File srcfile = new File("javammm.txt");
        File descfile = new File("javatyuan.txt");

        FileInputStream fis = new FileInputStream(srcfile);
        FileOutputStream fos = new FileOutputStream(descfile);

        System.out.println("请输入密码：");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String key = bf.readLine();
        int len;
        while ((len = fis.read())!= -1){
            len = len ^ Integer.parseInt(key);
            fos.write(len);
        }
        bf.close();
        fis.close();
        fos.close();
    }



}
