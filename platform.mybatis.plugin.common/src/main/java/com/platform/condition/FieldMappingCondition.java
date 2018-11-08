package com.platform.condition;

import com.platform.configure.base.enums.DeletedType;
import com.platform.configure.condition.Conditions;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class FieldMappingCondition implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
    //fieldid 
    private Conditions<String> fieldid;
    
    //fieldCn 
    private Conditions<String> fieldCn;
    
    //fieldEn 
    private Conditions<String> fieldEn;
    
    //eventuallyUpdatePeople 
    private Conditions<String> eventuallyUpdatePeople;
    
    //creator 
    private Conditions<String> creator;
    
    //creationTime 
    private Conditions<Date> creationTime;
    
    //UpdateTime 
    private Conditions<Date> UpdateTime;
    
    //deleteFlag 
    private Conditions<DeletedType> deleteFlag;
    

    public void setFieldid(Conditions<String> fieldid){
        this.fieldid = fieldid;
    }
    public Conditions<String> getFieldid(){
        return this.fieldid;
    }
    public void setFieldCn(Conditions<String> fieldCn){
        this.fieldCn = fieldCn;
    }
    public Conditions<String> getFieldCn(){
        return this.fieldCn;
    }
    public void setFieldEn(Conditions<String> fieldEn){
        this.fieldEn = fieldEn;
    }
    public Conditions<String> getFieldEn(){
        return this.fieldEn;
    }
    public void setEventuallyUpdatePeople(Conditions<String> eventuallyUpdatePeople){
        this.eventuallyUpdatePeople = eventuallyUpdatePeople;
    }
    public Conditions<String> getEventuallyUpdatePeople(){
        return this.eventuallyUpdatePeople;
    }
    public void setCreator(Conditions<String> creator){
        this.creator = creator;
    }
    public Conditions<String> getCreator(){
        return this.creator;
    }
    public void setCreationTime(Conditions<Date> creationTime){
        this.creationTime = creationTime;
    }
    public Conditions<Date> getCreationTime(){
        return this.creationTime;
    }
    public void setUpdateTime(Conditions<Date> UpdateTime){
        this.UpdateTime = UpdateTime;
    }
    public Conditions<Date> getUpdateTime(){
        return this.UpdateTime;
    }
    public void setDeleteFlag(Conditions<DeletedType> deleteFlag){
        this.deleteFlag = deleteFlag;
    }
    public Conditions<DeletedType> getDeleteFlag(){
        return this.deleteFlag;
    }
}