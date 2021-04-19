package com.thread.hw.syn;

/**
 * @author feng
 * @date 2021/1/5
 * @Description
 */
public class DirtyRead {


    public static void main(String[] args) {
        User zhangsan = new User("zhangsan", "123");
        new Thread(new Runnable() {
            @Override
            public void run() {
                zhangsan.setLoginAct("wangwu").setLoginPwd("345");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                zhangsan.read();
            }
        }).start();

    }
}

class User {
    private String loginAct;
    private String loginPwd;

    public  User setLoginAct(String loginAct) {

        this.loginAct = loginAct;
        return this;
    }

    public  User setLoginPwd(String loginPwd) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.loginPwd = loginPwd;
        return this;
    }

    public User(String loginAct, String loginPwd) {
        this.loginAct = loginAct;
        this.loginPwd = loginPwd;
    }


    public  void read() {
        System.out.println("姓名：" + loginAct + "密码：" + loginPwd);
    }
}