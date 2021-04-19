package com.bjpowernode.ioc.domain;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

  
 /** 
  *  @author feng
  *  @date 2021/3/5
  *  @Description ${Description}
  *  
  */
@Data
@NoArgsConstructor
public class Orders implements Serializable {
    private Integer id;

    private String ordernumber;

    private Double orderprice;

    private Integer customerId;

    private static final long serialVersionUID = 1L;
}