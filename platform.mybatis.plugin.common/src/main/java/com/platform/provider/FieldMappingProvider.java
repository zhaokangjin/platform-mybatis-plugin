package com.platform.provider;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.platform.configure.result.CustomException;
import com.platform.configure.result.ResultStatus;

import com.platform.condition.FieldMappingCondition;
import com.platform.entity.FieldMapping;

/**
 *  
 */
@FeignClient(fallback=NullPointerException.class,path="/field/mapping")
public interface FieldMappingProvider {
	
    public ResultStatus<Integer> insert(FieldMapping fieldMapping) throws CustomException;
	
    public ResultStatus<Integer> bathcDeleteUpdateOrInsertByExample(List list, FieldMappingCondition fieldMappingCondition) throws CustomException;
	
    public ResultStatus<Integer> deleteByExample(FieldMappingCondition fieldMappingCondition) throws CustomException;
	
    public ResultStatus<Integer> updateByExample(FieldMapping fieldMapping, FieldMappingCondition fieldMappingCondition) throws CustomException;
	
    public ResultStatus<Long> countByExample(FieldMappingCondition fieldMappingCondition) throws CustomException;
	
    public ResultStatus<List<FieldMapping>> selectByExample(FieldMappingCondition fieldMappingCondition) throws CustomException;
	
    public ResultStatus<Integer> insertSelective(FieldMapping fieldMapping) throws CustomException;
	
    public ResultStatus<List<FieldMapping>> selectFieldByList(String string, List list, Integer integer, FieldMappingCondition fieldMappingCondition) throws CustomException;
	
    public ResultStatus<Integer> batchUpdateByPrimaryKeySelective(List list, FieldMappingCondition fieldMappingCondition) throws CustomException;
	
    public ResultStatus<Integer> updateByExampleSelective(FieldMapping fieldMapping, FieldMappingCondition fieldMappingCondition) throws CustomException;
}