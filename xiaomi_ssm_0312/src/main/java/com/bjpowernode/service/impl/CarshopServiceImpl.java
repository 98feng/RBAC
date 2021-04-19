package com.bjpowernode.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.bjpowernode.dao.CarshopMapper;
import com.bjpowernode.domain.Carshop;
import com.bjpowernode.domain.CarshopExample;
import com.bjpowernode.service.CarshopService;
  
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
@Service
public class CarshopServiceImpl implements CarshopService{

    @Resource
    private CarshopMapper carshopMapper;

    @Override
    public long countByExample(CarshopExample example) {
        return carshopMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(CarshopExample example) {
        return carshopMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer cid) {
        return carshopMapper.deleteByPrimaryKey(cid);
    }

    @Override
    public int insert(Carshop record) {
        return carshopMapper.insert(record);
    }

    @Override
    public int insertSelective(Carshop record) {
        return carshopMapper.insertSelective(record);
    }

    @Override
    public List<Carshop> selectByExample(CarshopExample example) {
        return carshopMapper.selectByExample(example);
    }

    @Override
    public Carshop selectByPrimaryKey(Integer cid) {
        return carshopMapper.selectByPrimaryKey(cid);
    }

    @Override
    public int updateByExampleSelective(Carshop record,CarshopExample example) {
        return carshopMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Carshop record,CarshopExample example) {
        return carshopMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Carshop record) {
        return carshopMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Carshop record) {
        return carshopMapper.updateByPrimaryKey(record);
    }

}
