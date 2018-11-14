package com.platform.provider.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.platform.configure.base.enums.MsgLevel;
import com.platform.configure.base.enums.Status;
import com.platform.configure.result.CustomException;
import com.platform.configure.result.ResultStatus;

import com.platform.condition.FieldMappingCondition;
import com.platform.provider.FieldMappingProvider;
import com.platform.service.FieldMappingService;
import com.platform.entity.FieldMapping;

@RestController
public class FieldMappingProviderImpl  implements FieldMappingProvider{
	private Logger logger =LoggerFactory.getLogger(this.getClass());

	@Autowired
	FieldMappingService fieldMappingService;

	@Override
    public ResultStatus<Integer> insert(FieldMapping fieldMapping) throws CustomException{
    	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
		ResultStatus<Integer> result = null;
		try {
			result = fieldMappingService.insert(fieldMapping);
			return result;
		} catch (CustomException e) {
			throw new CustomException("Aplication.exception", "Develop need to process", Status.EXCEPTION, MsgLevel.ERROR, e);
		}
    }
	@Override
    public ResultStatus<Integer> bathcDeleteUpdateOrInsertByExample(List list, FieldMappingCondition fieldMappingCondition) throws CustomException{
    	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
		ResultStatus<Integer> result = null;
		try {
			result = fieldMappingService.bathcDeleteUpdateOrInsertByExample(list,fieldMappingCondition);
			return result;
		} catch (CustomException e) {
			throw new CustomException("Aplication.exception", "Develop need to process", Status.EXCEPTION, MsgLevel.ERROR, e);
		}
    }
	@Override
    public ResultStatus<Integer> deleteByExample(FieldMappingCondition fieldMappingCondition) throws CustomException{
    	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
		ResultStatus<Integer> result = null;
		try {
			result = fieldMappingService.deleteByExample(fieldMappingCondition);
			return result;
		} catch (CustomException e) {
			throw new CustomException("Aplication.exception", "Develop need to process", Status.EXCEPTION, MsgLevel.ERROR, e);
		}
    }
	@Override
    public ResultStatus<Integer> updateByExample(FieldMapping fieldMapping, FieldMappingCondition fieldMappingCondition) throws CustomException{
    	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
		ResultStatus<Integer> result = null;
		try {
			result = fieldMappingService.updateByExample(fieldMapping,fieldMappingCondition);
			return result;
		} catch (CustomException e) {
			throw new CustomException("Aplication.exception", "Develop need to process", Status.EXCEPTION, MsgLevel.ERROR, e);
		}
    }
	@Override
    public ResultStatus<Long> countByExample(FieldMappingCondition fieldMappingCondition) throws CustomException{
    	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
		ResultStatus<Long> result = null;
		try {
			result = fieldMappingService.countByExample(fieldMappingCondition);
			return result;
		} catch (CustomException e) {
			throw new CustomException("Aplication.exception", "Develop need to process", Status.EXCEPTION, MsgLevel.ERROR, e);
		}
    }
	@Override
    public ResultStatus<List<FieldMapping>> selectByExample(FieldMappingCondition fieldMappingCondition) throws CustomException{
    	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
		ResultStatus<List<FieldMapping>> result = null;
		try {
			result = fieldMappingService.selectByExample(fieldMappingCondition);
			return result;
		} catch (CustomException e) {
			throw new CustomException("Aplication.exception", "Develop need to process", Status.EXCEPTION, MsgLevel.ERROR, e);
		}
    }
	@Override
    public ResultStatus<Integer> insertSelective(FieldMapping fieldMapping) throws CustomException{
    	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
		ResultStatus<Integer> result = null;
		try {
			result = fieldMappingService.insertSelective(fieldMapping);
			return result;
		} catch (CustomException e) {
			throw new CustomException("Aplication.exception", "Develop need to process", Status.EXCEPTION, MsgLevel.ERROR, e);
		}
    }
	@Override
    public ResultStatus<List<FieldMapping>> selectFieldByList(String string, List list, Integer integer, FieldMappingCondition fieldMappingCondition) throws CustomException{
    	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
		ResultStatus<List<FieldMapping>> result = null;
		try {
			result = fieldMappingService.selectFieldByList(string,list,integer,fieldMappingCondition);
			return result;
		} catch (CustomException e) {
			throw new CustomException("Aplication.exception", "Develop need to process", Status.EXCEPTION, MsgLevel.ERROR, e);
		}
    }
	@Override
    public ResultStatus<Integer> batchUpdateByPrimaryKeySelective(List list, FieldMappingCondition fieldMappingCondition) throws CustomException{
    	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
		ResultStatus<Integer> result = null;
		try {
			result = fieldMappingService.batchUpdateByPrimaryKeySelective(list,fieldMappingCondition);
			return result;
		} catch (CustomException e) {
			throw new CustomException("Aplication.exception", "Develop need to process", Status.EXCEPTION, MsgLevel.ERROR, e);
		}
    }
	@Override
    public ResultStatus<Integer> updateByExampleSelective(FieldMapping fieldMapping, FieldMappingCondition fieldMappingCondition) throws CustomException{
    	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
		ResultStatus<Integer> result = null;
		try {
			result = fieldMappingService.updateByExampleSelective(fieldMapping,fieldMappingCondition);
			return result;
		} catch (CustomException e) {
			throw new CustomException("Aplication.exception", "Develop need to process", Status.EXCEPTION, MsgLevel.ERROR, e);
		}
    }
}