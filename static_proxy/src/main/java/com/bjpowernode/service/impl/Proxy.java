package com.bjpowernode.service.impl;

import com.bjpowernode.service.Action;

/**
 * Hello world!
 */
public class Proxy implements Action {


    Action action;

    public Proxy(Action action) {
        this.action = action;
    }

    @Override
    public void sing() {
        System.out.println("A");
        System.out.println("B");
        action.sing();
        System.out.println("A");
    }
}
