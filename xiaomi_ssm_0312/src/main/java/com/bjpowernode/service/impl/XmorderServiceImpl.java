package com.bjpowernode.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.bjpowernode.domain.XmorderExample;
import java.util.List;
import com.bjpowernode.domain.Xmorder;
import com.bjpowernode.dao.XmorderMapper;
import com.bjpowernode.service.XmorderService;
  
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
@Service
public class XmorderServiceImpl implements XmorderService{

    @Resource
    private XmorderMapper xmorderMapper;

    @Override
    public long countByExample(XmorderExample example) {
        return xmorderMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(XmorderExample example) {
        return xmorderMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String oid) {
        return xmorderMapper.deleteByPrimaryKey(oid);
    }

    @Override
    public int insert(Xmorder record) {
        return xmorderMapper.insert(record);
    }

    @Override
    public int insertSelective(Xmorder record) {
        return xmorderMapper.insertSelective(record);
    }

    @Override
    public List<Xmorder> selectByExample(XmorderExample example) {
        return xmorderMapper.selectByExample(example);
    }

    @Override
    public Xmorder selectByPrimaryKey(String oid) {
        return xmorderMapper.selectByPrimaryKey(oid);
    }

    @Override
    public int updateByExampleSelective(Xmorder record,XmorderExample example) {
        return xmorderMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(Xmorder record,XmorderExample example) {
        return xmorderMapper.updateByExample(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(Xmorder record) {
        return xmorderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Xmorder record) {
        return xmorderMapper.updateByPrimaryKey(record);
    }

}
