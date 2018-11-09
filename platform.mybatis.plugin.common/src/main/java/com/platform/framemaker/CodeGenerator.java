package com.platform.framemaker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.platform.dao.master.FieldMappingMapper;
import com.platform.framemaker.entity.EntityAttribute;
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
		String domainName = "fieldMapping";
		String packageName="com.platform";
		JavaFileBody conditionFileBody=new JavaFileBody(packageName,domainName,JavaFileType.CONDITION);
		JavaFileBody serviceFileBody=new JavaFileBody(packageName,domainName,JavaFileType.SERVICE);
//		JavaFileBody providerFileBody=new JavaFileBody(packageName,domainName,JavaFileType.PROVIDER);
//		JavaFileBody providerImplFileBody=new JavaFileBody(packageName,domainName,JavaFileType.PROVIDER_IMPL);
//		JavaFileBody testFileBody=new JavaFileBody(packageName,domainName,JavaFileType.TEST);
		JavFileTemplate<JavaFileBody> javFileTemplate1 = generatorJavaFile(conditionFileBody);
		JavFileTemplate<JavaFileBody> javFileTemplate2 = generatorJavaFile(serviceFileBody);
//		JavFileTemplate<JavaFileBody> javFileTemplate3 = generatorJavaFile(providerFileBody);
//		JavFileTemplate<JavaFileBody> javFileTemplate4 = generatorJavaFile(providerImplFileBody);
//		JavFileTemplate<JavaFileBody> javFileTemplate5 = generatorJavaFile(testFileBody)
		
		
		new CodeGenerator().genJavaFile(javFileTemplate1);
		new CodeGenerator().genJavaFile(javFileTemplate2);
//		new CodeGenerator().genJavaFile(javFileTemplate3);
//		new CodeGenerator().genJavaFile(javFileTemplate4);
//		new CodeGenerator().genJavaFile(javFileTemplate5);
	}

	public void genJavaFile(JavFileTemplate<JavaFileBody> javFileTemplate) {
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
			fos = new FileOutputStream(new File(dir, javFileTemplate.getFileBody().getClassName() + ".java"));
			out = new OutputStreamWriter(fos);
			temp.process(javFileTemplate.getFileBody(), out);
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

	public void genServiceFile(JavFileTemplate<JavaFileBody> pojoTemplate) {
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
			fos = new FileOutputStream(new File(dir, pojoTemplate.getFileBody().getClassName() + ".java"));
			out = new OutputStreamWriter(fos);
			temp.process(pojoTemplate.getFileBody(), out);
			
			
			logger.info(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">result:success");
		} catch (IOException | TemplateException e1) {
			logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">Exception:" + e1);
		} finally {
			if (null != fos) {
				try {
					fos.flush();
					fos.close();
				} catch (IOException e) {
					logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">IOExceptionFos:" + e);
				}
			}
			if (null != out) {
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					logger.error(Thread.currentThread().getStackTrace()[1].getClassName() + ">" + Thread.currentThread().getStackTrace()[1].getMethodName() + ">IOExceptionOut:" + e);
				}
			}
		}
	}
