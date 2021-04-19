package com.bjpowernode.demo03;

import com.bjpowernode.demo03.service.Animal;

/**
 * @author feng
 * @date 2020/12/13
 * @Description
 */
public abstract class AnimalImpl implements Animal {

    public AnimalImpl() {
    }

    @Override
    public abstract void shout();


    public abstract String toString();
}

