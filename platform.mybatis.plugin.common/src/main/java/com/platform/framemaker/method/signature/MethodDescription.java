package com.platform.framemaker.method.signature;

import java.io.Serializable;
import java.util.List;

public class MethodDescription implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<String> MethodDescription;
	public List<String> getMethodDescription() {
		return MethodDescription;
	}
	public void setMethodDescription(List<String> methodDescription) {
		MethodDescription = methodDescription;
	}
}
