package com.platform.framemaker.entity;

import java.io.Serializable;
import java.util.List;

public class EntityFileBody implements Serializable {
	private static final long serialVersionUID = 1L;
	private String packageName;
	//依赖包导入
	private List<String> importPackage;
	private String className;
	private String author;
	//构造pojo的属性
	private List<EntityAttribute> attrList;

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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<EntityAttribute> getAttrList() {
		return attrList;
	}

	public void setAttrList(List<EntityAttribute> attrList) {
		this.attrList = attrList;
	}

	@Override
	public String toString() {
		return "JavaFileDoc [packageName=" + packageName + ", importPackage=" + importPackage + ", className=" + className + ", author=" + author + ", attrList=" + attrList + "]";
	}
}
