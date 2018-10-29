package com.platform.framemaker;

import java.io.Serializable;

public class PojoTemplate implements Serializable{
	private static final long serialVersionUID = 1L;
	private String characterCoding;
	private String templatePath;
	private JavaFileBody javaFileBody;
	private String templateFileName;
	private String javaFilePath;

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

	public JavaFileBody getJavaFileBody() {
		return javaFileBody;
	}
	public void setJavaFileBody(JavaFileBody javaFileBody) {
		this.javaFileBody = javaFileBody;
	}
	public String getCharacterCoding() {
		return characterCoding;
	}
	public void setCharacterCoding(String characterCoding) {
		this.characterCoding = characterCoding;
	}
}
