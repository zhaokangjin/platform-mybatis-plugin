package ${packageName};

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
import com.platform.configure.result.ConditonToExample;
import com.platform.configure.result.CustomException;
import com.platform.configure.result.ResultStatus;

import ${basePackageName}.condition.${upperDomainName}Condition;
import ${basePackageName}.dao.${dataAlias}.${upperDomainName}Mapper;
import ${basePackageName}.entity.${upperDomainName};
import ${basePackageName}.entity.${upperDomainName}Example;

/**
 * 逻辑处理层
 * @author 
 */
@Service
@Transactional
public class ${className}{
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	${upperDomainName}Mapper ${lowerDomainName}Mapper;
	
	<#list methodFeatureList as methodItem>
	
	${methodItem.txMethodHeader}
    public ${methodItem.returnType}<${methodItem.returnTypeGen}> ${methodItem.methodName}(${methodItem.serviceParams}) throws CustomException{
        if(logger.isInfoEnabled()) {
        	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	}
    	try{
    		${methodItem.newExample}
    		${methodItem.conditionValueToExample};
    		${methodItem.returnTypeGen} result=${lowerDomainName}Mapper.${methodItem.methodName}(${methodItem.daoParams});
    		logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:"+JSON.toJSONString(result));
    		return new ResultStatus<${methodItem.returnTypeGen}>(result,Status.SUCCESS);
    	}catch(Exception e){
    		${methodItem.txMethodException}
    		throw new CustomException("Aplication.exception","Develop need to process",Status.EXCEPTION,MsgLevel.ERROR,e);
    	}
    	
    }
    </#list>
}