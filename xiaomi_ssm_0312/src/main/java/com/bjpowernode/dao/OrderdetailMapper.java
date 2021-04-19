package com.bjpowernode.dao;

import com.bjpowernode.domain.Orderdetail;
import com.bjpowernode.domain.OrderdetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

  
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
public interface OrderdetailMapper {
    long countByExample(OrderdetailExample example);

    int deleteByExample(OrderdetailExample example);

    int deleteByPrimaryKey(Integer odid);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    List<Orderdetail> selectByExample(OrderdetailExample example);

    Orderdetail selectByPrimaryKey(Integer odid);

    int updateByExampleSelective(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    int updateByExample(@Param("record") Orderdetail record, @Param("example") OrderdetailExample example);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);
}