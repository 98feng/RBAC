package com.bjpowernode.jdbc001.client;

import com.bjpowernode.jdbc001.dao.DeptDao;
import com.bjpowernode.jdbc001.entity.Dept;

import java.util.Scanner;

/**
 * 动力节点
 * 2021/1/21
 */
public class XXX城市税务管理系统 {

    public static void main(String[] args) {
        int flag =0;
        String deptNo,dname,loc;
        Scanner sc = new Scanner(System.in);
        DeptDao dao = new DeptDao();
        Dept dept = null;
        System.out.println("1.公司注册服务");
        System.out.println("2.公司更新服务");
        System.out.println("3.公司注销服务");
        System.out.println("4.公司查询服务");
        System.out.println("请选择服务");
        flag = sc.nextInt();

        if(flag ==1){
            System.out.println("输入新公司编号");
            deptNo = sc.next();
            System.out.println("输入新公司名称");
            dname = sc.next();
            System.out.println("输入新公司地址");
            loc = sc.next();
            try {
                dept = new Dept(Integer.valueOf(deptNo), dname, loc);
                flag = dao.insert(dept);
            }catch(Exception ex){
                System.out.println("系统繁忙，请稍后再试......");
                return;
            }
            if(flag  == 1){
                System.out.println("新公司注册成功");
            }else{
                System.out.println("新公司注册失败");
            }

        }else if(flag ==2){

            System.out.println("输入需要更新公司编号");
            deptNo = sc.next();
            System.out.println("输入新公司名称");
            dname = sc.next();
            System.out.println("输入新公司地址");
            loc = sc.next();
            try {
                dept = new Dept(Integer.valueOf(deptNo), dname, loc);
                flag = dao.update(dept);
            }catch(Exception ex){
                System.out.println("系统繁忙，请稍后再试......");
                return;
            }
            if(flag  == 1){
                System.out.println("新公司更新成功");
            }else{
                System.out.println("新公司更新失败");
            }

        }else if(flag ==3){

            System.out.println("输入需要删除部门编号");
            deptNo = sc.next();
            try {
                flag = dao.delete(deptNo);
            }catch(Exception ex){
                System.out.println("系统繁忙，请稍后再试......");
                return;
            }
            if(flag  == 1){
                System.out.println("公司注销成功");
            }else{
                System.out.println("公司注销失败");
            }

        }else{

        }

    }
}
