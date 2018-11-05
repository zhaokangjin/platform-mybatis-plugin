package com.platform.framemaker;

import java.io.Serializable;
import java.util.List;

import com.platform.framemaker.entity.EntityAttribute;

public class JavaFileBody implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public JavaFileBody(String domainName,JavaFileType javaFileType) {
		if(javaFileType.name().equals("CONDITION")) {
			this.className=WordFirstCharChangeUtils.toUpperCaseFirstChar(domainName)+"Condition";
		}else if(javaFileType.name().equals("SERVICE")) {
			this.className=WordFirstCharChangeUtils.toUpperCaseFirstChar(domainName)+"Service";
		}else if(javaFileType.name().equals("PROVIDER")) {
			this.className=WordFirstCharChangeUtils.toUpperCaseFirstChar(domainName)+"Provider";
		}else if(javaFileType.name().equals("PROVIDER_IMPL")) {
			this.className=WordFirstCharChangeUtils.toUpperCaseFirstChar(domainName)+"ProviderImpl";
		}else if(javaFileType.name().equals("TEST")) {
			this.className=WordFirstCharChangeUtils.toUpperCaseFirstChar(domainName)+"Test";
		}
		this.domainName=domainName;
		this.javaFileType=javaFileType;
	}
	public JavaFileBody(String packageName,String domainName,JavaFileType javaFileType) {
		if(javaFileType.name().equals("CONDITION")) {
			this.className=WordFirstCharChangeUtils.toUpperCaseFirstChar(domainName)+"Condition";
		}else if(javaFileType.name().equals("SERVICE")) {
			this.className=WordFirstCharChangeUtils.toUpperCaseFirstChar(domainName)+"Service";
		}else if(javaFileType.name().equals("PROVIDER")) {
			this.className=WordFirstCharChangeUtils.toUpperCaseFirstChar(domainName)+"Provider";
		}else if(javaFileType.name().equals("PROVIDER_IMPL")) {
			this.className=WordFirstCharChangeUtils.toUpperCaseFirstChar(domainName)+"ProviderImpl";
		}else if(javaFileType.name().equals("TEST")) {
			this.className=WordFirstCharChangeUtils.toUpperCaseFirstChar(domainName)+"Test";
		}
		this.packageName=packageName;
		this.domainName=domainName;
		this.lowerDomainName=WordFirstCharChangeUtils.toLowerCaseFirstChar(domainName);
		this.javaFileType=javaFileType;
		this.upperDomainName=WordFirstCharChangeUtils.toUpperCaseFirstChar(domainName);
		this.basePackageName=packageName;
	}
	private String javaFilePath;
	private String dataAlias;
	private String domainName;
	private String lowerDomainName;
	private String upperDomainName;
	private String basePackageName;
	private JavaFileType javaFileType;
	private String packageName;
	private List<String> classDescriptions;
	private List<String> importList;
	private List<String> classAnnotationList;
	private String className;
	private List<String> fieldList;
	private List<EntityAttribute> attrList;
	private List<MethodFeature> methodFeatureList;
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public List<String> getClassDescriptions() {
		return classDescriptions;
	}
	public void setClassDescriptions(List<String> classDescriptions) {
		this.classDescriptions = classDescriptions;
	}
	public List<String> getImportList() {
		return importList;
	}
	public void setImportList(List<String> importList) {
		this.importList = importList;
	}
	public List<String> getClassAnnotationList() {
		return classAnnotationList;
	}
	public void setClassAnnotationList(List<String> classAnnotationList) {
		this.classAnnotationList = classAnnotationList;
	}
	public String getClassName() {
		return className;
	}
	public List<String> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<String> fieldList) {
		this.fieldList = fieldList;
	}
	public List<MethodFeature> getMethodFeatureList() {
		return methodFeatureList;
	}
	public void setMethodFeatureList(List<MethodFeature> methodFeatureList) {
		this.methodFeatureList = methodFeatureList;
	}
	public List<EntityAttribute> getAttrList() {
		return attrList;
	}
	public void setAttrList(List<EntityAttribute> attrList) {
		this.attrList = attrList;
	}
	public String getDomainName() {
		return domainName;
	}
	public JavaFileType getJavaFileType() {
		return javaFileType;
	}
	public String getJavaFilePath() {
		return javaFilePath;
	}
	public void setJavaFilePath(String javaFilePath) {
		this.javaFilePath = javaFilePath;
	}
	public String getDataAlias() {
		return dataAlias;
	}
	public void setDataAlias(String dataAlias) {
		this.dataAlias = dataAlias;
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
}
