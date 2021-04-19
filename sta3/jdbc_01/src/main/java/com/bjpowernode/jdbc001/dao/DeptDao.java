package com.bjpowernode.jdbc001.dao;

import com.bjpowernode.jdbc001.entity.Dept;
import com.bjpowernode.jdbc001.util.JdbcUtil;
import com.bjpowernode.jdbc001.util.ReflectUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 动力节点
 * 2021/1/21
 */
public class DeptDao {

    private JdbcUtil util = new JdbcUtil();

   //封装：对部门表进行数据行添加操作

   public int insert(Dept dept) throws Exception {
       String sql = null;
       PreparedStatement ps = null;
       ReflectUtil reflectUtil = new ReflectUtil();
       JdbcUtil jdbcUtil = new JdbcUtil();
       int result = 0;


       try {
           sql = reflectUtil.createInsertSql(dept);
           result = util.executeUpate(sql);
       } finally {
           util.close();
       }
       return result;
   }

   //封装:对部门表进行数据行删除操作
    public int delete(String deptNo)throws Exception{
       String sql ="delete from dept where deptno=?";
       int result = 0;

       PreparedStatement ps = null;

        try {
            ps = util.createStatement(sql);
            ps.setString(1, deptNo);
            result =ps.executeUpdate();
        } finally {
            util.close();
        }

        return result;
    }

   //封装:对部门表进行数据行更新操作
    public int update(Dept dept)throws Exception{
       String sql ="update dept set dname=?,loc=? where deptno=?";
       int result = 0;
       PreparedStatement ps = null;
        try {
            ps = util.createStatement(sql);
            ps.setString(1, dept.getDname());
            ps.setString(2, dept.getLoc());
            ps.setInt(3, dept.getDeptNo());
            result = ps.executeUpdate();
        } finally {
            util.close();
        }
        return result;
    }

    //封装:对部门表进行数据行查询
    public List findAll()throws Exception{
       String sql="select * from dept";
       PreparedStatement ps = null;
       ResultSet table = null;
       List list = new ArrayList();
        try {
            ps = util.createStatement(sql);
            table = ps.executeQuery();
            while(table.next()){
                 Integer deptNo = table.getInt("deptNo");
                 String  dname  = table.getString("dname");
                 String  loc    = table.getString("loc");
                 Dept dept = new Dept(deptNo,dname,loc);
                 list.add(dept);
            }
        } finally {
             util.close(table);
        }
        return list;
    }
}
