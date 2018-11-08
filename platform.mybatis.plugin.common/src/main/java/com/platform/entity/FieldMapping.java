package com.platform.entity;

import com.platform.configure.base.BaseEntity;
import com.platform.configure.base.enums.DeletedType;

import java.io.Serializable;
import java.util.Date;

public class FieldMapping extends BaseEntity implements Serializable {
    // tpl_field_mapping.FIELDID
    private String fieldid;

    // tpl_field_mapping.FIELD_CN
    private String fieldCn;

    // tpl_field_mapping.FIELD_EN
    private String fieldEn;

    // tpl_field_mapping.EVENTUALLY_UPDATE_PEOPLE
    private String eventuallyUpdatePeople;

    // tpl_field_mapping.CREATOR
    private String creator;

    // tpl_field_mapping.CREATECREATION_TIME
    private Date creationTime;

    // tpl_field_mapping.EVENTUALLY_UPDATE_TIME
    private Date UpdateTime;

    // tpl_field_mapping.DELETE_FLAG
    private DeletedType deleteFlag;

    //tpl_field_mapping
    private static final long serialVersionUID = 1L;

	public String getFieldid() {
		return fieldid;
	}

	public void setFieldid(String fieldid) {
		this.fieldid = fieldid;
	}

	public String getFieldCn() {
		return fieldCn;
	}

	public void setFieldCn(String fieldCn) {
		this.fieldCn = fieldCn;
	}

	public String getFieldEn() {
		return fieldEn;
	}

	public void setFieldEn(String fieldEn) {
		this.fieldEn = fieldEn;
	}

	public String getEventuallyUpdatePeople() {
		return eventuallyUpdatePeople;
	}

	public void setEventuallyUpdatePeople(String eventuallyUpdatePeople) {
		this.eventuallyUpdatePeople = eventuallyUpdatePeople;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getUpdateTime() {
		return UpdateTime;
	}

	public void setUpdateTime(Date updateTime) {
		UpdateTime = updateTime;
	}

	public DeletedType getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(DeletedType deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}