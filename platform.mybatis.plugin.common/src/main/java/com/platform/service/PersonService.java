package com.platform.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.alibaba.fastjson.JSON;
import com.platform.configure.base.BaseService;
import com.platform.configure.base.ConditionToExample;
import com.platform.configure.base.Status;
import com.platform.configure.base.StatusResult;

import com.platform.condition.PersonCondition;
import com.platform.dao.master.PersonMapper;
import com.platform.entity.Person;
import com.platform.entity.PersonExample;
import com.platform.entity.PersonExample.Criteria;

/**
 * 逻辑处理层
 * @author 
 */
@Service
@Transactional
public class PersonService  implements BaseService<Person, PersonCondition>{
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	personMapper personMapper;
	

    public String selecttiv(com.platform.framemaker.method.signature.MethodParams@43a0cee9){
        logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	try{
    		String result=personMapper.selecttiv(com.platform.framemaker.method.signature.MethodParams@43a0cee9);
    		return reulst;
    	}catch(Exception e){
    		logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">IOExceptionFos:" + e);
    		//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		//exceptionTransactionSetting;
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    	}
    	
    }
}