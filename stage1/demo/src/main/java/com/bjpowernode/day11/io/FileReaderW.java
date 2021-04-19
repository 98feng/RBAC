package com.bjpowernode.day11.io;

import java.io.*;

/**
 * @author feng
 * @date 2020/12/30
 * @Description
 */
public class FileReaderW {
    public static void main(String[] args) throws IOException {


        File srcFile = new File("java.txt");
        File descFile = new File("obj1.txt");
        BufferedReader br = new BufferedReader(new FileReader(srcFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(descFile));

        String data;
        while((data = br.readLine()) != null){
            bw.write(data);
            bw.newLine();
        }

        bw.close();
        br.close();


    }
}
