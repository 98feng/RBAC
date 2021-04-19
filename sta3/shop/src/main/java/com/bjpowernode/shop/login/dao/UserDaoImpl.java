package com.bjpowernode.shop.login.dao;

import com.bjpowernode.shop.login.domain.User;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @author feng
 * @date 2020/12/27
 * @Description
 */
public class UserDaoImpl implements UserDao {

    /**
     * 如果user不存在，则将账号密码写入本地，返回null
     * 如果user存在则返回user
     *
     * @param map
     * @return
     */
    @Override
    public User register(Map<String, String> map) throws Throwable {
        ObjectOutputStream oos = null;
        User userReg = new User(map.get("loginAct"), map.get("loginPwd"));
        List<User> allUserList = getAllUserList();
        boolean flag = true;
        for (User user : allUserList) {
            //如果有该user，返回user
            if (userReg.equals(user)) {
                flag = false;
                return user;
            }
        }
        /*将新注册的user添加，取出原来的user重新序列化*/
        if (flag) {
            try {
                allUserList.add(userReg);
                oos = new ObjectOutputStream(new FileOutputStream(new File("user.txt")));
                oos.writeObject(allUserList);
                oos.flush();
            } catch (IOException e) {
                throw e.getCause();
            } finally {
                try {
                    assert oos != null;
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


    /**
     * @param map
     * @return user
     * @deprecated 如果user存在返回，不存在返回null
     */
    @Override
    public User login(Map<String, String> map) throws Throwable {
        List<User> allUserList = getAllUserList();
        assert allUserList != null;
        for (User user : allUserList) {
            if (map.get("loginAct").equals(user.getLoginAct()) && map.get("loginPwd").equals(user.getLoginPwd())) {
                return user;
            }
        }
        return null;
    }

    /**
     * 获取所有用户信息
     */
    private List<User> getAllUserList() throws Throwable {
        ObjectInputStream ois = null;
        Object obj = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("user.txt")));
            obj = ois.readObject();
        } catch (Exception e) {
//            e.printStackTrace();
            throw e.getCause();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (List) obj;
    }
}