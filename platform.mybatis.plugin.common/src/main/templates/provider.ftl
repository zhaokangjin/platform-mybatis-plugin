package ${packageName};

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.platform.configure.result.CustomException;
import com.platform.configure.result.ResultStatus;

import ${basePackageName}.condition.${upperDomainName}Condition;
import ${basePackageName}.entity.${upperDomainName};

/**
 *  
 */
@FeignClient(fallback=NullPointerException.class,path="/field/mapping")
public interface ${className} {
	<#list methodFeatureList as methodItem>
	
    public ${methodItem.returnType}<${methodItem.returnTypeGen}> ${methodItem.methodName}(${methodItem.serviceParams}) throws CustomException;
    </#list>
}