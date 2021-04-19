package com.bjpowernode.day03.demo;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author feng
 * @date 2020/12/22
 * @Description
 */
public class BigDecimal1 {

    @Test
    public void test(){


        DecimalFormat df = new DecimalFormat("###,###.0000");
        String ss  = df.format(21312312.5);
        System.out.println(ss);

    }

    @Test
    public void testBigInteger(){
        BigInteger bi = new BigInteger("1231234233452565");
        BigDecimal bd = new BigDecimal("11");
        BigDecimal bd2 = new BigDecimal("12131245.86782341231");
        System.out.println(bi);

        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        System.out.println(time);
    }


    @Test
    public void test2() throws ParseException {
        Date date = new Date();
        System.out.println(date);//Tue Dec 22 11:56:08 CST 2020
        System.out.println(date.getTime());//1608609049512

        Date date1 = new Date(1608609049512L);
        System.out.println(date1);//Tue Dec 22 11:50:49 CST 2020

        java.sql.Date date2 = new java.sql.Date(1608609049512L);
        System.out.println(date2);//2020-12-22

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        String text = "2020年12月22日 11:56:08";

        //根据text字符串的格式指定模式串
        sdf.applyPattern("yyyy年M月d日 H:mm:ss");
//        System.out.println(sdf.format(date));//2020-12-22 11:56:08
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年M月d日 H:mm:ss");
        System.out.println(sdf1.format(date));//2020年12月22日 12:32:26
        System.out.println(sdf1.parse(text));//Tue Dec 22 11:56:08 CST 2020

        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
        System.out.println(date7);//2020-12-22


    }

    @Test
    public void test4(){
        /*获取当前系统时间*/
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter def = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String ss = localDateTime.format(def);
        System.out.println(ss);//2020-12-22 14:50:24

        /*将字符串解析为日期对象*/
        String text = "2020年11月22日 7:12:58";
        def = DateTimeFormatter.ofPattern("yyyy年MM月d日 H:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(text, def);
        System.out.println(parse);//2020-11-22T07:12:58


    }

    @Test
    public void test06() {
        Integer integer = new Integer("789");
        Boolean aTrue = new Boolean("TruE");
        Character e = new Character('e');

        Boolean aBoolean = new Boolean("233432rweres");
        System.out.println(aBoolean);

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.TYPE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Double.TYPE);
        System.out.println(Double.MAX_VALUE);

    }

    @Test
    public void test07(){
        Integer integer = Integer.valueOf("123213");
        System.out.println(integer);

        Double aDouble = Double.valueOf("231.231244");
        System.out.println(aDouble);
        String string = Integer.toBinaryString(-2147483648);
        String string1 = Integer.toBinaryString(0);
        String string2 = Integer.toBinaryString(1);
        String string3 = Integer.toBinaryString(2147483647);
        System.out.println(string);
        System.out.println(string1);
        System.out.println(string2);
        System.out.println(string3);


        String ste = Integer.toOctalString(1024);
        System.out.println(ste);

        String str = Integer.toHexString(1024);
        System.out.println(str);


        Integer integer1 = new Integer(127);
        Integer integer2 = new Integer(127);
        System.out.println(integer1 == integer2);//false

        Integer integer4 = 127;
        Integer integer3 = 127;
        System.out.println(integer4 == integer3);
    }
}



