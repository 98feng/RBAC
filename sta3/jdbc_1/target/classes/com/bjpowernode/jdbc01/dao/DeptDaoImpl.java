package com.bjpowernode.jdbc01.dao;

import com.bjpowernode.jdbc01.domain.Dept;
import com.bjpowernode.jdbc01.utils.JDBCUtils;
import com.bjpowernode.jdbc01.utils.ReflectUtil;

import java.sql.Connection;
import java.util.List;

/**
 * @author feng
 * @date 2021/1/21
 * @Description
 */
public class DeptDaoImpl extends BaseDao<Dept> implements DeptDao {

    @Override
    public int insert(Connection conn, Dept dept) throws Exception {
        String sql = ReflectUtil.createInsertSql(dept);
        return JDBCUtils.executeUpate(sql);
    }

    @Override
    public int deleteById(Connection conn, Integer deptno) {
        String sql = "delect from dept where deptno = ?";
        return update(conn,sql,deptno);
    }

    @Override
    public int update(Connection conn, Dept dept) throws Exception {
        String sql = ReflectUtil.updateSql(dept);
        return JDBCUtils.executeUpate(sql);
    }

    @Override
    public Dept getDeptById(Connection conn, int id) {
        String sql = "select deptno,dname,loc from dept where deptno = ?";
        return getInstance(conn, sql, id);
    }

    @Override
    public List<Dept> getAll(Connection conn) {
        String sql = "select deptno,dname,loc from dept";
        return getForList(conn, sql);
    }

    @Override
    public Long getCount(Connection conn) {
        String sql = "select count(*) from dept";
        return (Long) getValue(conn, sql);
    }
}
