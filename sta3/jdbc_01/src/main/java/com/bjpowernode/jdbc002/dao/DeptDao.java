package com.bjpowernode.jdbc002.dao;

import com.bjpowernode.jdbc002.entity.Dept;
import com.bjpowernode.jdbc002.util.JdbcUtil;
import com.bjpowernode.jdbc002.util.ReflectUtil;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * 动力节点
 * 2021/1/21
 */
public class DeptDao {

    private JdbcUtil util = new JdbcUtil();
    private ReflectUtil reflectUtil = new ReflectUtil();

    //封装：对部门表进行数据行添加操作
    public int insert(Dept dept)throws Exception{

        String sql = null;

        int result = 0;

        try {
            sql =reflectUtil.createInsertSql(dept);
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
        String sql = null;
        int result =0;
        try {
            sql=reflectUtil.createUpdateSql(dept, "DEPTNO");
            result =util.executeUpate(sql);
        } finally {
            util.close();
        }
        return result;
    }

    //封装:对部门表进行数据行查询
    public List findAll()throws Exception{
        String sql="select * from dept";
        List list = util.executeQuery(sql, Dept.class);
        return list;
    }
}
