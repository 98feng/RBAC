package com.bjpowernode.service;

import com.bjpowernode.domain.XmorderExample;
import java.util.List;
import com.bjpowernode.domain.Xmorder;
      
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
public interface XmorderService{


    long countByExample(XmorderExample example);

    int deleteByExample(XmorderExample example);

    int deleteByPrimaryKey(String oid);

    int insert(Xmorder record);

    int insertSelective(Xmorder record);

    List<Xmorder> selectByExample(XmorderExample example);

    Xmorder selectByPrimaryKey(String oid);

    int updateByExampleSelective(Xmorder record,XmorderExample example);

    int updateByExample(Xmorder record,XmorderExample example);

    int updateByPrimaryKeySelective(Xmorder record);

    int updateByPrimaryKey(Xmorder record);

}
