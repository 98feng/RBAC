package com.bjpowernode.dao;

import com.bjpowernode.ioc.domain.Customer;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

  
 /** 
  *  @author feng
  *  @date 2021/3/5
  *  @Description ${Description}
  *  
  */
@Mapper
public interface CustomerMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Customer record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Customer record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Customer selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Customer record);

    int updateBatch(List<Customer> list);

    int batchInsert(@Param("list") List<Customer> list);
}