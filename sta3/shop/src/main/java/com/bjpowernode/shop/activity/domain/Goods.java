package com.bjpowernode.shop.activity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author feng
 * @date 2020/12/31
 * @Description
 */
@Data
@AllArgsConstructor//为了方便测试
public class Goods implements Serializable {

    private static final long serialVersionUID = -9101061318722721235L;

    private String goodsNo;
    private String goodsName;
    private String goodsPrice;
    private String goodsSales;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(" " + goodsNo).append("\t\t").append(goodsName).append("\t\t\t").append(goodsPrice)
                .append("\t\t").append(goodsSales).append("\n");
        return sb.toString();
    }
}
