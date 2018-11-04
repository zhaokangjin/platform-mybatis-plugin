package com.platform.framemaker.method.signature;

import java.io.Serializable;

public class ParamDescription implements Serializable {

	private static final long serialVersionUID = 1L;
	private String packageName;
	private String className;
	private String instanceName;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
}
