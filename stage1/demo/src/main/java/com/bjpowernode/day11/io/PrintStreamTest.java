package com.bjpowernode.day11.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author feng
 * @date 2020/12/30
 * @Description
 */
public class PrintStreamTest {

    public static void main(String[] args) {
        //将异常打印到日志文件中
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(new FileOutputStream("java.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace(printStream);
        }
        printStream.print("把数据打印在文件中");
        printStream.println("打印完之后换行");
        printStream.println("这是第二行");

        System.out.println("kongzhitai1");
        PrintStream old = System.out;

        //修改System.out的打印方向
        System.setOut(printStream);
        System.out.println("这行会打印到文件中");

        //恢复打印方向
        System.setOut(old);
        System.out.println("控制台输出");



    }
}
