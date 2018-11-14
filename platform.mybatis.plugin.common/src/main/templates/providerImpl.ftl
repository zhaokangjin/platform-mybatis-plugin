package ${packageName};

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.platform.configure.base.enums.MsgLevel;
import com.platform.configure.base.enums.Status;
import com.platform.configure.result.CustomException;
import com.platform.configure.result.ResultStatus;

import ${basePackageName}.condition.${upperDomainName}Condition;
import ${basePackageName}.provider.${upperDomainName}Provider;
import ${basePackageName}.service.${upperDomainName}Service;
import ${basePackageName}.entity.${upperDomainName};

@RestController
public class ${className}  implements ${upperDomainName}Provider{
	private Logger logger =LoggerFactory.getLogger(this.getClass());

	@Autowired
	${upperDomainName}Service ${lowerDomainName}Service;

	<#list methodFeatureList as methodItem>
	@Override
    public ${methodItem.returnType}<${methodItem.returnTypeGen}> ${methodItem.methodName}(${methodItem.serviceParams}) throws CustomException{
    	logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">JSONParam:");
		ResultStatus<${methodItem.returnTypeGen}> result = null;
		try {
			result = ${lowerDomainName}Service.${methodItem.methodName}(${methodItem.daoParams});
			return result;
		} catch (CustomException e) {
			throw new CustomException("Aplication.exception", "Develop need to process", Status.EXCEPTION, MsgLevel.ERROR, e);
		}
    }
    </#list>
}