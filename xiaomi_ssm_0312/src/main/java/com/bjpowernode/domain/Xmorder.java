package com.bjpowernode.domain;

import java.io.Serializable;
import java.util.Date;
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
public class Xmorder implements Serializable {
    private String oid;

    private Integer uid;

    private Integer addressid;

    private Double totalprice;

    private String remarks;

    private String status;

    private Date odate;

    private static final long serialVersionUID = 1L;
}