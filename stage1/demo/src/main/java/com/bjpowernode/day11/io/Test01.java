package com.bjpowernode.day11.io;

import java.io.*;

/**
 * @author feng
 * @date 2020/12/30
 * @Description
 */
public class Test01 {

    public static void main(String[] args) throws IOException {

        File file = new File("java.txt");
        System.out.println("输入：");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        String key = br.readLine();
        while(!"quit".equalsIgnoreCase(key)){
            key = key + "213";
            bw.write(key);
            bw.newLine();
            key = br.readLine();
        }

        br.close();
        bw.close();
    }
}
