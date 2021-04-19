package com.bjpowernode.day12.nio.fileTest;

import java.io.File;

/**
 * @author feng
 * @date 2020/12/31
 * @Description
 */
public class FileTest02 {

    public static void main(String[] args) {

        File file = new File("E:\\bjpowernode");

//        showFiles("E:\\bjpowernode");

        rmFiles("E:\\bjpowernode\\stage1 - 副本");
    }

    public static void showFiles(String srcPath) {
        if (srcPath == null) {
            return;
        }

        File file = new File(srcPath);
        if (!file.exists()) {
            System.out.println("文件夹不存在");
            return;
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                System.out.println(file1);

                if (file1.isDirectory()) {
                    showFiles(file1.getAbsolutePath());
                } else {
                    System.out.println(file1);
                }
            }

        }
    }


    public static void rmFiles(String srcPath) {
        if (srcPath == null) {
            return;
        }

        File file = new File(srcPath);
        if (!file.exists()) {
            System.out.println("文件不存在！");
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {

                if (files[i].isDirectory()) {
                    rmFiles(files[i].getAbsolutePath());
                }
                files[i].delete();
            }
        }

        file.delete();
    }


}
