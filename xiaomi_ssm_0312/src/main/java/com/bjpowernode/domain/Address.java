package com.bjpowernode.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

  
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
@Data
@NoArgsConstructor
public class Address implements Serializable {
    private Integer addressid;

    private Integer uid;

    private String cnee;

    private String phone;

    private String address;

    private static final long serialVersionUID = 1L;
}