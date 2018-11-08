package com.platform.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.fastjson.JSON;
import com.platform.configure.base.enums.MsgLevel;
import com.platform.configure.base.enums.Status;
import com.platform.configure.base.BaseService;
import com.platform.configure.base.ConditionToExample;
import com.platform.configure.result.CustomException;
import com.platform.configure.result.ResultStatus;

import com.platform.condition.FieldMappingCondition;
import com.platform.dao.master.FieldMappingMapper;
import com.platform.entity.FieldMappingExample;
import com.platform.entity.FieldMappingExample.Criteria;
import com.platform.field.mapping.entity.FieldMapping;

/**
 * 逻辑处理层
 * @author 
 */
@Service
@Transactional
//  implements BaseService<FieldMapping, FieldMappingCondition>
public class FieldMappingService{
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	FieldMappingMapper fieldMappingMapper;
	

    public ResultStatus<Integer> insert(FieldMapping fieldMapping) throws CustomException{
        logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	try{
    		Integer result=fieldMappingMapper.insert(fieldMapping);
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Integer>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }

    public ResultStatus<Integer> updateByExampleSelective(FieldMapping fieldMapping,FieldMappingExample fieldMappingExample) throws CustomException{
        logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	try{
    		Integer result=fieldMappingMapper.updateByExampleSelective(fieldMapping,fieldMappingExample);
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Integer>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }

    public ResultStatus<Integer> batchUpdateByPrimaryKeySelective(List list,FieldMappingExample fieldMappingExample) throws CustomException{
        logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	try{
    		Integer result=fieldMappingMapper.batchUpdateByPrimaryKeySelective(list,fieldMappingExample);
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Integer>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }

    public ResultStatus<List> selectFieldByList(String string,List list,Integer integer,FieldMappingExample fieldMappingExample) throws CustomException{
        logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	try{
    		List result=fieldMappingMapper.selectFieldByList(string,list,integer,fieldMappingExample);
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<List>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }

    public ResultStatus<Integer> bathcDeleteUpdateOrInsertByExample(List list,FieldMappingExample fieldMappingExample) throws CustomException{
        logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	try{
    		Integer result=fieldMappingMapper.bathcDeleteUpdateOrInsertByExample(list,fieldMappingExample);
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Integer>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }

    public ResultStatus<Integer> insertSelective(FieldMapping fieldMapping) throws CustomException{
        logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	try{
    		Integer result=fieldMappingMapper.insertSelective(fieldMapping);
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Integer>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }

    public ResultStatus<Integer> deleteByExample(FieldMappingExample fieldMappingExample) throws CustomException{
        logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	try{
    		Integer result=fieldMappingMapper.deleteByExample(fieldMappingExample);
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Integer>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }

    public ResultStatus<Long> countByExample(FieldMappingExample fieldMappingExample) throws CustomException{
        logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	try{
    		Long result=fieldMappingMapper.countByExample(fieldMappingExample);
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Long>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }

    public ResultStatus<List> selectByExample(FieldMappingExample fieldMappingExample) throws CustomException{
        logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	try{
    		List result=fieldMappingMapper.selectByExample(fieldMappingExample);
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<List>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }

    public ResultStatus<Integer> updateByExample(FieldMapping fieldMapping,FieldMappingExample fieldMappingExample) throws CustomException{
        logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	try{
    		Integer result=fieldMappingMapper.updateByExample(fieldMapping,fieldMappingExample);
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Integer>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }
}