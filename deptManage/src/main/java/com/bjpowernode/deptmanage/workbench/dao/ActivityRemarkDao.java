package com.bjpowernode.deptmanage.workbench.dao;

import java.util.List;


public interface ActivityRemarkDao<E> {
    int getCountByAids(String[] ids);

    int deleteByAids(String[] ids);

    List<E> getRemarkListByAid(String activityId);

    int deleteById(String id);

    int saveRemark(E ar);

    int updateRemark(E ar);
}
