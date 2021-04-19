package com.bjpowernode.demo01.dao;

import com.bjpowernode.demo01.domain.Dept;
import com.bjpowernode.demo01.utils.BaseDao;
import com.bjpowernode.demo01.utils.Bean;

import java.util.List;

/**
 * @author feng
 * @date 2021/1/23
 * @Description
 */
@Bean
public class DeptDaoImpl extends BaseDao<Dept> implements DeptDao {
    public DeptDaoImpl() {
    }

    @Override
    public int insert(Dept dept) {
        String sql = "insert into dept values(?,?,?)";
        return update(sql,dept.getDeptno(),dept.getDname(),dept.getLoc());
    }

    @Override
    public int deleteById(Integer deptno) {
        String sql = "delete from dept where deptno = ?";
        return update(sql,deptno);
    }

    @Override
    public int update(Dept dept) {
        String sql = "update dept set dname = ?,loc = ? where deptno = ?";
        return update(sql,dept.getDeptno(),dept.getDname(),dept.getLoc());
    }

    @Override
    public Dept getDeptById(Integer deptno) {
        String sql = "select deptno,dname,loc from dept where dname = ?";
        return getInstance(sql,deptno);
    }

    @Override
    public List<Dept> getAll() {
        String sql = "select deptno,dname,loc from dept";
        return getForList(sql);
    }

    @Override
    public Long getCount() {
        String sql = "select count(*) from dept";
        return getValue(sql);
    }
}
