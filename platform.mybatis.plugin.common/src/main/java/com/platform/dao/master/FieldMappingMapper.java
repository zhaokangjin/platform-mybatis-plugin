package com.platform.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.platform.entity.FieldMapping;
import com.platform.entity.FieldMappingExample;

public interface FieldMappingMapper {
    long countByExample(FieldMappingExample example);

    int deleteByExample(FieldMappingExample example);

    int insert(FieldMapping fieldMapping);

    int insertSelective(FieldMapping record);

    List<FieldMapping> selectByExample(FieldMappingExample example);

    int updateByExampleSelective(@Param("record") FieldMapping record, @Param("example") FieldMappingExample example);

    int updateByExample(@Param("record") FieldMapping record, @Param("example") FieldMappingExample example);

    int batchUpdateByPrimaryKeySelective(@Param("list") List<FieldMapping> list, @Param("example") FieldMappingExample example);

    List<FieldMapping> selectFieldByList(@Param("fieldName") String fieldName, @Param("paramList") List<Object> paramList, @Param("splitSize") Integer splitSize, @Param("example") FieldMappingExample example);
     
    int bathcDeleteUpdateOrInsertByExample(@Param("list") List<FieldMapping> list,@Param("example") com.platform.entity.FieldMappingExample fieldMappingExample);
}