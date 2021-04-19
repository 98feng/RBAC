package com.bjpowernode.library.activity.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author feng
 * @date 2021/1/2
 * @Description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Books implements Serializable {

    private static final long serialVersionUID = 8684647285449736526L;
    private String id;
    private String name;
    private String author;
    private String price;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("图书信息：");
        sb.append("图书编号 = ").append(id);
        sb.append(", 图书名称 = ").append(name);
        sb.append(", author = ").append(author);
        sb.append(", price = ").append(price).append("\n");
        return sb.toString();
    }
}