/**
 * 
 * @Title: generatorJavaFile   
 * @Description: TODO  
 * @param javaFileBody
 * @return
 */
	private static JavFileTemplate<JavaFileBody> generatorJavaFile(JavaFileBody javaFileBody) {
		JavFileTemplate<JavaFileBody> javFileTemplate = new JavFileTemplate<JavaFileBody>();
		String javaFilePath =null;
		File javaDocfile=null;
		String userDir=System.getProperty("user.dir")+SEPARATOR +"src";
		String templatePath = userDir+SEPARATOR+"main"+SEPARATOR+"templates";
		String packageName=javaFileBody.getPackageName();
		javaFileBody.setDataAlias("master");
		String packagePath=JoinUtils.join(packageName, ".", SEPARATOR);
		javaFilePath= userDir+SEPARATOR+"main"+SEPARATOR+"java"+SEPARATOR+packagePath;
		if(javaFileBody.getJavaFileType().name().equals("CONDITION")) {
			javFileTemplate.setTemplateFileName("condition.ftl");
			javaFileBody.setPackageName(packageName+".condition");
			javaDocfile=new File(javaFilePath+SEPARATOR+"condition");
			Class<?> clazz=null;
			List<EntityAttribute> attrList=null;
			try {
				clazz=Class.forName(packageName+".entity."+javaFileBody.getUpperDomainName());
				Field[] fields=clazz.getDeclaredFields();
				attrList = new ArrayList<EntityAttribute>();
				for(int i=0;i<fields.length;i++) {
					if(!"serialVersionUID".equals(fields[i].getName())) {
						//fields[i].getType().getName().substring(fields[i].getType().getName().lastIndexOf("."), fields[i].getType().getName().length)
						attrList.add(new EntityAttribute(fields[i].getName(), "Conditions<"+fields[i].getType().getName().substring(fields[i].getType().getName().lastIndexOf(".")+1, fields[i].getType().getName().length())+">"));
					}
				}
				javaFileBody.setAttrList(attrList);
			
			} catch (ClassNotFoundException e) {
			}
			
			
		}else if(javaFileBody.getJavaFileType().name().equals("SERVICE")){
			javFileTemplate.setTemplateFileName("sevice.ftl");
			javaFileBody.setPackageName(packageName+".service");
			javaDocfile=new File(javaFilePath+SEPARATOR+"service");
			List<MethodFeature> methodItemList=new ArrayList<MethodFeature>();
			//com.platform.dao.master.FieldMappingMapper
			
			Class<?> clazz=null;
			try {
				clazz = Class.forName(packageName+".dao.master."+javaFileBody.getUpperDomainName()+"Mapper");
			} catch (ClassNotFoundException e) {
				
			}
			Method[] methods=clazz.getMethods();
			Set<String> importSet=new HashSet<String>();
			for(int i=0;i<methods.length;i++) {
				Method method=methods[i];
				if(method.getName().toLowerCase().contains("update") ||method.getName().toLowerCase().contains("delete") ||method.getName().toLowerCase().contains("insert")) {
					javaFileBody.setTxMethodHeader("@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)");
					javaFileBody.setTxMethodException("TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();");
				}
				Class<?>[] types=method.getParameterTypes();
				StringBuilder paramString=new StringBuilder();
				StringBuilder daoString=new StringBuilder();
				for(int j=0;j<types.length;j++) {
					Class<?> type=types[j];
					if(j==types.length-1) {
						if(null!=type.getSimpleName() && !type.getSimpleName().endsWith("Example")) {
							paramString.append(type.getSimpleName()).append(" ").append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName()));
						}else if(null!=type.getSimpleName() && type.getSimpleName().endsWith("Example")){
							javaFileBody.setNewExample(type.getSimpleName()+" "+WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName())+"=new "+type.getSimpleName()+"();");
							javaFileBody.setSerValueExample("ConditonToExample<"+javaFileBody.getUpperDomainName()+"Condition,"+type.getSimpleName()+"> conditonToExample =new ConditonToExample<"+javaFileBody.getUpperDomainName()+"Condition,"+type.getSimpleName()+">()");
						}
						daoString.append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName()));
					}else {
						if(null!=type.getSimpleName() && !type.getSimpleName().endsWith("Example")) {
							paramString.append(type.getSimpleName()).append(" ").append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName())).append(",");
						}
						daoString.append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName())).append(",");
					}
					importSet.add(type.getName().substring(0, type.getName().lastIndexOf(".")));
				}
				String paramStr=paramString.toString();
				if(paramStr.endsWith(",")) {
					paramStr=paramStr.substring(0, paramStr.length()-1);
				}
				List<String> descriptionList=new ArrayList<String>();
				descriptionList.add("/**");
				descriptionList.add(" * @Title: "+clazz.getSimpleName()+">"+method.getName());  
				descriptionList.add(" * @Description: TODO "); 
				descriptionList.add(" * @param javaFileBody");
				descriptionList.add(" * @return");
				descriptionList.add(" */");				
				
				Annotation[] annotations=method.getAnnotations();
				List<String> annotationList=new ArrayList<String>();
				for(int j=0;j<annotations.length;j++) {
					Annotation annotation=annotations[j];
					annotationList.add(annotation.annotationType().getSimpleName());
					importSet.add(annotation.annotationType().getName().substring(0, annotation.annotationType().getName().lastIndexOf(".")));
				}
				
				String returnType="ResultStatus";
				String returnTypeGen=method.getReturnType().getSimpleName();
				
				if(returnTypeGen.equals("int")) {
					returnTypeGen="Integer";
				}else if(returnTypeGen.equals("long")) {
					returnTypeGen="Long";
				}else{
					returnTypeGen=returnTypeGen+"<"+javaFileBody.getUpperDomainName()+">";
				}
				
				MethodFeature methodFeature=new MethodFeature(descriptionList,annotationList,returnType,returnTypeGen,method.getName(),paramStr,method.getName(),daoString.toString());
				methodItemList.add(methodFeature);
			}
			javaFileBody.setMethodFeatureList(methodItemList);
		}else if(javaFileBody.getJavaFileType().name().equals("PROVIDER")){
			javFileTemplate.setTemplateFileName("provider.ftl");
			javaFileBody.setPackageName(packageName+".provider");
			javaDocfile=new File(javaFilePath+SEPARATOR+"provider");
		}else if(javaFileBody.getJavaFileType().name().equals("PROVIDER_IMPL")){
			javFileTemplate.setTemplateFileName("providerImpl.ftl");
			javaDocfile=new File(javaFilePath+SEPARATOR+"provider"+SEPARATOR+"impl");
			javaFileBody.setPackageName(packageName+".provider.impl");
		}else  if(javaFileBody.getJavaFileType().name().equals("TEST")){
			javFileTemplate.setTemplateFileName("test.ftl");
			javaFilePath=userDir+SEPARATOR+"test"+SEPARATOR+"java"+SEPARATOR+packagePath;
			javaDocfile=new File(javaFilePath+SEPARATOR+"provider"+SEPARATOR+"test");
			javaFileBody.setPackageName(packageName+".provider.test");
		}
		
		if(javaDocfile.exists()&&!javaDocfile.isDirectory()) {
			javaDocfile.mkdir();
		}
		javFileTemplate.setTemplatePath(templatePath);
		javFileTemplate.setFileBody(javaFileBody);;
		javFileTemplate.setJavaFilePath(javaDocfile.getPath());
		javFileTemplate.setCharacterCoding("UTF-8");
		return javFileTemplate;
	}
}