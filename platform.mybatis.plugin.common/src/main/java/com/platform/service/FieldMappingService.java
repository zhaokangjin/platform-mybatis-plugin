package com.platform.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.fastjson.JSON;
import com.platform.configure.base.enums.MsgLevel;
import com.platform.configure.base.enums.Status;
import com.platform.configure.base.BaseService;
import com.platform.configure.result.ConditonToExample;
import com.platform.configure.result.CustomException;
import com.platform.configure.result.ResultStatus;

import com.platform.condition.FieldMappingCondition;
import com.platform.dao.master.FieldMappingMapper;
import com.platform.entity.FieldMapping;
import com.platform.entity.FieldMappingExample;
import com.platform.entity.FieldMappingExample.Criteria;

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
	
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public ResultStatus<Integer> insert(FieldMapping fieldMapping) throws CustomException{
        if(logger.isInfoEnabled()) {
        	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	}
    	try{
    		
    		//没有传递条件参数启用 ,无需转换 条件;
    		Integer result=fieldMappingMapper.insert(fieldMapping);
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Integer>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public ResultStatus<Integer> bathcDeleteUpdateOrInsertByExample(List list,FieldMappingCondition fieldMappingCondition) throws CustomException{
        if(logger.isInfoEnabled()) {
        	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	}
    	try{
    		FieldMappingExample fieldMappingExample=new FieldMappingExample();
    		ConditonToExample<FieldMappingCondition,FieldMappingExample> conditonToExample =new ConditonToExample<FieldMappingCondition,FieldMappingExample>(fieldMappingCondition, fieldMappingExample);
    		Integer result=fieldMappingMapper.bathcDeleteUpdateOrInsertByExample(list,conditonToExample.getExamlpe());
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Integer>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public ResultStatus<Integer> updateByExampleSelective(FieldMapping fieldMapping,FieldMappingCondition fieldMappingCondition) throws CustomException{
        if(logger.isInfoEnabled()) {
        	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	}
    	try{
    		FieldMappingExample fieldMappingExample=new FieldMappingExample();
    		ConditonToExample<FieldMappingCondition,FieldMappingExample> conditonToExample =new ConditonToExample<FieldMappingCondition,FieldMappingExample>(fieldMappingCondition, fieldMappingExample);
    		Integer result=fieldMappingMapper.updateByExampleSelective(fieldMapping,conditonToExample.getExamlpe());
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Integer>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public ResultStatus<Integer> batchUpdateByPrimaryKeySelective(List list,FieldMappingCondition fieldMappingCondition) throws CustomException{
        if(logger.isInfoEnabled()) {
        	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	}
    	try{
    		FieldMappingExample fieldMappingExample=new FieldMappingExample();
    		ConditonToExample<FieldMappingCondition,FieldMappingExample> conditonToExample =new ConditonToExample<FieldMappingCondition,FieldMappingExample>(fieldMappingCondition, fieldMappingExample);
    		Integer result=fieldMappingMapper.batchUpdateByPrimaryKeySelective(list,conditonToExample.getExamlpe());
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Integer>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }
	
	//无事务
    public ResultStatus<List<FieldMapping>> selectFieldByList(String string,List list,Integer integer,FieldMappingCondition fieldMappingCondition) throws CustomException{
        if(logger.isInfoEnabled()) {
        	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	}
    	try{
    		FieldMappingExample fieldMappingExample=new FieldMappingExample();
    		ConditonToExample<FieldMappingCondition,FieldMappingExample> conditonToExample =new ConditonToExample<FieldMappingCondition,FieldMappingExample>(fieldMappingCondition, fieldMappingExample);
    		List<FieldMapping> result=fieldMappingMapper.selectFieldByList(string,list,integer,conditonToExample.getExamlpe());
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<List<FieldMapping>>(result,Status.SUCCESS);
    	}catch(Exception e){
    		//查询无需异常事务回滚
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }
	
	//无事务
    public ResultStatus<Long> countByExample(FieldMappingCondition fieldMappingCondition) throws CustomException{
        if(logger.isInfoEnabled()) {
        	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	}
    	try{
    		FieldMappingExample fieldMappingExample=new FieldMappingExample();
    		ConditonToExample<FieldMappingCondition,FieldMappingExample> conditonToExample =new ConditonToExample<FieldMappingCondition,FieldMappingExample>(fieldMappingCondition, fieldMappingExample);
    		Long result=fieldMappingMapper.countByExample(conditonToExample.getExamlpe());
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Long>(result,Status.SUCCESS);
    	}catch(Exception e){
    		//查询无需异常事务回滚
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public ResultStatus<Integer> deleteByExample(FieldMappingCondition fieldMappingCondition) throws CustomException{
        if(logger.isInfoEnabled()) {
        	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	}
    	try{
    		FieldMappingExample fieldMappingExample=new FieldMappingExample();
    		ConditonToExample<FieldMappingCondition,FieldMappingExample> conditonToExample =new ConditonToExample<FieldMappingCondition,FieldMappingExample>(fieldMappingCondition, fieldMappingExample);
    		Integer result=fieldMappingMapper.deleteByExample(conditonToExample.getExamlpe());
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Integer>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public ResultStatus<Integer> insertSelective(FieldMapping fieldMapping) throws CustomException{
        if(logger.isInfoEnabled()) {
        	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	}
    	try{
    		
    		//没有传递条件参数启用 ,无需转换 条件;
    		Integer result=fieldMappingMapper.insertSelective(fieldMapping);
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Integer>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }
	
	//无事务
    public ResultStatus<List<FieldMapping>> selectByExample(FieldMappingCondition fieldMappingCondition) throws CustomException{
        if(logger.isInfoEnabled()) {
        	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	}
    	try{
    		FieldMappingExample fieldMappingExample=new FieldMappingExample();
    		ConditonToExample<FieldMappingCondition,FieldMappingExample> conditonToExample =new ConditonToExample<FieldMappingCondition,FieldMappingExample>(fieldMappingCondition, fieldMappingExample);
    		List<FieldMapping> result=fieldMappingMapper.selectByExample(conditonToExample.getExamlpe());
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<List<FieldMapping>>(result,Status.SUCCESS);
    	}catch(Exception e){
    		//查询无需异常事务回滚
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
    public ResultStatus<Integer> updateByExample(FieldMapping fieldMapping,FieldMappingCondition fieldMappingCondition) throws CustomException{
        if(logger.isInfoEnabled()) {
        	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	}
    	try{
    		FieldMappingExample fieldMappingExample=new FieldMappingExample();
    		ConditonToExample<FieldMappingCondition,FieldMappingExample> conditonToExample =new ConditonToExample<FieldMappingCondition,FieldMappingExample>(fieldMappingCondition, fieldMappingExample);
    		Integer result=fieldMappingMapper.updateByExample(fieldMapping,conditonToExample.getExamlpe());
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<Integer>(result,Status.SUCCESS);
    	}catch(Exception e){
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }
}