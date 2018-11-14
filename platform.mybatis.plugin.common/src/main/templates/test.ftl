package ${packageName};

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platform.condition.FieldMappingCondition;
import com.platform.configure.base.enums.DeletedType;
import com.platform.configure.condition.Between;
import com.platform.configure.condition.Conditions;
import com.platform.configure.result.CustomException;

import ${basePackageName}.entity.${upperDomainName};
import ${basePackageName}.provider.${upperDomainName}Provider;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ${appFileName})
public class ${className} {
	
	private Logger logger = LoggerFactory.getLogger(${className}.class);
	
	@Autowired
	${upperDomainName}Provider ${lowerDomainName}Provider;
	
	<#list methodFeatureList as methodItem>
	@Test
    public void ${methodItem.methodName}(){
		${upperDomainName}Condition ${lowerDomainName}Condition=new ${upperDomainName}Condition();
		
		try {
			<#list methodItem.conditionFeature as condition>
			//${condition.fieldName}数据范围设置
			Conditions<${condition.fieldType}> ${condition.fieldName}Condition=new Conditions<${condition.fieldType}>();
			
			${lowerDomainName}Condition.set${condition.condition}(${condition.fieldName}Condition);
			</#list>
			<#list methodItem.testParamType as param>
			${param} ${paramName}=new ${param}();
			</#list>
			
			${lowerDomainName}Provider.${methodItem.methodName}(${methodItem.daoParams});
			
		} catch (CustomException e) {
			logger.error(e.getErrorMsg());
		}
    }
    </#list>

}