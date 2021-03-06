package com.platform.framemaker;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.platform.framemaker.entity.EntityAttribute;

public class JavaFileBody implements Serializable {

	private static final long serialVersionUID = 1L;

	public JavaFileBody(String packageName, String domainName, JavaFileType javaFileType) {
		this.className=WordFirstCharChangeUtils.toUpperCaseFirstChar(domainName)+javaFileType.getType();
		this.packageName = packageName;
		this.domainName = domainName;
		this.lowerDomainName = WordFirstCharChangeUtils.toLowerCaseFirstChar(domainName);
		this.javaFileType = javaFileType;
		this.upperDomainName = WordFirstCharChangeUtils.toUpperCaseFirstChar(domainName);
		this.basePackageName = packageName;
	}
	public JavaFileBody(String packageName, String domainName, JavaFileType javaFileType,String appFileName) {
		this.className=WordFirstCharChangeUtils.toUpperCaseFirstChar(domainName)+javaFileType.getType();
		this.packageName = packageName;
		this.domainName = domainName;
		this.lowerDomainName = WordFirstCharChangeUtils.toLowerCaseFirstChar(domainName);
		this.javaFileType = javaFileType;
		this.upperDomainName = WordFirstCharChangeUtils.toUpperCaseFirstChar(domainName);
		this.basePackageName = packageName;
		this.appFileName=appFileName;
	}
	private String appFileName;
	private String txMethodHeader;
	private String txMethodException;
	private String serviceValueExample;
	private String javaFilePath;
	private String dataAlias;
	private String domainName;
	private String lowerDomainName;
	private String upperDomainName;
	private String basePackageName;
	private JavaFileType javaFileType;
	private String packageName;
	private List<String> classDescriptions;
	private Set<String> importSet;
	private List<String> classAnnotationList;
	private String className;
	private List<String> fieldList;
	private List<EntityAttribute> attrList;
	private List<MethodFeature> methodFeatureList;

	public String getJavaFilePath() {
		return javaFilePath;
	}

	public String getDataAlias() {
		return dataAlias;
	}

	public String getDomainName() {
		return domainName;
	}

	public String getLowerDomainName() {
		return lowerDomainName;
	}

	public String getUpperDomainName() {
		return upperDomainName;
	}

	public String getBasePackageName() {
		return basePackageName;
	}

	public JavaFileType getJavaFileType() {
		return javaFileType;
	}

	public String getPackageName() {
		return packageName;
	}

	public List<String> getClassDescriptions() {
		return classDescriptions;
	}

	public Set<String> getImportSet() {
		return importSet;
	}

	public List<String> getClassAnnotationList() {
		return classAnnotationList;
	}

	public String getClassName() {
		return className;
	}

	public List<String> getFieldList() {
		return fieldList;
	}

	public List<EntityAttribute> getAttrList() {
		return attrList;
	}

	public List<MethodFeature> getMethodFeatureList() {
		return methodFeatureList;
	}

	public void setJavaFilePath(String javaFilePath) {
		this.javaFilePath = javaFilePath;
	}

	public void setDataAlias(String dataAlias) {
		this.dataAlias = dataAlias;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public void setLowerDomainName(String lowerDomainName) {
		this.lowerDomainName = lowerDomainName;
	}

	public void setUpperDomainName(String upperDomainName) {
		this.upperDomainName = upperDomainName;
	}

	public void setBasePackageName(String basePackageName) {
		this.basePackageName = basePackageName;
	}

	public void setJavaFileType(JavaFileType javaFileType) {
		this.javaFileType = javaFileType;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public void setClassDescriptions(List<String> classDescriptions) {
		this.classDescriptions = classDescriptions;
	}

	public void setImportSet(Set<String> importSet) {
		this.importSet = importSet;
	}

	public void setClassAnnotationList(List<String> classAnnotationList) {
		this.classAnnotationList = classAnnotationList;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setFieldList(List<String> fieldList) {
		this.fieldList = fieldList;
	}

	public void setAttrList(List<EntityAttribute> attrList) {
		this.attrList = attrList;
	}

	public void setMethodFeatureList(List<MethodFeature> methodFeatureList) {
		this.methodFeatureList = methodFeatureList;
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

	public String getServiceValueExample() {
		return serviceValueExample;
	}

	public void setServiceValueExample(String serviceValueExample) {
		this.serviceValueExample = serviceValueExample;
	}

	public String getAppFileName() {
		return appFileName;
	}

	public void setAppFileName(String appFileName) {
		this.appFileName = appFileName;
	}
}
