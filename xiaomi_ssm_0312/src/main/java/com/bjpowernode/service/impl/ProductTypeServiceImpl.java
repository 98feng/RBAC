package com.bjpowernode.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.bjpowernode.domain.ProductTypeExample;
import com.bjpowernode.domain.ProductType;
import com.bjpowernode.dao.ProductTypeMapper;
import com.bjpowernode.service.ProductTypeService;
  
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
@Service
public class ProductTypeServiceImpl implements ProductTypeService{

    @Resource
    private ProductTypeMapper productTypeMapper;

    @Override
    public long countByExample(ProductTypeExample example) {
        return productTypeMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(ProductTypeExample example) {
        return productTypeMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer typeId) {
        return productTypeMapper.deleteByPrimaryKey(typeId);
    }

    @Override
    public int insert(ProductType record) {
        return productTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(ProductType record) {
        return productTypeMapper.insertSelective(record);
    }

    @Override
    public List<ProductType> selectByExample(ProductTypeExample example) {
        return productTypeMapper.selectByExample(example);
    }

    @Override
    public ProductType selectByPrimaryKey(Integer typeId) {
        return productTypeMapper.selectByPrimaryKey(typeId);
    }

    @Override
    public int updateByExampleSelective(ProductType record,ProductTypeExample example) {
        return productTypeMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(ProductType record,ProductTypeExample example) {
        return productTypeMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductType record) {
        return productTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ProductType record) {
        return productTypeMapper.updateByPrimaryKey(record);
    }

}
