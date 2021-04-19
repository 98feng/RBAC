package com.bjpowernode.ioc.domain;

import java.io.Serializable;
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
public class Book implements Serializable {
    private Integer id;

    /**
    * 用户名称
    */
    private String name;

    private static final long serialVersionUID = 1L;
}