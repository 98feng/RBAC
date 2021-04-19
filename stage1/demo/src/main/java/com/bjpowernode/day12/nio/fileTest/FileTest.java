package com.bjpowernode.day12.nio.fileTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author feng
 * @date 2020/12/31
 * @Description
 */
public class FileTest {

    public static void main(String[] args) throws IOException {

        File file1 = new File("java.txt");
        File file2 = new File("java.txt");
        File file3 = new File("java.txt");
        File file4 = new File("java.txt");

        boolean delete = file1.delete();
        System.out.println("delete = " + delete);

        System.out.println(file1.exists());

        boolean newFile = file1.createNewFile();
        System.out.println(newFile);

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getCanonicalFile());
        System.out.println("file1.getCanonicalPath() = " + file1.getCanonicalPath());
        System.out.println("file1.lastModified() = " + file1.lastModified());
        Date date = new Date(file1.lastModified());
        String format = new SimpleDateFormat("HH:mm:ss").format(date);
        String format1 = new SimpleDateFormat("HH:mm:ss").format(file1.lastModified());
        System.out.println("format1 = " + format1);
        System.out.println(format);

        System.out.println("file1.length() = " + file1.length());

        System.out.println("file1.canRead() = " + file1.canRead());


    }
}
