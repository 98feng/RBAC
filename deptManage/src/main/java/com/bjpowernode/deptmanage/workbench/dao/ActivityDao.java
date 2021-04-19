package com.bjpowernode.deptmanage.workbench.dao;


import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @date 2020/10/12 - 20:02
 * @Description
 */
public interface ActivityDao<E> {

    int creatActivity(E activity);

    List<E> getActivityListByCondition(Map<String, Object> map);

    int getTotalByCondition(Map<String, Object> map);

    int delete(String[] ids);

    E getById(String id);

    int update(E a);

    E detail(String id);

    List<E> getActivityListByName(String aname);
}

