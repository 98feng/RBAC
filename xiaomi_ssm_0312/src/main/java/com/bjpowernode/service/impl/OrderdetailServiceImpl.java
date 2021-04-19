package com.bjpowernode.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.bjpowernode.dao.OrderdetailMapper;
import com.bjpowernode.domain.OrderdetailExample;
import com.bjpowernode.domain.Orderdetail;
import com.bjpowernode.service.OrderdetailService;
  
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
@Service
public class OrderdetailServiceImpl implements OrderdetailService{

    @Resource
    private OrderdetailMapper orderdetailMapper;

    @Override
    public long countByExample(OrderdetailExample example) {
        return orderdetailMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(OrderdetailExample example) {
        return orderdetailMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer odid) {
        return orderdetailMapper.deleteByPrimaryKey(odid);
    }

    @Override
    public int insert(Orderdetail record) {
        return orderdetailMapper.insert(record);
    }

    @Override
    public int insertSelective(Orderdetail record) {
        return orderdetailMapper.insertSelective(record);
    }

    @Override
    public List<Orderdetail> selectByExample(OrderdetailExample example) {
        return orderdetailMapper.selectByExample(example);
    }

    @Override
    public Orderdetail selectByPrimaryKey(Integer odid) {
        return orderdetailMapper.selectByPrimaryKey(odid);
    }

    @Override
    public int updateByExampleSelective(Orderdetail record,OrderdetailExample example) {
        return orderdetailMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Orderdetail record,OrderdetailExample example) {
        return orderdetailMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Orderdetail record) {
        return orderdetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Orderdetail record) {
        return orderdetailMapper.updateByPrimaryKey(record);
    }

}
