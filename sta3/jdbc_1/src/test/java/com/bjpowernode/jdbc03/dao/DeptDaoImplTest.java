package com.bjpowernode.jdbc03.dao;

import com.bjpowernode.jdbc03.domain.Dept;
import com.bjpowernode.jdbc03.utils.DataSourceFactory;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author feng
 * @date 2021/1/22
 * @Description
 */
public class DeptDaoImplTest {

    DeptDaoImpl dd = new DeptDaoImpl();

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


    }

    @Test
    public void getDeptById() {

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