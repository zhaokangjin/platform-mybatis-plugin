package com.platform.framemaker.service;

import java.io.Serializable;
import java.util.List;

import com.platform.framemaker.method.signature.MethodFeature;

public class SeviceFileBody implements Serializable{
	private static final long serialVersionUID = 1L;
	private String packageName;
	//特征依赖包导入
	private List<String> importPackage;
	private String dataAlias;
	private String className;
	private String domainName;
	private String lowerDomainName;
	private List<MethodFeature> methodFeatureList;
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public List<String> getImportPackage() {
		return importPackage;
	}
	public void setImportPackage(List<String> importPackage) {
		this.importPackage = importPackage;
	}
	public String getDataAlias() {
		return dataAlias;
	}
	public void setDataAlias(String dataAlias) {
		this.dataAlias = dataAlias;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public String getLowerDomainName() {
		return lowerDomainName;
	}
	public void setLowerDomainName(String lowerDomainName) {
		this.lowerDomainName = lowerDomainName;
	}
	public List<MethodFeature> getMethodFeatureList() {
		return methodFeatureList;
	}
	public void setMethodFeatureList(List<MethodFeature> methodFeatureList) {
		this.methodFeatureList = methodFeatureList;
	}
}
