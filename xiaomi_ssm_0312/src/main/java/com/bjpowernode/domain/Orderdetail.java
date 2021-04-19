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
public class Orderdetail implements Serializable {
    private Integer odid;

    private String oid;

    private Integer pid;

    private Integer pnumber;

    private Double ptotal;

    private static final long serialVersionUID = 1L;
}