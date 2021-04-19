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
public class Admin implements Serializable {
    private Integer aId;

    private String aName;

    private String aPass;

    private static final long serialVersionUID = 1L;
}