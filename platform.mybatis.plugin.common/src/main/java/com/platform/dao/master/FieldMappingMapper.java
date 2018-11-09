package com.platform.dao.master;

import com.platform.field.mapping.entity.FieldMapping;
import com.platform.field.mapping.entity.FieldMappingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FieldMappingMapper {
    long countByExample(FieldMappingExample example);

    int deleteByExample(FieldMappingExample example);

    int insert(com.platform.entity.FieldMapping fieldMapping);

    int insertSelective(FieldMapping record);

    List<FieldMapping> selectByExample(FieldMappingExample example);

    int updateByExampleSelective(@Param("record") FieldMapping record, @Param("example") FieldMappingExample example);

    int updateByExample(@Param("record") FieldMapping record, @Param("example") FieldMappingExample example);

    int batchUpdateByPrimaryKeySelective(@Param("list") List<FieldMapping> list, @Param("example") FieldMappingExample example);

    List<FieldMapping> selectFieldByList(@Param("fieldName") String fieldName, @Param("paramList") List<Object> paramList, @Param("splitSize") Integer splitSize, @Param("example") FieldMappingExample example);
    
    int bathcDeleteUpdateOrInsertByExample(List<FieldMapping> record,@Param("example") FieldMappingExample example);
}