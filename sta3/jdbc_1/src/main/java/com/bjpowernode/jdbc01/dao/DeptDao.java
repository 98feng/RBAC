package com.bjpowernode.jdbc01.dao;

import com.bjpowernode.jdbc01.domain.Dept;

import java.sql.Connection;
import java.util.List;

/**
 * @author feng
 * @date 2021/1/21
 * @Description
 */
public interface DeptDao {

    /**
     *  在部门表中添加数据
     * @param conn
     * @param dept
     */
    int insert(Connection conn, Dept dept) throws Exception;

    /**
     * 根据部门编号删除一条数据
     * @param conn
     * @param deptno
     */
    int deleteById(Connection conn, Integer deptno) throws Exception;

    /**
     * 针对内存中的cust对象，去修改数据表中指定的记录
     * @param conn
     * @param dept
     */
    int update(Connection conn, Dept dept) throws Exception;

    /**
     * 针对指定的id查询得到对应的Customer对象
     * @param conn
     * @param id
     * @return
     */
    Dept getDeptById(Connection conn, int id);

    /**
     * 查询表中的所记录构成的集合
     * @param conn
     * @return
     */
    List<Dept> getAll(Connection conn);

    /**
     * 返回数据表中的数据的条目数
     * @param conn
     * @return
     */
    Long getCount(Connection conn);
}
