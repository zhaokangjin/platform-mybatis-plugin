package com.platform.framemaker.entity;

public class EntityAttribute {
	private String type;
	private String name;

	public EntityAttribute(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
