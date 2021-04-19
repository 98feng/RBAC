package com.bjpowernode.dao;

import com.bjpowernode.domain.Accounts;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

  
 /** 
  *  @author feng
  *  @date 2021/3/8
  *  @Description ${Description}
  *  
  */
@Mapper
public interface AccountsMapper {
    /**
     * delete by primary key
     * @param aid primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer aid);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Accounts record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Accounts record);

    /**
     * select by primary key
     * @param aid primary key
     * @return object by primary key
     */
    Accounts selectByPrimaryKey(Integer aid);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Accounts record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Accounts record);

    int updateBatch(List<Accounts> list);

    int batchInsert(@Param("list") List<Accounts> list);
}