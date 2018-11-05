package com.platform.framemaker;

public class WordFirstCharChangeUtils {
	public static String toUpperCaseFirstChar(String domainObjectName) {
		if (Character.isUpperCase(domainObjectName.charAt(0)))
			return domainObjectName;
		else
			return (new StringBuilder()).append(Character.toUpperCase(domainObjectName.charAt(0))).append(domainObjectName.substring(1)).toString();
	}
	public static String toLowerCaseFirstChar(String domainObjectName) {
		if (Character.isLowerCase(domainObjectName.charAt(0)))
			return domainObjectName;
		else
			return (new StringBuilder()).append(Character.toLowerCase(domainObjectName.charAt(0))).append(domainObjectName.substring(1)).toString();
	}
}
