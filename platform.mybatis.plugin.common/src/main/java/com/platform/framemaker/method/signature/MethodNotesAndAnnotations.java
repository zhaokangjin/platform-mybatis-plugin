package com.platform.framemaker.method.signature;

import java.io.Serializable;
import java.util.List;

public class MethodNotesAndAnnotations implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<String> methodNotes;
	private List<String> methodAnnotation;

	public List<String> getMethodAnnotation() {
		return methodAnnotation;
	}

	public void setMethodAnnotation(List<String> methodAnnotation) {
		this.methodAnnotation = methodAnnotation;
	}

	public List<String> getMethodNotes() {
		return methodNotes;
	}

	public void setMethodNotes(List<String> methodNotes) {
		this.methodNotes = methodNotes;
	}
}
