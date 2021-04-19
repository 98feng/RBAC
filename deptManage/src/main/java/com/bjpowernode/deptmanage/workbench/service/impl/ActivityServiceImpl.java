package com.bjpowernode.deptmanage.workbench.service.impl;

import com.bjpowernode.deptmanage.settings.dao.UserDao;
import com.bjpowernode.deptmanage.settings.domain.User;
import com.bjpowernode.deptmanage.utils.SqlSessionUtil;
import com.bjpowernode.deptmanage.vo.PaginationVO;
import com.bjpowernode.deptmanage.workbench.dao.ActivityDao;
import com.bjpowernode.deptmanage.workbench.dao.ActivityRemarkDao;
import com.bjpowernode.deptmanage.workbench.service.ActivityService;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @date 2021/2/7
 * @Description
 */
@SuppressWarnings("all")
public abstract class ActivityServiceImpl<E, V, K> implements ActivityService<E> {

    public Class<V> clazz1;
    public Class<K> clazz2;

    {
        //获取当前ActivityServiceImpl的子类继承的父类中的泛型
        Type genericSuperclass = this.getClass().getGenericSuperclass();//获取泛型父类
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType paramType = (ParameterizedType) genericSuperclass;
            Type[] typeArguments = paramType.getActualTypeArguments();//获取了父类的泛型参数
            clazz1 = (Class<V>) typeArguments[1];//泛型的第二个参数
            clazz2 = (Class<K>) typeArguments[2];//泛型的第三个参数
        }

    }

    /*List<E> list1;
    List<V> list2;
    {
        ParameterizedType pt1 = null;
        ParameterizedType pt2 = null;
        try {
            pt1 = (ParameterizedType) ActivityServiceImplTest.class.getField(
                    "list1").getGenericType();
            pt2 = (ParameterizedType) ActivityServiceImplTest.class.getField(
                    "list2").getGenericType();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        clazz1 = (Class<E>) pt1.getActualTypeArguments()[0];
        clazz2 = (Class<V>) pt2.getActualTypeArguments()[0];
    }*/
    private SqlSession session = SqlSessionUtil.getSqlSession();

    private ActivityDao activityDao = (ActivityDao)session.getMapper(clazz1);
    private ActivityRemarkDao activityRemarkDao = (ActivityRemarkDao) SqlSessionUtil.getSqlSession().getMapper(clazz2);
    private UserDao userDao = SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

    @Override
    public boolean creatActivity(E activity) {
        boolean flag = true;
        int num = activityDao.creatActivity(activity);
        if (num != 1) {
            flag = false;
        }
        return flag;
    }

    @Override
    public PaginationVO<E> pageList(Map<String, Object> map) {
        System.out.println(session);
        System.out.println(clazz1);
        System.out.println(clazz2);

        //取得total
        int total = activityDao.getTotalByCondition(map);

        //取得dataList
        List<E> dataList = activityDao.getActivityListByCondition(map);

        //创建一个vo对象，将total和dataList封装到vo中
        PaginationVO<E> vo = new PaginationVO<>();
        vo.setTotal(total);
        vo.setDataList(dataList);

        //将vo返回
        return vo;
    }

    @Override
    public boolean delete(String[] ids) {

        boolean flag = true;

        //查询出需要删除的备注的数量
        int count1 = activityRemarkDao.getCountByAids(ids);

        //删除备注，返回受到影响的条数（实际删除的数量）
        int count2 = activityRemarkDao.deleteByAids(ids);

        if (count1 != count2) {

            flag = false;

        }

        //删除市场活动
        int count3 = activityDao.delete(ids);
        if (count3 != ids.length) {

            flag = false;

        }

        return flag;
    }

    @Override
    public Map<String, Object> getUserListAndActivity(String id) {

        //取uList
        List<User> uList = userDao.getUserList();

        //取a
        E a = (E) activityDao.getById(id);

        //将uList和a打包到map中
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uList", uList);
        map.put("a", a);

        //返回map就可以了
        return map;
    }

    @Override
    public boolean update(E a) {
        boolean flag = true;

        int count = activityDao.update(a);
        if (count != 1) {

            flag = false;

        }
        return flag;
    }

    @Override
    public E detail(String id) {

        return (E) activityDao.detail(id);
    }

    @Override
    public List<E> getRemarkListByAid(String activityId) {

        return activityRemarkDao.getRemarkListByAid(activityId);
    }

    @Override
    public boolean deleteRemark(String id) {

        boolean flag = true;

        int count = activityRemarkDao.deleteById(id);

        if (count != 1) {

            flag = false;

        }

        return flag;
    }

    @Override
    public boolean saveRemark(E ar) {

        boolean flag = true;

        int count = activityRemarkDao.saveRemark(ar);

        if (count != 1) {

            flag = false;

        }

        return flag;
    }

    @Override
    public boolean updateRemark(E ar) {

        boolean flag = true;

        int count = activityRemarkDao.updateRemark(ar);

        if (count != 1) {

            flag = false;

        }

        return flag;
    }


    @Override
    public List<E> getActivityListByName(String aname) {

        return activityDao.getActivityListByName(aname);
    }
}
