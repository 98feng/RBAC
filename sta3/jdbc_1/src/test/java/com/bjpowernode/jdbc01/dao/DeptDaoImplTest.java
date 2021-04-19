package com.bjpowernode.jdbc01.dao;

import com.bjpowernode.jdbc01.domain.Dept;
import com.bjpowernode.jdbc02.utils.DataSourceFactory;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;


/**
 * @author feng
 * @date 2021/1/23
 * @Description
 */
public class DeptDaoImplTest {

    DeptDao dd = new DeptDaoImpl();
    @Test
    public void insert() {
        Connection conn = null;
        try {
            conn = DataSourceFactory.getConnection();
            Dept dept = new Dept();
            dept.setDeptno(78);
            dept.setDname("Java");
            dept.setLoc("上海");
            int insert = dd.insert(conn, dept);
            System.out.println(insert > 0 ? "添加成功！" : "添加失败！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceFactory.closeResource(conn);
        }
    }

    @Test
    public void deleteById() {
        Connection conn = null;
        try {
            conn = DataSourceFactory.getConnection();
            int count = dd.deleteById(conn, 78);
            System.out.println(count > 0 ? "删除成功！" : "删除失败！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceFactory.closeResource(conn);
        }
    }

    @Test
    public void update() {
        Connection conn = null;
        try {
            conn = DataSourceFactory.getConnection();
            Dept dept = new Dept();
            dept.setDeptno(10);
            dept.setDname("Jdbc");
            dept.setLoc("北京");
            int count = dd.update(conn, dept);
            System.out.println(count > 0 ? "更新成功！" : "更新失败！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceFactory.closeResource(conn);
        }

    }

    @Test
    public void getDeptById() {
        Connection conn = null;
        try {
            conn = DataSourceFactory.getConnection();
            int count = dd.deleteById(conn, 73);
            System.out.println(count > 0 ? "删除成功！" : "删除失败！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceFactory.closeResource(conn);
        }
    }

    @Test
    public void getAll() {
        Connection conn = null;
        try {
            conn = DataSourceFactory.getConnection();
            List<Dept> all = dd.getAll(conn);
            for (Dept dept : all) {
                System.out.println(dept);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceFactory.closeResource(conn);
        }
    }

    @Test
    public void getCount() {

        Connection conn = null;
        try {
            conn = DataSourceFactory.getConnection();
            Long count = dd.getCount(conn);
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DataSourceFactory.closeResource(conn);
        }

    }
}