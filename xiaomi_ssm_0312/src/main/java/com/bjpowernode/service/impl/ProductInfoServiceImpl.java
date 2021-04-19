package com.bjpowernode.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bjpowernode.dao.ProductInfoMapper;
import java.util.List;
import com.bjpowernode.domain.ProductInfoExample;
import com.bjpowernode.domain.ProductInfo;
import com.bjpowernode.service.ProductInfoService;
  
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
@Service
public class ProductInfoServiceImpl implements ProductInfoService{

    @Resource
    private ProductInfoMapper productInfoMapper;

    @Override
    public long countByExample(ProductInfoExample example) {
        return productInfoMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ProductInfoExample example) {
        return productInfoMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer pId) {
        return productInfoMapper.deleteByPrimaryKey(pId);
    }

    @Override
    public int insert(ProductInfo record) {
        return productInfoMapper.insert(record);
    }

    @Override
    public int insertSelective(ProductInfo record) {
        return productInfoMapper.insertSelective(record);
    }

    @Override
    public List<ProductInfo> selectByExample(ProductInfoExample example) {
        return productInfoMapper.selectByExample(example);
    }

    @Override
    public ProductInfo selectByPrimaryKey(Integer pId) {
        return productInfoMapper.selectByPrimaryKey(pId);
    }

    @Override
    public int updateByExampleSelective(ProductInfo record,ProductInfoExample example) {
        return productInfoMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(ProductInfo record,ProductInfoExample example) {
        return productInfoMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductInfo record) {
        return productInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductInfo record) {
        return productInfoMapper.updateByPrimaryKey(record);
    }

}
