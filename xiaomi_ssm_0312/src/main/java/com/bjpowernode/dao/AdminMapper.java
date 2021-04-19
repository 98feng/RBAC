package com.bjpowernode.dao;

import com.bjpowernode.domain.Admin;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

  
 /** 
  *  @author feng
  *  @date 2021/3/12
  *  @Description ${Description}
  *  
  */
@Mapper
public interface AdminMapper {
    /**
     * delete by primary key
     * @param aId primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer aId);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(Admin record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Admin record);

    /**
     * select by primary key
     * @param aId primary key
     * @return object by primary key
     */
    Admin selectByPrimaryKey(Integer aId);


    Admin login(@Param("aName") String aName, @Param("aPass") String aPass);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Admin record);

    int updateBatch(List<Admin> list);

    int batchInsert(@Param("list") List<Admin> list);

}