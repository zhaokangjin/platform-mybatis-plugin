package com.platform.framemaker;

import java.io.Serializable;

public class ConditionFeature implements Serializable {
	private static final long serialVersionUID = 1L;
	private String fieldName;
	private String fieldType;
	private String condition;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
