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

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = FieldMappingApp.class)
public class FieldMappingTest {
	
	private Logger logger = LoggerFactory.getLogger(FieldMappingTest.class);
	
	@Autowired
	FieldMappingProvider fieldMappingProvider;
	
	@Test
    public void insert(){
		FieldMappingCondition fieldMappingCondition=new FieldMappingCondition();
		
		try {
			
			fieldMappingProvider.insert(fieldMapping);
			
		} catch (CustomException e) {
			logger.error(e.getErrorMsg());
		}
    }
	@Test
    public void bathcDeleteUpdateOrInsertByExample(){
		FieldMappingCondition fieldMappingCondition=new FieldMappingCondition();
		
		try {
			//fieldid数据范围设置
			Conditions<String> fieldidCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldid(fieldidCondition);
			//fieldCn数据范围设置
			Conditions<String> fieldCnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldCn(fieldCnCondition);
			//fieldEn数据范围设置
			Conditions<String> fieldEnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldEn(fieldEnCondition);
			//eventuallyUpdatePeople数据范围设置
			Conditions<String> eventuallyUpdatePeopleCondition=new Conditions<String>();
			
			fieldMappingCondition.setEventuallyUpdatePeople(eventuallyUpdatePeopleCondition);
			//creator数据范围设置
			Conditions<String> creatorCondition=new Conditions<String>();
			
			fieldMappingCondition.setCreator(creatorCondition);
			//creationTime数据范围设置
			Conditions<Date> creationTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setCreationTime(creationTimeCondition);
			//UpdateTime数据范围设置
			Conditions<Date> UpdateTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setUpdateTime(UpdateTimeCondition);
			//deletedType数据范围设置
			Conditions<DeletedType> deletedTypeCondition=new Conditions<DeletedType>();
			
			fieldMappingCondition.setDeletedType(deletedTypeCondition);
			
			fieldMappingProvider.bathcDeleteUpdateOrInsertByExample(list, fieldMappingCondition);
			
		} catch (CustomException e) {
			logger.error(e.getErrorMsg());
		}
    }
	@Test
    public void updateByExampleSelective(){
		FieldMappingCondition fieldMappingCondition=new FieldMappingCondition();
		
		try {
			//fieldid数据范围设置
			Conditions<String> fieldidCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldid(fieldidCondition);
			//fieldCn数据范围设置
			Conditions<String> fieldCnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldCn(fieldCnCondition);
			//fieldEn数据范围设置
			Conditions<String> fieldEnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldEn(fieldEnCondition);
			//eventuallyUpdatePeople数据范围设置
			Conditions<String> eventuallyUpdatePeopleCondition=new Conditions<String>();
			
			fieldMappingCondition.setEventuallyUpdatePeople(eventuallyUpdatePeopleCondition);
			//creator数据范围设置
			Conditions<String> creatorCondition=new Conditions<String>();
			
			fieldMappingCondition.setCreator(creatorCondition);
			//creationTime数据范围设置
			Conditions<Date> creationTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setCreationTime(creationTimeCondition);
			//UpdateTime数据范围设置
			Conditions<Date> UpdateTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setUpdateTime(UpdateTimeCondition);
			//deletedType数据范围设置
			Conditions<DeletedType> deletedTypeCondition=new Conditions<DeletedType>();
			
			fieldMappingCondition.setDeletedType(deletedTypeCondition);
			
			fieldMappingProvider.updateByExampleSelective(fieldMapping, fieldMappingCondition);
			
		} catch (CustomException e) {
			logger.error(e.getErrorMsg());
		}
    }
	@Test
    public void batchUpdateByPrimaryKeySelective(){
		FieldMappingCondition fieldMappingCondition=new FieldMappingCondition();
		
		try {
			//fieldid数据范围设置
			Conditions<String> fieldidCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldid(fieldidCondition);
			//fieldCn数据范围设置
			Conditions<String> fieldCnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldCn(fieldCnCondition);
			//fieldEn数据范围设置
			Conditions<String> fieldEnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldEn(fieldEnCondition);
			//eventuallyUpdatePeople数据范围设置
			Conditions<String> eventuallyUpdatePeopleCondition=new Conditions<String>();
			
			fieldMappingCondition.setEventuallyUpdatePeople(eventuallyUpdatePeopleCondition);
			//creator数据范围设置
			Conditions<String> creatorCondition=new Conditions<String>();
			
			fieldMappingCondition.setCreator(creatorCondition);
			//creationTime数据范围设置
			Conditions<Date> creationTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setCreationTime(creationTimeCondition);
			//UpdateTime数据范围设置
			Conditions<Date> UpdateTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setUpdateTime(UpdateTimeCondition);
			//deletedType数据范围设置
			Conditions<DeletedType> deletedTypeCondition=new Conditions<DeletedType>();
			
			fieldMappingCondition.setDeletedType(deletedTypeCondition);
			
			fieldMappingProvider.batchUpdateByPrimaryKeySelective(list, fieldMappingCondition);
			
		} catch (CustomException e) {
			logger.error(e.getErrorMsg());
		}
    }
	@Test
    public void selectFieldByList(){
		FieldMappingCondition fieldMappingCondition=new FieldMappingCondition();
		
		try {
			//fieldid数据范围设置
			Conditions<String> fieldidCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldid(fieldidCondition);
			//fieldCn数据范围设置
			Conditions<String> fieldCnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldCn(fieldCnCondition);
			//fieldEn数据范围设置
			Conditions<String> fieldEnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldEn(fieldEnCondition);
			//eventuallyUpdatePeople数据范围设置
			Conditions<String> eventuallyUpdatePeopleCondition=new Conditions<String>();
			
			fieldMappingCondition.setEventuallyUpdatePeople(eventuallyUpdatePeopleCondition);
			//creator数据范围设置
			Conditions<String> creatorCondition=new Conditions<String>();
			
			fieldMappingCondition.setCreator(creatorCondition);
			//creationTime数据范围设置
			Conditions<Date> creationTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setCreationTime(creationTimeCondition);
			//UpdateTime数据范围设置
			Conditions<Date> UpdateTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setUpdateTime(UpdateTimeCondition);
			//deletedType数据范围设置
			Conditions<DeletedType> deletedTypeCondition=new Conditions<DeletedType>();
			
			fieldMappingCondition.setDeletedType(deletedTypeCondition);
			
			fieldMappingProvider.selectFieldByList(string, list, integer, fieldMappingCondition);
			
		} catch (CustomException e) {
			logger.error(e.getErrorMsg());
		}
    }
	@Test
    public void countByExample(){
		FieldMappingCondition fieldMappingCondition=new FieldMappingCondition();
		
		try {
			//fieldid数据范围设置
			Conditions<String> fieldidCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldid(fieldidCondition);
			//fieldCn数据范围设置
			Conditions<String> fieldCnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldCn(fieldCnCondition);
			//fieldEn数据范围设置
			Conditions<String> fieldEnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldEn(fieldEnCondition);
			//eventuallyUpdatePeople数据范围设置
			Conditions<String> eventuallyUpdatePeopleCondition=new Conditions<String>();
			
			fieldMappingCondition.setEventuallyUpdatePeople(eventuallyUpdatePeopleCondition);
			//creator数据范围设置
			Conditions<String> creatorCondition=new Conditions<String>();
			
			fieldMappingCondition.setCreator(creatorCondition);
			//creationTime数据范围设置
			Conditions<Date> creationTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setCreationTime(creationTimeCondition);
			//UpdateTime数据范围设置
			Conditions<Date> UpdateTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setUpdateTime(UpdateTimeCondition);
			//deletedType数据范围设置
			Conditions<DeletedType> deletedTypeCondition=new Conditions<DeletedType>();
			
			fieldMappingCondition.setDeletedType(deletedTypeCondition);
			
			fieldMappingProvider.countByExample(fieldMappingCondition);
			
		} catch (CustomException e) {
			logger.error(e.getErrorMsg());
		}
    }
	@Test
    public void deleteByExample(){
		FieldMappingCondition fieldMappingCondition=new FieldMappingCondition();
		
		try {
			//fieldid数据范围设置
			Conditions<String> fieldidCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldid(fieldidCondition);
			//fieldCn数据范围设置
			Conditions<String> fieldCnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldCn(fieldCnCondition);
			//fieldEn数据范围设置
			Conditions<String> fieldEnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldEn(fieldEnCondition);
			//eventuallyUpdatePeople数据范围设置
			Conditions<String> eventuallyUpdatePeopleCondition=new Conditions<String>();
			
			fieldMappingCondition.setEventuallyUpdatePeople(eventuallyUpdatePeopleCondition);
			//creator数据范围设置
			Conditions<String> creatorCondition=new Conditions<String>();
			
			fieldMappingCondition.setCreator(creatorCondition);
			//creationTime数据范围设置
			Conditions<Date> creationTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setCreationTime(creationTimeCondition);
			//UpdateTime数据范围设置
			Conditions<Date> UpdateTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setUpdateTime(UpdateTimeCondition);
			//deletedType数据范围设置
			Conditions<DeletedType> deletedTypeCondition=new Conditions<DeletedType>();
			
			fieldMappingCondition.setDeletedType(deletedTypeCondition);
			
			fieldMappingProvider.deleteByExample(fieldMappingCondition);
			
		} catch (CustomException e) {
			logger.error(e.getErrorMsg());
		}
    }
	@Test
    public void insertSelective(){
		FieldMappingCondition fieldMappingCondition=new FieldMappingCondition();
		
		try {
			
			fieldMappingProvider.insertSelective(fieldMapping);
			
		} catch (CustomException e) {
			logger.error(e.getErrorMsg());
		}
    }
	@Test
    public void selectByExample(){
		FieldMappingCondition fieldMappingCondition=new FieldMappingCondition();
		
		try {
			//fieldid数据范围设置
			Conditions<String> fieldidCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldid(fieldidCondition);
			//fieldCn数据范围设置
			Conditions<String> fieldCnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldCn(fieldCnCondition);
			//fieldEn数据范围设置
			Conditions<String> fieldEnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldEn(fieldEnCondition);
			//eventuallyUpdatePeople数据范围设置
			Conditions<String> eventuallyUpdatePeopleCondition=new Conditions<String>();
			
			fieldMappingCondition.setEventuallyUpdatePeople(eventuallyUpdatePeopleCondition);
			//creator数据范围设置
			Conditions<String> creatorCondition=new Conditions<String>();
			
			fieldMappingCondition.setCreator(creatorCondition);
			//creationTime数据范围设置
			Conditions<Date> creationTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setCreationTime(creationTimeCondition);
			//UpdateTime数据范围设置
			Conditions<Date> UpdateTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setUpdateTime(UpdateTimeCondition);
			//deletedType数据范围设置
			Conditions<DeletedType> deletedTypeCondition=new Conditions<DeletedType>();
			
			fieldMappingCondition.setDeletedType(deletedTypeCondition);
			
			fieldMappingProvider.selectByExample(fieldMappingCondition);
			
		} catch (CustomException e) {
			logger.error(e.getErrorMsg());
		}
    }
	@Test
    public void updateByExample(){
		FieldMappingCondition fieldMappingCondition=new FieldMappingCondition();
		
		try {
			//fieldid数据范围设置
			Conditions<String> fieldidCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldid(fieldidCondition);
			//fieldCn数据范围设置
			Conditions<String> fieldCnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldCn(fieldCnCondition);
			//fieldEn数据范围设置
			Conditions<String> fieldEnCondition=new Conditions<String>();
			
			fieldMappingCondition.setFieldEn(fieldEnCondition);
			//eventuallyUpdatePeople数据范围设置
			Conditions<String> eventuallyUpdatePeopleCondition=new Conditions<String>();
			
			fieldMappingCondition.setEventuallyUpdatePeople(eventuallyUpdatePeopleCondition);
			//creator数据范围设置
			Conditions<String> creatorCondition=new Conditions<String>();
			
			fieldMappingCondition.setCreator(creatorCondition);
			//creationTime数据范围设置
			Conditions<Date> creationTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setCreationTime(creationTimeCondition);
			//UpdateTime数据范围设置
			Conditions<Date> UpdateTimeCondition=new Conditions<Date>();
			
			fieldMappingCondition.setUpdateTime(UpdateTimeCondition);
			//deletedType数据范围设置
			Conditions<DeletedType> deletedTypeCondition=new Conditions<DeletedType>();
			
			fieldMappingCondition.setDeletedType(deletedTypeCondition);
			
			fieldMappingProvider.updateByExample(fieldMapping, fieldMappingCondition);
			
		} catch (CustomException e) {
			logger.error(e.getErrorMsg());
		}
    }

}