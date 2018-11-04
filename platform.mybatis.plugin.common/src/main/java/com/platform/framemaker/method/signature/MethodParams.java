package com.platform.framemaker.method.signature;

import java.io.Serializable;
import java.util.List;

public class MethodParams implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<ParamDescription> paramDescriptionList;
	public List<ParamDescription> getParamDescriptionList() {
		return paramDescriptionList;
	}
	public void setParamDescriptionList(List<ParamDescription> paramDescriptionList) {
		this.paramDescriptionList = paramDescriptionList;
	}
}
