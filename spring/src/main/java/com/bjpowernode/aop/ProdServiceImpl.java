package com.bjpowernode.aop;

/**
 * @author feng
 * @date 2021/3/6
 * @Description
 */
public class ProdServiceImpl implements Action {
    @Override
    public void buy() {
        System.out.println("买商品的主业务执行");
    }
}
