package com.platform.mybatis.plugin.common.base;

import java.util.List;

public interface BaseMapper <T extends BaseEntity,E>{
//    long countByExample(T example);
//
//    int deleteByExample(E example);
//
//    int insert(T record);
//
//    int insertSelective(T record);
//
//    List<T> selectByExample(E example);
//
//    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);
//
//    int updateByExample(@Param("record") T record, @Param("example") E example);

	int batchInsert(List<T> list);
	
	int batchUpdate(List<T> list);
	
	int batchDelete(List<T> list);

}
