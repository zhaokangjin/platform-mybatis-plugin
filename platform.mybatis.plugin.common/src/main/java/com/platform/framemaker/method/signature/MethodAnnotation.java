package com.platform.framemaker.method.signature;

import java.io.Serializable;
import java.util.List;

public class MethodAnnotation implements Serializable{
	private static final long serialVersionUID = 1L;

	private List<String> methodAnnotation;

	public List<String> getMethodAnnotation() {
		return methodAnnotation;
	}

	public void setMethodAnnotation(List<String> methodAnnotation) {
		this.methodAnnotation = methodAnnotation;
	}
}
