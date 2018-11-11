package com.platform.framemaker;

import java.io.Serializable;
import java.util.List;

public class MethodFeature implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<String> methodDescription;
	
	private List<String> methodAnnotation;
	
	private String returnType ;
	
	private String returnTypeGen ;
	
	private String methodName;
	
	private String serviceParams;
	
	private String daoMethodName;
	
	private String daoParams;
	
	private String conditionValueToExample;
	
	private String newExample;
	
	private String txMethodHeader;
	
	private String txMethodException;

	public MethodFeature(List<String> methodDescription,List<String> methodAnnotation,String returnType,String returnTypeGen,String methodName,String serviceParams,String daoMethodName,String daoParams) {
		this.methodDescription=methodDescription;
		this.methodAnnotation=methodAnnotation;
		this.returnType=returnType;
		this.returnTypeGen=returnTypeGen;
		this.methodName=methodName;
		this.serviceParams=serviceParams;
		this.daoMethodName=methodName;
		this.daoParams=daoParams;
	}

	public List<String> getMethodDescription() {
		return methodDescription;
	}

	public List<String> getMethodAnnotation() {
		return methodAnnotation;
	}

	public String getReturnType() {
		return returnType;
	}

	public String getMethodName() {
		return methodName;
	}

	public String getServiceParams() {
		return serviceParams;
	}

	public String getDaoMethodName() {
		return daoMethodName;
	}

	public String getDaoParams() {
		return daoParams;
	}

	public String getReturnTypeGen() {
		return returnTypeGen;
	}

	public void setReturnTypeGen(String returnTypeGen) {
		this.returnTypeGen = returnTypeGen;
	}

	public String getConditionValueToExample() {
		return conditionValueToExample;
	}

	public String getNewExample() {
		return newExample;
	}

	public void setConditionValueToExample(String conditionValueToExample) {
		this.conditionValueToExample = conditionValueToExample;
	}

	public void setNewExample(String newExample) {
		this.newExample = newExample;
	}

	public String getTxMethodHeader() {
		return txMethodHeader;
	}

	public void setTxMethodHeader(String txMethodHeader) {
		this.txMethodHeader = txMethodHeader;
	}

	public String getTxMethodException() {
		return txMethodException;
	}

	public void setTxMethodException(String txMethodException) {
		this.txMethodException = txMethodException;
	}
	
	
}
