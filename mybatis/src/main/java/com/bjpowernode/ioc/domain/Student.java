package com.bjpowernode.ioc.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
  *  @author feng
  *  @date 2021/3/1
  *  @Description ${Description}
  *  
  */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private Integer id;

    private String name;

    private String email;

    private Integer age;

    private static final long serialVersionUID = 1L;
}