package com.platform.framemaker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.platform.framemaker.entity.EntityAttribute;
import com.platform.framemaker.entity.EntityFileBody;
import com.platform.utils.JoinUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class CodeGenerator {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final String  SEPARATOR= File.separator;

	public static void main(String[] args) {
		String path=System.getProperty("user.dir") ;
		System.err.println("path>>>"+path);
		String domainObjectName = "person";
		String packageName="com.platform";
//		String resourcePath="platform.field.mapping/src/";
		JavFileTemplate javFileTemplate1 = pojoParam(packageName,domainObjectName,JavaFileType.CONDITION);
		JavFileTemplate javFileTemplate2 = pojoParam(packageName,domainObjectName,JavaFileType.SERVICE);
		JavFileTemplate javFileTemplate3 = pojoParam(packageName,domainObjectName,JavaFileType.PROVIDER);
		JavFileTemplate javFileTemplate4 = pojoParam(packageName,domainObjectName,JavaFileType.PROVIDER_IMPL);
		JavFileTemplate javFileTemplate5 = pojoParam(packageName,domainObjectName,JavaFileType.TEST);
		
		
		new CodeGenerator().genPojoFile(javFileTemplate1);
		new CodeGenerator().genPojoFile(javFileTemplate2);
		new CodeGenerator().genPojoFile(javFileTemplate3);
		new CodeGenerator().genPojoFile(javFileTemplate4);
		new CodeGenerator().genPojoFile(javFileTemplate5);
	}

	public void genPojoFile(JavFileTemplate javFileTemplate) {
		Configuration cfg = null;
		File file = null;
		// java文件的生成目录
		OutputStream fos = null;
		Writer out = null;
		try {
			cfg = new Configuration(Configuration.VERSION_2_3_27);
			file = new File(javFileTemplate.getTemplatePath());
			cfg.setDirectoryForTemplateLoading(file);
			cfg.setDefaultEncoding(javFileTemplate.getCharacterCoding());
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			Template temp = null;
			temp = cfg.getTemplate(javFileTemplate.getTemplateFileName());
			File dir = new File(javFileTemplate.getJavaFilePath());
			if (!dir.exists()) {
				dir.mkdirs();
			}
			fos = new FileOutputStream(new File(dir, javFileTemplate.getJavaFileBody().getClassName() + ".java"));
			out = new OutputStreamWriter(fos);
			temp.process(javFileTemplate.getJavaFileBody(), out);
			fos.flush();
			out.flush();
			logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:success");
		} catch (IOException | TemplateException e1) {
			logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">Exception:" + e1);
		} finally {
			if (null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">IOExceptionFos:" + e);
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">IOExceptionOut:" + e);
				}
			}
		}
	}

	public void genServiceFile(JavFileTemplate pojoTemplate) {
		Configuration cfg = null;
		File file = null;
		// java文件的生成目录
		OutputStream fos = null;
		Writer out = null;
		try {
			cfg = new Configuration(Configuration.VERSION_2_3_27);
			file = new File(pojoTemplate.getTemplatePath());
			cfg.setDirectoryForTemplateLoading(file);
			cfg.setDefaultEncoding(pojoTemplate.getCharacterCoding());
			cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
			Template temp = null;
			temp = cfg.getTemplate(pojoTemplate.getTemplateFileName());
			File dir = new File(pojoTemplate.getJavaFilePath());
			if (!dir.exists()) {
				dir.mkdirs();
			}
			fos = new FileOutputStream(new File(dir, pojoTemplate.getJavaFileBody().getClassName() + ".java"));
			out = new OutputStreamWriter(fos);
			temp.process(pojoTemplate.getJavaFileBody(), out);
			fos.flush();
			out.flush();
			logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:success");
		} catch (IOException | TemplateException e1) {
			logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">Exception:" + e1);
		} finally {
			if (null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
					logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">IOExceptionFos:" + e);
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">IOExceptionOut:" + e);
				}
			}
		}
	}

	private static JavFileTemplate pojoParam(String packageName,String domainObjectName,JavaFileType javaFileType) {
		
		JavFileTemplate pojoTemplate = new JavFileTemplate();
		
		pojoTemplate.setCharacterCoding("UTF-8");
		
		EntityFileBody javaFileBody = new EntityFileBody();
//		javaFileBody.setPackageName("com.platform.framemaker");
//		String templatePath = "H:/platformMybatisPlugin/master/code/platform-mybatis-plugin/platform.mybatis.plugin.common/src/main/templates";
		String className=null;
		String javaFilePath =null;
		File javaDocfile=null;
		//H:\platformMybatisPlugin\master\code\platform-mybatis-plugin\platform.mybatis.plugin.common\src\test\java
		//H:\platformMybatisPlugin\master\code\platform-mybatis-plugin\platform.mybatis.plugin.common\src\main\java
		//H:\platformMybatisPlugin\master\code\platform-mybatis-plugin\platform.mybatis.plugin.common
		String userDir=System.getProperty("user.dir")+SEPARATOR +"src";
		String templatePath = userDir+SEPARATOR+"main"+SEPARATOR+"templates";
		//String packageName="com.platform";
		String packagePath=JoinUtils.join(packageName, ".", SEPARATOR);
		javaFilePath= userDir+SEPARATOR+"main"+SEPARATOR+"java"+SEPARATOR+packagePath;
		if(javaFileType.name().equals("CONDITION")) {
			pojoTemplate.setTemplateFileName("condition.ftl");
			javaFileBody.setPackageName(packageName+".condition");
			javaDocfile=new File(javaFilePath+SEPARATOR+"condition");
			className= toUpperCaseFirstChar(domainObjectName+"Condition");
		}else if(javaFileType.name().equals("SERVICE")){
			pojoTemplate.setTemplateFileName("sevice.ftl");
			javaFileBody.setPackageName(packageName+".service");
			javaDocfile=new File(javaFilePath+SEPARATOR+"service");
			className= toUpperCaseFirstChar(domainObjectName)+"Service";
		}else if(javaFileType.name().equals("PROVIDER")){
			pojoTemplate.setTemplateFileName("provider.ftl");
			javaFileBody.setPackageName(packageName+".provider");
			javaDocfile=new File(javaFilePath+SEPARATOR+"provider");
			className= toUpperCaseFirstChar(domainObjectName)+"Provider";
		}else if(javaFileType.name().equals("PROVIDER_IMPL")){
			pojoTemplate.setTemplateFileName("providerImpl.ftl");
			javaDocfile=new File(javaFilePath+SEPARATOR+"provider"+SEPARATOR+"impl");
			javaFileBody.setPackageName(packageName+".provider.impl");
			className= toUpperCaseFirstChar(domainObjectName)+"ProviderImpl";
		}else  if(javaFileType.name().equals("TEST")){
			pojoTemplate.setTemplateFileName("test.ftl");
			javaFilePath=userDir+SEPARATOR+"test"+SEPARATOR+"java"+SEPARATOR+packagePath;
			javaDocfile=new File(javaFilePath+SEPARATOR+"provider"+SEPARATOR+"test");
			javaFileBody.setPackageName(packageName+".provider.test");
			className= toUpperCaseFirstChar(domainObjectName)+"ProviderTest";
		}
		if(javaDocfile.exists()&&!javaDocfile.isDirectory()) {
			javaDocfile.mkdir();
		}
		pojoTemplate.setTemplatePath(templatePath);
		javaFileBody.setClassName(className);
		javaFileBody.setImportPackage(null);
		javaFileBody.setAuthor("kangjin.zhao");
		List<EntityAttribute> attrList = new ArrayList<EntityAttribute>();
		attrList.add(new EntityAttribute("id", "java.lang.Long"));
		attrList.add(new EntityAttribute("name", "java.lang.String"));
		attrList.add(new EntityAttribute("age", "java.lang.Integer"));
		attrList.add(new EntityAttribute("hobby", "java.util.List<String>"));
		javaFileBody.setAttrList(attrList);
		pojoTemplate.setJavaFileBody(javaFileBody);
		//String resourcePath="platform.field.mapping/src/";
		
		pojoTemplate.setJavaFilePath(javaDocfile.getPath());
		return pojoTemplate;
	}

	public static String toUpperCaseFirstChar(String domainObjectName) {
		if (Character.isUpperCase(domainObjectName.charAt(0)))
			return domainObjectName;
		else
			return (new StringBuilder()).append(Character.toUpperCase(domainObjectName.charAt(0))).append(domainObjectName.substring(1)).toString();
	}
}