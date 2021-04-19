package com.bjpowernode.day12.nio.fileTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * @author feng
 * @date 2020/12/31
 * @Description
 */
public class FilesCopyTest {


    public static void main(String[] args) {


        String srcPath = "";
        String descPath = "";

        copyFiles(srcPath, descPath);

    }

    public static void copyFiles(String srcFile, String descFile) {

        File file = new File(srcFile);
        if (!file.exists()) {
            System.out.println("原文件不存在！");
        } else if (file.isFile()) {
            return;
        }
        //如果目标文件夹不存在创建目标文件夹
        File descDir = new File(descFile);
        if (!descDir.exists()) {
            descDir.mkdirs();
        }


        File[] listFiles = file.listFiles();
        assert listFiles != null;
        for (File listFile : listFiles) {
            //构建目标文件。文件夹对象
            File descFolder = new File(descFile, listFile.getName());
            //如果srcFile是文件就直接复制
            if (listFile.isFile()) {
                copyFileUsingJava7Files(listFile, descFolder);
            } else {
                //如果是子文件递归调用
                copyFiles(listFile.getAbsolutePath(), descFolder.getAbsolutePath());
            }
        }
    }


    private static void copyFileUsingJava7Files(File source, File dest) {
        try {
            Files.copy(source.toPath(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
