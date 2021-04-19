package com.bjpowernode.day11.io;


import com.bjpowernode.day11.io.utils.Times;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;

/**
 * @author feng
 * @date 2020/12/29
 * @Description
 */
public class fileIoStream {

    public static void main(String[] args) {


        File srcPath = new File("E:\\bjpowernode\\stage2\\java.txt");//768M
        File descPath = new File("E:\\bjpowernode\\stage2\\ideaIU.txt");
        File java7FilesDescPath = new File("E:\\bjpowernode\\stage2\\ideaIU-2019.zip");

//        Times.test("copyFileUsingApacheCommons复制", () -> copyFileUsingApacheCommons(srcPath, descPath));
//        Times.test("copyFileWithBuffered复制", () -> copyFileWithBuffered(srcPath, descPath));
//        Times.test("copyFileUsingJava7Files复制", () -> copyFileUsingJava7Files(srcPath, java7FilesDescPath));
        Times.test("copyFileWithFileStream复制", () -> copyFileWithFileStream(srcPath, descPath));

       /*
       * 【copyFileUsingApacheCommons复制】
        开始：19:57:28.217
        结束：19:57:36.202
        耗时：7.984秒
        -------------------------------------
        【copyFileWithBuffered复制】
        开始：20:16:35.221
        结束：20:16:44.922
        耗时：9.699秒
        -------------------------------------
        【copyFileUsingJava7Files复制】
        开始：19:58:20.257
        结束：19:58:37.191
        耗时：16.934秒
        -------------------------------------
        【copyFileWithFileStream复制】
        开始：20:18:07.021
        结束：20:18:23.062
        耗时：16.04秒
        -------------------------------------*/
    }

    /**
     * 官方：将文件复制到保存文件日期的新位置。此方法将指定源文件的内容复制到指定目标文件。
     * 如果目标文件所在的目录不存在，则创建该目录。如果目标文件存在，则此方法将覆盖它
     * 注意：此方法尝试使用File.setLastModified（long）保留文件的上次修改日期/时间，但是不能保证操作将成功。
     * 如果修改操作失败，则不提供任何指示
     *
     * @param srcPath
     * @param destPath
     */
    private static void copyFileUsingApacheCommons(File srcPath, File destPath) {
        try {
            FileUtils.copyFile(srcPath, destPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 大文件的复制可以用Java nio中的channel-to-channel传输，Channel-to-channel传输是可以极其快速的，
     * 特别是在底层操作系统提供本地支持的时候。某些操作系统可以不必通过用户空间传递数据而进行直接的数据传输。
     * 对于大量的数据传输，这会是一个巨大的帮助。
     *
     * @param source
     * @param dest
     */
    private static void copyFileUsingJava7Files(File source, File dest) {
        try {
            Files.copy(source.toPath(), dest.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void copyFileWithBuffered(File srcPath, File destPath) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            FileInputStream fis = new FileInputStream((srcPath));
            FileOutputStream fos = new FileOutputStream(destPath);
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //复制的细节：读取、写入
            byte[] buffer = new byte[1024 * 192];//196608//393216
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //要求：先关闭外层的流，再关闭内层的流
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    private static void copyFileWithFileStream(File srcFile, File descFile) {

        try (FileInputStream fis = new FileInputStream(srcFile);
             FileOutputStream fos = new FileOutputStream(descFile)) {
            byte[] bytes = new byte[1];//192Kb
            int len;
            while ((len = fis.read()) != -1) {

                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据文件大小选择合适的字节大小
     */
    private static long checkFileSize(File srcFile) {
        long fileLength = srcFile.length();
        return 0;
    }


}
