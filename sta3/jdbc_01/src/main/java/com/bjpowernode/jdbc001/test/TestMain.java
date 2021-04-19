package com.bjpowernode.jdbc001.test;

import com.bjpowernode.jdbc001.entity.Dept;
import com.bjpowernode.jdbc001.util.ReflectUtil;

/**
 * 动力节点
 * 2021/1/23
 */
public class TestMain {

    public static void main(String[] args)throws Exception {

        Dept dept = new Dept(30,"Sales","BOSTON");
        ReflectUtil util = new ReflectUtil();
        String sql = util.createInsertSql(dept);
        System.out.println("sql = "+sql);
    }
}
