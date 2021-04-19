package com.bjpowernode.service;

import java.util.List;
import com.bjpowernode.domain.Carshop;
import com.bjpowernode.domain.CarshopExample;
      
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
public interface CarshopService{


    long countByExample(CarshopExample example);

    int deleteByExample(CarshopExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Carshop record);

    int insertSelective(Carshop record);

    List<Carshop> selectByExample(CarshopExample example);

    Carshop selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(Carshop record,CarshopExample example);

    int updateByExample(Carshop record,CarshopExample example);

    int updateByPrimaryKeySelective(Carshop record);

    int updateByPrimaryKey(Carshop record);

}
