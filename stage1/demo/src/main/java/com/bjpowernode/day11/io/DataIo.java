package com.bjpowernode.day11.io;

import java.io.*;

/**
 * @author feng
 * @date 2020/12/30
 * @Description
 */
public class DataIo {
    public static void main(String[] args) throws IOException {

        File srcFile = new File("java.txt");
        FileOutputStream fos = new FileOutputStream(srcFile);
        DataOutputStream dos = new DataOutputStream(fos);
        dos.write(123);
        dos.writeBoolean(false);
        dos.writeDouble(123.123);
        dos.writeUTF("字符串");

        dos.flush();

        dos.close();
//        fos.close();
    }
}
class DataIOTest{
    public static void main(String[] args) throws IOException {

        File srcFile = new File("java.txt");
        FileInputStream fis = new FileInputStream(srcFile);
        DataInputStream dis = new DataInputStream(fis);
        int i = dis.readInt();
        boolean b = dis.readBoolean();
        double v = dis.readDouble();
        String s = dis.readUTF();

        dis.close();

        System.out.println("i = " + i);
        System.out.println("b = " + b);
        System.out.println("v = " + v);
        System.out.println("s = " + s);
    }
}
