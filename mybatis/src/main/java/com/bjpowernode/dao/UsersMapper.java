package com.bjpowernode.dao;

import com.bjpowernode.ioc.domain.Users;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

  
 /** 
  *  @author feng
  *  @date 2021/3/2
  *  @Description ${Description}
  *  
  */
@Mapper
public interface UsersMapper {
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
    int insert(Users record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Users record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Users selectByPrimaryKey(Integer id);

    List<Users> selectByAll();

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Users record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Users record);

    int updateBatch(List<Users> list);

    int batchInsert(@Param("list") List<Users> list);

    List<Users> getByColmnName(@Param("cName") String columnName, @Param("cValue") String columnValue);

    int insert(Integer id);
}