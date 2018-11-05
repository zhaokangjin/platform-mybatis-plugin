package com.platform.framemaker;

import java.io.Serializable;

import com.platform.framemaker.method.signature.MethodNotesAndAnnotations;
import com.platform.framemaker.method.signature.MethodParams;

public class MethodFeature implements Serializable{

	private static final long serialVersionUID = 1L;

	private MethodNotesAndAnnotations methodNotes;
	
	private String returnType ;
	
	private String methodName;
	
	private MethodParams serviceParams;
	
	private String daoMethodName;
	
	private MethodParams daoParams;

	public MethodFeature(MethodNotesAndAnnotations methodNotes,String returnType,String methodName,MethodParams serviceParams,String daoMethodName,MethodParams daoParams) {
		this.methodNotes=methodNotes;
		this.returnType=returnType;
		this.methodName=methodName;
		this.serviceParams=serviceParams;
		this.daoMethodName=methodName;
		this.daoParams=daoParams;
	}
	
	public MethodNotesAndAnnotations getMethodNotes() {
		return methodNotes;
	}

	public void setMethodNotes(MethodNotesAndAnnotations methodNotes) {
		this.methodNotes = methodNotes;
	}


	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public MethodParams getServiceParams() {
		return serviceParams;
	}

	public void setServiceParams(MethodParams serviceParams) {
		this.serviceParams = serviceParams;
	}

	public String getDaoMethodName() {
		return daoMethodName;
	}

	public void setDaoMethodName(String daoMethodName) {
		this.daoMethodName = daoMethodName;
	}

	public MethodParams getDaoParams() {
		return daoParams;
	}

	public void setDaoParams(MethodParams daoParams) {
		this.daoParams = daoParams;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
}
