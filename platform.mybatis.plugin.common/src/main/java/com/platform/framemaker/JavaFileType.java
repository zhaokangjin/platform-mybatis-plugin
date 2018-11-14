package com.platform.framemaker;

public enum JavaFileType {
	CONDITION("Condition"), SERVICE("Service"), PROVIDER("Provider"), PROVIDER_IMPL("ProviderImpl"), TEST("Test");
	private JavaFileType(String type) {
		this.type = type;
	}

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
