package com.bjpowernode.dao;

import com.bjpowernode.ioc.domain.Orders;
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
public interface OrdersMapper {
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
    int insert(Orders record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Orders record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Orders selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Orders record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Orders record);

    int updateBatch(List<Orders> list);

    int batchInsert(@Param("list") List<Orders> list);
}