package com.bjpowernode.demo01.dao;

import com.bjpowernode.demo01.domain.Dept;

import java.util.List;

/**
 * @author feng
 * @date 2021/1/23
 * @Description
 */
public interface DeptDao {

    /**
     * 在部门表中添加数据
     *
     * @param dept
     */
    int insert(Dept dept);

    /**
     * 根据部门编号删除一条数据
     *
     * @param deptno
     */
    int deleteById(Integer deptno) ;

    /**
     * 针对内存中的cust对象，去修改数据表中指定的记录
     *
     * @param dept
     */
    int update(Dept dept) ;

    /**
     * 针对指定的id查询得到对应的Customer对象
     *
     * @param id
     * @return
     */
    Dept getDeptById(Integer id) ;

    /**
     * 查询表中的所记录构成的集合
     *
     * @return
     */
    List<Dept> getAll();

    /**
     * 返回数据表中的数据的条目数
     *
     * @return
     */
    Long getCount();

}
