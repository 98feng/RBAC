package com.bjpowernode.jdbc02.dao;

import com.bjpowernode.jdbc02.domain.Dept;

import java.sql.Connection;
import java.util.List;

/**
 * @author feng
 * @date 2021/1/21
 * @Description
 */
public class DeptDaoImpl extends BaseDao<Dept> implements DeptDao {

    @Override
    public int insert(Connection conn, Dept dept) {
        String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
        return update(conn, sql, dept.getDeptno(), dept.getDname(), dept.getLoc());
    }

    @Override
    public int deleteById(Connection conn, Integer deptno) {
        String sql = "delete from dept where deptno = ?";
        return update(conn, sql, deptno);
    }


    @Override
    public int update(Connection conn, Dept dept) {
        String sql = "update dept set dname = ? ,loc = ? where deptno = ?";
        return update(conn, sql, dept.getDname(), dept.getLoc(),dept.getDeptno());
    }

    @Override
    public Dept getDeptById(Connection conn, int id) {
        String sql = "select deptno,dname,loc from dept where deptno = ?";
        Dept dept = getInstance(conn, sql, id);
        return dept;
    }

    @Override
    public List<Dept> getAll(Connection conn) {
        String sql = "select deptno,dname,loc from dept";
        List<Dept> list = getForList(conn, sql);
        return list;
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from dept";
        return (Long) getValue(conn, sql);
    }
}
