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

import ${packageName}.condition.${domainName}Condition;
import ${packageName}.dao.${dataAlias}.${domainName}Mapper;
import ${packageName}.entity.${domainName};
import ${packageName}.entity.${domainName}Example;
import ${packageName}.entity.${domainName}Example.Criteria;

/**
 * 逻辑处理层
 * @author ${author}
 */
@Service
@Transactional
public class ${className}  implements BaseService<${domainName}, ${domainName}Condition>{
	private Logger logger =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	${domainName}Mapper ${lowerDomainName}Mapper;
	
	<#list attrList as attr>

    public ${returnType} ${methodName}(${params}){
        logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:"+${JSONParamString});
    	try{
    		${lowerDomainName}Mapper.${methodName}(${params});
    		${returnResult};
    	}catch(Exception e){
    		logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">IOExceptionFos:" + e);
    		//TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    		${exceptionTransactionSetting};
    	}
    	
    }
    </#list>
}