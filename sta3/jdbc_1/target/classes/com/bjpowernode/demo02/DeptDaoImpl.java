package com.bjpowernode.demo02;

import com.bjpowernode.demo02.domain.Dept;
import com.bjpowernode.demo02.utils.JDBCUtils;
import com.bjpowernode.demo02.utils.ReflectUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * @author feng
 * @date 2021/1/23
 * @Description
 */
public class DeptDaoImpl implements DeptDao {
    Dept dept = new Dept();
    private JDBCUtils operate = new JDBCUtils();
    @Override
    public int insert( Dept dept) throws Exception {
        String sql = ReflectUtil.createInsertSql(dept);
        return operate.executeUpate(sql);
    }

    @Override
    public int deleteById(Integer deptno) throws Exception {
        String sql = ReflectUtil.delectByIdSql(dept,deptno);
        return operate.executeUpate(sql);
    }

    @Override
    public int update(Dept dept) throws Exception {
        String sql = ReflectUtil.updateSql(dept);
        return operate.executeUpate(sql);
    }

    @Override
    public Dept getDeptById(Integer deptno) throws Exception {
        String sql = ReflectUtil.getDeptByIdSql(dept,deptno);
        return operate.executeQuery(Dept.class,sql);
    }

    @Override
    public List<Dept> getAll() throws Exception {
        String sql = ReflectUtil.getAllSql(dept);
        return operate.executeQueryAll(Dept.class,sql);
    }

    @Override
    public Long getCount() throws SQLException {
        String sql = ReflectUtil.getValue(dept);
        return (Long) operate.executeQueryCount(sql);
    }
}
