package com.bjpowernode.day08.homework;

import java.util.UUID;
/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */

public class UUIDUtil {

    public static String getUUID(){

        return UUID.randomUUID().toString().replaceAll("[-a-z]","");

    }

}
