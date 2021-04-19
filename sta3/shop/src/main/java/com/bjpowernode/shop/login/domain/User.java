package com.bjpowernode.shop.login.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author feng
 * @date 2020/12/31
 * @Description
 */

@Data
@NoArgsConstructor
@AllArgsConstructor//为了方便测试
public class User implements Serializable {

    private static final long serialVersionUID = -1975869684915396203L;

    private String loginAct;
    private String loginPwd;

}
