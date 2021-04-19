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
public class Carshop implements Serializable {
    private Integer cid;

    private Integer uid;

    private Integer pid;

    private Integer numbers;

    private static final long serialVersionUID = 1L;
}