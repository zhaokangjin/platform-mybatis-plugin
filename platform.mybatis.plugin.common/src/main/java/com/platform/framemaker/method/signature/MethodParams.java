package com.platform.framemaker.method.signature;

import java.io.Serializable;

public class MethodParams implements Serializable {

	private static final long serialVersionUID = 1L;
	private String paramDescription;
	
	public MethodParams(String paramDescription) {
		this.paramDescription=paramDescription;
	}
	
	public String getParamDescription() {
		return paramDescription;
	}
	public void setParamDescription(String paramDescription) {
		this.paramDescription = paramDescription;
	}
	
}
