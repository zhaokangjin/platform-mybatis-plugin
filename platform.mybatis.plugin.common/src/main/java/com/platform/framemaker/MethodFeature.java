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
	
	
}
