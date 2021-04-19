package com.bjpowernode.crm.workbench.mapper;

import com.bjpowernode.crm.workbench.domain.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbggenerated Sat May 23 15:59:14 CST 2020
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbggenerated Sat May 23 15:59:14 CST 2020
     */
    int insert(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbggenerated Sat May 23 15:59:14 CST 2020
     */
    int insertSelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbggenerated Sat May 23 15:59:14 CST 2020
     */
    Activity selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbggenerated Sat May 23 15:59:14 CST 2020
     */
    int updateByPrimaryKeySelective(Activity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_activity
     *
     * @mbggenerated Sat May 23 15:59:14 CST 2020
     */
    int updateByPrimaryKey(Activity record);

    /**
    * 保存创建的市场活动
    */
     int insertActivity(Activity activity);
    /**
    * 根据条件分页查询市场活动
    */
    List<Activity> selectActivityForPageByCondition(Map<String,Object> map);

    /**
    * 根据条件查询市场活动总条数
    */

    long selectCountOfActivityByCondition(Map<String,Object> map);
    /**
    * 根据id查询市场活动
    */
    Activity selectActivityById(String id);

    /**
    * 保存修改的市场活动
    */
    int updateActivity(Activity activity);

    /**
    * 根据ids批量删除市场活动
    */
    int deleteActivityByIds(String[] ids);

    /**
    * 查询所有的市场活动
    */
    List<Activity> selectAllActivityForDetail();
    /**
    * 根据ids查询市场活动
    */
    List<Activity> selectActivityForDetailByIds(String[] ids);

    /**
    * 批量保存创建的市场活动
    */
    int insertActivityByList(List<Activity> activityList);

    /**
    * 根据id查询市场活动的明细信息
    */
    Activity selectActivityForDetailById(String id);

    //根据clueId去查询该线索相关联的市场活动明细
    List<Activity> selectActivityForDetailByClueId(String clueId);

    //检索不属于clueId的市场活动
    List<Activity> searchActivityNotBoundById(Map<String,Object> map);

    //根据name模糊查询市场活动
    List<Activity> selectActivityForDetailByName(String name);


}