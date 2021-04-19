package com.bjpowernode.dao;

import com.bjpowernode.ioc.domain.Book;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

  
 /** 
  *  @author feng
  *  @date 2021/3/4
  *  @Description ${Description}
  *  
  */
@Mapper
public interface BookMapper {
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
    int insert(Book record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(Book record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    Book selectByPrimaryKey(Integer id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(Book record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(Book record);

    int updateBatch(List<Book> list);

    int batchInsert(@Param("list") List<Book> list);
}