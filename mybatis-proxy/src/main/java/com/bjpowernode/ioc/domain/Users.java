package com.bjpowernode.ioc.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

  
 /** 
  *  @author feng
  *  @date 2021/3/4
  *  @Description ${Description}
  *  
  */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {
    private String id;

    /**
    * 用户名称
    */
    private String username;

    /**
    * 生日
    */
    private String birthday;

    /**
    * 性别
    */
    private String sex;

    /**
    * 地址
    */
    private String address;

    private static final long serialVersionUID = 1L;
}