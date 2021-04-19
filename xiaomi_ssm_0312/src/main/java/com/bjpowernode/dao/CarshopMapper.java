package com.bjpowernode.dao;

import com.bjpowernode.domain.Carshop;
import com.bjpowernode.domain.CarshopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

  
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
public interface CarshopMapper {
    long countByExample(CarshopExample example);

    int deleteByExample(CarshopExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Carshop record);

    int insertSelective(Carshop record);

    List<Carshop> selectByExample(CarshopExample example);

    Carshop selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Carshop record, @Param("example") CarshopExample example);

    int updateByExample(@Param("record") Carshop record, @Param("example") CarshopExample example);

    int updateByPrimaryKeySelective(Carshop record);

    int updateByPrimaryKey(Carshop record);
}