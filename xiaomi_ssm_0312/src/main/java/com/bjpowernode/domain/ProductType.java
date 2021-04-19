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
public class ProductType implements Serializable {
    private Integer typeId;

    private String typeName;

    private static final long serialVersionUID = 1L;
}