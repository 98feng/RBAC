package com.bjpowernode.service;

import java.util.List;
import com.bjpowernode.domain.ProductInfoExample;
import com.bjpowernode.domain.ProductInfo;
      
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
public interface ProductInfoService{


    long countByExample(ProductInfoExample example);

    int deleteByExample(ProductInfoExample example);

    int deleteByPrimaryKey(Integer pId);

    int insert(ProductInfo record);

    int insertSelective(ProductInfo record);

    List<ProductInfo> selectByExample(ProductInfoExample example);

    ProductInfo selectByPrimaryKey(Integer pId);

    int updateByExampleSelective(ProductInfo record,ProductInfoExample example);

    int updateByExample(ProductInfo record,ProductInfoExample example);

    int updateByPrimaryKeySelective(ProductInfo record);

    int updateByPrimaryKey(ProductInfo record);

}
