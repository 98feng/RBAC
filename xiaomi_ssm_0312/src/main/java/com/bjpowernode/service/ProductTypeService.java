package com.bjpowernode.service;

import java.util.List;
import com.bjpowernode.domain.ProductTypeExample;
import com.bjpowernode.domain.ProductType;
      
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
public interface ProductTypeService{


    long countByExample(ProductTypeExample example);

    int deleteByExample(ProductTypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(ProductType record);

    int insertSelective(ProductType record);

    List<ProductType> selectByExample(ProductTypeExample example);

    ProductType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(ProductType record,ProductTypeExample example);

    int updateByExample(ProductType record,ProductTypeExample example);

    int updateByPrimaryKeySelective(ProductType record);

    int updateByPrimaryKey(ProductType record);

}
