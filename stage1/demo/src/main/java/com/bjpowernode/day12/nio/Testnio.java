package com.bjpowernode.day12.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author feng
 * @date 2020/12/31
 * @Description
 */
public class Testnio {

    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("java.txt");
        FileChannel channel = fileInputStream.getChannel();
        MappedByteBuffer byteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, fileInputStream.available());

        Charset charset = Charset.defaultCharset();
        CharBuffer decode = charset.decode(byteBuffer);
        System.out.println(decode);

        FileOutputStream fileOutputStream = new FileOutputStream("java2.txt");
        FileChannel channel1 = fileOutputStream.getChannel();

        byteBuffer.flip();
        channel1.write(byteBuffer);

        channel.close();
        channel1.close();
        fileOutputStream.close();
        fileInputStream.close();


    }



}
