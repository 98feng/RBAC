package com.bjpowernode.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

  
 /** 
  *  @author feng
  *  @date 2021/3/8
  *  @Description ${Description}
  *  
  */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users implements Serializable {
    private Integer userid;

    private String uname;

    private String upass;

    private static final long serialVersionUID = 1L;
}