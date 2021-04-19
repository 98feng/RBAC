package com.bjpowernode.deptmanage.workbench.service;

import com.bjpowernode.deptmanage.vo.PaginationVO;
import com.bjpowernode.deptmanage.workbench.domain.DeptActivity;
import com.bjpowernode.deptmanage.workbench.domain.DeptActivityRemark;

import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @date 2020/10/12 - 20:06
 * @Description
 */
public interface ActivityService<E> {


    boolean creatActivity(E activity);

    PaginationVO<E> pageList(Map<String, Object> map);

    boolean delete(String[] ids);

    Map<String, Object> getUserListAndActivity(String id);

    boolean update(E a);

    E detail(String id);

    List<E> getRemarkListByAid(String activityId);

    boolean deleteRemark(String id);

    boolean saveRemark(E ar);

    boolean updateRemark(E ar);

    List<E> getActivityListByName(String aname);
}
