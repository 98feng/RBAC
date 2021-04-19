package com.bjpowernode.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bjpowernode.domain.Address;
import java.util.List;
import com.bjpowernode.dao.AddressMapper;
import com.bjpowernode.domain.AddressExample;
import com.bjpowernode.service.AddressService;
  
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
@Service
public class AddressServiceImpl implements AddressService{

    @Resource
    private AddressMapper addressMapper;

    @Override
    public long countByExample(AddressExample example) {
        return addressMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(AddressExample example) {
        return addressMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer addressid) {
        return addressMapper.deleteByPrimaryKey(addressid);
    }

    @Override
    public int insert(Address record) {
        return addressMapper.insert(record);
    }

    @Override
    public int insertSelective(Address record) {
        return addressMapper.insertSelective(record);
    }

    @Override
    public List<Address> selectByExample(AddressExample example) {
        return addressMapper.selectByExample(example);
    }

    @Override
    public Address selectByPrimaryKey(Integer addressid) {
        return addressMapper.selectByPrimaryKey(addressid);
    }

    @Override
    public int updateByExampleSelective(Address record,AddressExample example) {
        return addressMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Address record,AddressExample example) {
        return addressMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Address record) {
        return addressMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Address record) {
        return addressMapper.updateByPrimaryKey(record);
    }

}
