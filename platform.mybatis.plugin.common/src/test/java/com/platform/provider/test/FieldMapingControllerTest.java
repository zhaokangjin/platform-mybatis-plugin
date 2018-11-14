package com.platform.provider.test;

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
import com.platform.entity.FieldMapping;
import com.platform.provider.FieldMappingProvider;

@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = FieldMapingControllerTest.class)
public class FieldMapingControllerTest {
	private Logger logger = LoggerFactory.getLogger(FieldMapingControllerTest.class);
	@Autowired
	FieldMappingProvider fieldMappingProvider;

	@Test
	public void testSelectByE() {
		FieldMappingCondition fieldMappingCondition=new FieldMappingCondition();
		Conditions<Date> creationTimeCondition=new Conditions<Date>();
		Between<Date> between=new Between<Date>();
		between.setEndValue(new Date());
		between.setPreValue(new Date());
		creationTimeCondition.setBw(between);
		fieldMappingCondition.setCreationTime(creationTimeCondition);
		
		Conditions<DeletedType> deleteFlagCondition=new Conditions<DeletedType>();
		deleteFlagCondition.setEq(DeletedType.HARD_DELETE);
		fieldMappingCondition.setDeletedType(deleteFlagCondition);
		List<FieldMapping> list=new ArrayList<FieldMapping>();
		try {
			fieldMappingProvider.batchUpdateByPrimaryKeySelective(list, fieldMappingCondition);
		} catch (CustomException e) {
			logger.error(e.getErrorMsg());
		}
	}
}