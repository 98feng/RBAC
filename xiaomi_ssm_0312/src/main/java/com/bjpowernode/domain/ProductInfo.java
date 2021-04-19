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
public class ProductInfo implements Serializable {
    private Integer pId;

    private String pName;

    private String pContent;

    private Integer pPrice;

    private String pImage;

    private Integer pNumber;

    private Integer typeId;

    private Date pDate;

    private static final long serialVersionUID = 1L;
}