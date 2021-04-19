package com.bjpowernode.service;

import java.util.List;
import com.bjpowernode.domain.OrderdetailExample;
import com.bjpowernode.domain.Orderdetail;
      
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
public interface OrderdetailService{


    long countByExample(OrderdetailExample example);

    int deleteByExample(OrderdetailExample example);

    int deleteByPrimaryKey(Integer odid);

    int insert(Orderdetail record);

    int insertSelective(Orderdetail record);

    List<Orderdetail> selectByExample(OrderdetailExample example);

    Orderdetail selectByPrimaryKey(Integer odid);

    int updateByExampleSelective(Orderdetail record,OrderdetailExample example);

    int updateByExample(Orderdetail record,OrderdetailExample example);

    int updateByPrimaryKeySelective(Orderdetail record);

    int updateByPrimaryKey(Orderdetail record);

}
