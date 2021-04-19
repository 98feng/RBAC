package com.bjpowernode.jdbc03.dao;

import com.bjpowernode.jdbc03.domain.Dept;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author feng
 * @date 2021/1/21
 * @Description
 */
public class DeptDaoImpl extends BaseDao<Dept> implements DeptDao {

    static QueryRunner runner = new QueryRunner();

    @Override
    public int insert(Connection conn, Dept dept) throws SQLException {
        String sql = "insert into dept(deptno,dname,loc) values(?,?,?)";
        return runner.update(conn, sql, dept.getDeptno(), dept.getDname(), dept.getLoc());
    }

    @Override
    public int deleteById(Connection conn, Integer deptno) throws SQLException {
        String sql = "delete from dept where deptno = ?";
        return runner.update(conn, sql, deptno);
    }

    @Override
    public int update(Connection conn, Dept dept) throws SQLException {
        String sql = "update dept set deptno = ?,dname = ? ,loc = ? where deptno = ?";
        return runner.update(conn, sql, dept.getDeptno(), dept.getDname(), dept.getLoc());
    }

    @Override
    public Dept getDeptById(Connection conn, int id) throws SQLException {
        String sql = "select deptno,dname,loc from dept where deptno = ?";
        BeanHandler<Dept> handler = new BeanHandler<>(Dept.class);
        Dept dept = runner.query(conn, sql, handler, id);
        return dept;
    }

    @Override
    public List<Dept> getAll(Connection conn) throws SQLException {
        String sql = "select deptno,dname,loc from dept";
        BeanListHandler<Dept> handler = new BeanListHandler<Dept>(Dept.class);
        List<Dept> list = runner.query(conn, sql,handler);
        return list;
    }

    @Override
    public Long getCount(Connection conn) throws SQLException {
        String sql = "select count(*) from dept";
        ScalarHandler handler = new ScalarHandler();
        return (Long) runner.query(conn, sql,handler);
    }
}
