package ${packageName};

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

import ${basePackageName}.condition.${upperDomainName}Condition;
import ${basePackageName}.dao.${dataAlias}.${upperDomainName}Mapper;
import ${basePackageName}.entity.${upperDomainName};
import ${basePackageName}.entity.${upperDomainName}Example;
import ${basePackageName}.entity.${upperDomainName}Example.Criteria;

/**
 * 逻辑处理层
 * @author 
 */
@Service
@Transactional
public class ${className}  implements BaseService<${upperDomainName}, ${upperDomainName}Condition>{
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	${upperDomainName}Mapper ${lowerDomainName}Mapper;
	
	<#list methodFeatureList as methodItem>

    public ${methodItem.returnType} ${methodItem.methodName}(${methodItem.serviceParams}){
        logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
    	try{
    		${methodItem.returnType} result=${lowerDomainName}Mapper.${methodItem.methodName}(${methodItem.daoParams});
    		return reulst;
    	}catch(Exception e){
    		logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">IOExceptionFos:" + e);
    		//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		//exceptionTransactionSetting;
    		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    	}
    	
    }
    </#list>
}