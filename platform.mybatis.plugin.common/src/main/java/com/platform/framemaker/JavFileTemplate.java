package com.platform.framemaker;

import java.io.Serializable;

public class JavFileTemplate<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private String characterCoding;
	private String templatePath;
	private T fileBody;
	private String templateFileName;
	private String javaFilePath;
	private String dataAlias;
	private String domainName;
	private String lowerDomainName;

	public String getTemplatePath() {
		return templatePath;
	}
	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}
	public String getTemplateFileName() {
		return templateFileName;
	}
	public void setTemplateFileName(String templateFileName) {
		this.templateFileName = templateFileName;
	}
	public String getJavaFilePath() {
		return javaFilePath;
	}
	public void setJavaFilePath(String javaFilePath) {
		this.javaFilePath = javaFilePath;
	}

	public String getCharacterCoding() {
		return characterCoding;
	}
	public void setCharacterCoding(String characterCoding) {
		this.characterCoding = characterCoding;
	}
	public T getFileBody() {
		return fileBody;
	}
	public void setFileBody(T fileBody) {
		this.fileBody = fileBody;
	}
	public String getDataAlias() {
		return dataAlias;
	}
	public void setDataAlias(String dataAlias) {
		this.dataAlias = dataAlias;
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

}
