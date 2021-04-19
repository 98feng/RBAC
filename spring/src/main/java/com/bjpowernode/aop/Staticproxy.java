package com.bjpowernode.aop;

/**
 * @author feng
 * @date 2021/3/6
 * @Description
 */
public class Staticproxy implements Action{

    Aop aop;
    Action action;

    public Staticproxy(Aop aop, Action actions) {
        this.aop = aop;
        this.action = actions;
    }

    @Override
    public void buy() {
        try {
            aop.before();
            action.buy();
            aop.after();
        } catch (Exception e) {
            aop.exception();
        }
    }
}
