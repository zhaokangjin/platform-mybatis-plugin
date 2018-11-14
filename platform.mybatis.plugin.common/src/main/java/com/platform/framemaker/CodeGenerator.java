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
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.platform.condition.FieldMappingCondition;
import com.platform.framemaker.entity.EntityAttribute;
import com.platform.utils.JoinUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class CodeGenerator {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final String SEPARATOR = File.separator;

	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		System.err.println("path>>>" + path);
		String domainName = "fieldMapping";
		String packageName = "com.platform";
		String appFileName = "FieldMappingApp.class";
		// com.platform.dao.master
//		JavaFileBody conditionFileBody = new JavaFileBody(packageName, domainName, JavaFileType.CONDITION);
//		JavFileTemplate<JavaFileBody> javFileTemplate1 = generatorJavaFile(conditionFileBody);
//		new CodeGenerator().genJavaFile(javFileTemplate1);
//		JavaFileBody serviceFileBody = new JavaFileBody(packageName, domainName, JavaFileType.SERVICE);
//		JavFileTemplate<JavaFileBody> javFileTemplate2 = generatorJavaFile(serviceFileBody);
//		new CodeGenerator().genJavaFile(javFileTemplate2);
//
//		JavaFileBody providerFileBody = new JavaFileBody(packageName, domainName, JavaFileType.PROVIDER);
//		JavFileTemplate<JavaFileBody> javFileTemplate3 = generatorJavaFile(providerFileBody);
//		new CodeGenerator().genJavaFile(javFileTemplate3);
//		JavaFileBody providerImplFileBody = new JavaFileBody(packageName, domainName, JavaFileType.PROVIDER_IMPL);
//		JavFileTemplate<JavaFileBody> javFileTemplate4 = generatorJavaFile(providerImplFileBody);
//		new CodeGenerator().genJavaFile(javFileTemplate4);

		JavaFileBody testFileBody = new JavaFileBody(packageName, domainName, JavaFileType.TEST, appFileName);
		JavFileTemplate<JavaFileBody> javFileTemplate5 = generatorJavaFile(testFileBody);
		new CodeGenerator().genJavaFile(javFileTemplate5);

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
	public static JavFileTemplate<JavaFileBody> generatorJavaFile(JavaFileBody javaFileBody) {
		JavFileTemplate<JavaFileBody> javFileTemplate = new JavFileTemplate<JavaFileBody>();
		String javaFilePath = null;
		File javaDocfile = null;
		String userDir = System.getProperty("user.dir") + SEPARATOR + "src";
		String templatePath = userDir + SEPARATOR + "main" + SEPARATOR + "templates";
		String packageName = javaFileBody.getPackageName();
		javaFileBody.setDataAlias("master");
		String packagePath = JoinUtils.join(packageName, ".", SEPARATOR);
		javaFilePath = userDir + SEPARATOR + "main" + SEPARATOR + "java" + SEPARATOR + packagePath;
		if (javaFileBody.getJavaFileType().name().equals("CONDITION")) {
			javFileTemplate.setTemplateFileName("condition.ftl");
			javaFileBody.setPackageName(packageName + ".condition");
			javaDocfile = new File(javaFilePath + SEPARATOR + "condition");
			Class<?> clazz = null;
			List<EntityAttribute> attrList = null;
			try {
				clazz = Class.forName(packageName + ".entity." + javaFileBody.getUpperDomainName());
				Field[] fields = clazz.getDeclaredFields();
				attrList = new ArrayList<EntityAttribute>();
				for (int i = 0; i < fields.length; i++) {
					if (!"serialVersionUID".equals(fields[i].getName())) {
						attrList.add(new EntityAttribute(fields[i].getName(), "Conditions<" + fields[i].getType().getName().substring(fields[i].getType().getName().lastIndexOf(".") + 1, fields[i].getType().getName().length()) + ">"));
					}
				}
				javaFileBody.setAttrList(attrList);

			} catch (ClassNotFoundException e) {
			}

		} else if (javaFileBody.getJavaFileType().name().equals("SERVICE")) {
			javFileTemplate.setTemplateFileName("sevice.ftl");
			javaFileBody.setPackageName(packageName + ".service");
			javaDocfile = new File(javaFilePath + SEPARATOR + "service");
			List<MethodFeature> methodItemList = new ArrayList<MethodFeature>();
			// com.platform.dao.master.FieldMappingMapper

			Class<?> clazz = null;
			try {
				clazz = Class.forName(packageName + ".dao.master." + javaFileBody.getUpperDomainName() + "Mapper");
			} catch (ClassNotFoundException e) {

			}
			Method[] methods = clazz.getMethods();
			Set<String> importSet = new HashSet<String>();

			for (int i = 0; i < methods.length; i++) {
				Class<?> exampleType = null;
				Method method = methods[i];
				Class<?>[] types = method.getParameterTypes();
				// getGenericReturnType
				StringBuilder serviceParamsString = new StringBuilder();
				StringBuilder daoParamString = new StringBuilder();
				for (int j = 0; j < types.length; j++) {
					Class<?> type = types[j];

					if (j == types.length - 1) {
						if (null != type.getSimpleName() && !type.getSimpleName().toLowerCase().endsWith("example")) {

							serviceParamsString.append(type.getSimpleName()).append(" ").append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName()));
							daoParamString.append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName()));
						} else if (null != type.getSimpleName() && type.getSimpleName().toLowerCase().endsWith("example")) {
							exampleType = type;
							serviceParamsString.append(javaFileBody.getUpperDomainName() + "Condition").append(" ").append(javaFileBody.getLowerDomainName() + "Condition");
							daoParamString.append(WordFirstCharChangeUtils.toLowerCaseFirstChar("conditonToExample.getExamlpe()"));
						}
					} else {
						if (null != type.getSimpleName() && !type.getSimpleName().toLowerCase().endsWith("example")) {
							serviceParamsString.append(type.getSimpleName()).append(" ").append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName())).append(", ");
							daoParamString.append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName())).append(",");
						} else if (null != type.getSimpleName() && type.getSimpleName().toLowerCase().endsWith("example")) {
							exampleType = type;
							serviceParamsString.append(javaFileBody.getUpperDomainName() + "Condition").append(" ").append(javaFileBody.getLowerDomainName() + "Condition").append(", ");
							daoParamString.append(WordFirstCharChangeUtils.toLowerCaseFirstChar("conditonToExample.getExamlpe()")).append(",");
						}
					}
					importSet.add(type.getName().substring(0, type.getName().lastIndexOf(".")));
				}
				String serviceParams = serviceParamsString.toString();
				if (serviceParams.endsWith(",")) {
					serviceParams = serviceParams.substring(0, serviceParams.length() - 1);
				}
				List<String> descriptionList = new ArrayList<String>();
				descriptionList.add("/**");
				descriptionList.add(" * @Title: " + clazz.getSimpleName() + ">" + method.getName());
				descriptionList.add(" * @Description: TODO ");
				descriptionList.add(" * @param javaFileBody");
				descriptionList.add(" * @return");
				descriptionList.add(" */");

				Annotation[] annotations = method.getAnnotations();
				List<String> annotationList = new ArrayList<String>();
				for (int j = 0; j < annotations.length; j++) {
					Annotation annotation = annotations[j];
					annotationList.add(annotation.annotationType().getSimpleName());
					importSet.add(annotation.annotationType().getName().substring(0, annotation.annotationType().getName().lastIndexOf(".")));
				}

				String returnType = "ResultStatus";
				String returnTypeGen = method.getReturnType().getSimpleName();

				if (returnTypeGen.equals("int")) {
					returnTypeGen = "Integer";
				} else if (returnTypeGen.equals("long")) {
					returnTypeGen = "Long";
				} else {
					returnTypeGen = returnTypeGen + "<" + javaFileBody.getUpperDomainName() + ">";
				}
				MethodFeature methodFeature = new MethodFeature(descriptionList, annotationList, returnType, returnTypeGen, method.getName(), serviceParams, method.getName(), daoParamString.toString());
				if (null != exampleType) {
					methodFeature.setNewExample(exampleType.getSimpleName() + " " + WordFirstCharChangeUtils.toLowerCaseFirstChar(exampleType.getSimpleName()) + "=new " + exampleType.getSimpleName() + "();");
					methodFeature.setConditionValueToExample("ConditonToExample<" + javaFileBody.getUpperDomainName() + "Condition," + exampleType.getSimpleName() + "> conditonToExample =new ConditonToExample<" + javaFileBody.getUpperDomainName() + "Condition," + exampleType.getSimpleName() + ">(" + WordFirstCharChangeUtils.toLowerCaseFirstChar(javaFileBody.getUpperDomainName()) + "Condition, " + WordFirstCharChangeUtils.toLowerCaseFirstChar(exampleType.getSimpleName()) + ")");
				} else {
					methodFeature.setNewExample("");
					methodFeature.setConditionValueToExample("//没有传递条件参数启用 ,无需转换 条件");
				}
				if (method.getName().toLowerCase().contains("update") || method.getName().toLowerCase().contains("delete") || method.getName().toLowerCase().contains("insert")) {
					methodFeature.setTxMethodHeader("@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)");
					methodFeature.setTxMethodException("TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();");
				} else {
					methodFeature.setTxMethodHeader("//无事务");
					methodFeature.setTxMethodException("//查询无需异常事务回滚");
				}
				methodItemList.add(methodFeature);
			}
			javaFileBody.setMethodFeatureList(methodItemList);
		} else if (javaFileBody.getJavaFileType().getType().equals(JavaFileType.PROVIDER_IMPL.getType())) {
			javFileTemplate.setTemplateFileName("providerImpl.ftl");
			javaFileBody.setPackageName(packageName + ".provider.impl");

			javaDocfile = new File(javaFilePath + SEPARATOR + "provider" + SEPARATOR + "impl");
			List<MethodFeature> methodItemList = new ArrayList<MethodFeature>();
			Class<?> clazz = null;
			try {
				clazz = Class.forName(packageName + ".dao.master." + javaFileBody.getUpperDomainName() + "Mapper");
			} catch (ClassNotFoundException e) {

			}
			Method[] methods = clazz.getMethods();
			Set<String> importSet = new HashSet<String>();

			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				Class<?>[] types = method.getParameterTypes();
				// getGenericReturnType
				StringBuilder providerParamsString = new StringBuilder();
				StringBuilder serviceParamString = new StringBuilder();
				for (int j = 0; j < types.length; j++) {
					Class<?> type = types[j];
					if (j == types.length - 1) {
						if (null != type.getSimpleName() && !type.getSimpleName().toLowerCase().endsWith("example")) {
							providerParamsString.append(type.getSimpleName()).append(" ").append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName()));
							serviceParamString.append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName()));
						} else {
							providerParamsString.append(javaFileBody.getUpperDomainName() + "Condition").append(" ").append(javaFileBody.getLowerDomainName() + "Condition");
							serviceParamString.append(javaFileBody.getLowerDomainName() + "Condition");
						}
					} else {
						if (null != type.getSimpleName() && !type.getSimpleName().toLowerCase().endsWith("example")) {
							providerParamsString.append(type.getSimpleName()).append(" ").append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName())).append(", ");
							serviceParamString.append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName())).append(",");
						} else {
							providerParamsString.append(javaFileBody.getUpperDomainName() + "Condition").append(" ").append(javaFileBody.getLowerDomainName() + "Condition").append(", ");
							serviceParamString.append(javaFileBody.getLowerDomainName() + "Condition").append(",");
						}
					}
				}
				String serviceParams = providerParamsString.toString();
				if (serviceParams.endsWith(",")) {
					serviceParams = serviceParams.substring(0, serviceParams.length() - 1);
				}
				List<String> descriptionList = new ArrayList<String>();
				descriptionList.add("/**");
				descriptionList.add(" * @Title: " + clazz.getSimpleName() + ">" + method.getName());
				descriptionList.add(" * @Description: TODO ");
				descriptionList.add(" * @return");
				descriptionList.add(" */");

				Annotation[] annotations = method.getAnnotations();
				List<String> annotationList = new ArrayList<String>();
				for (int j = 0; j < annotations.length; j++) {
					Annotation annotation = annotations[j];
					annotationList.add(annotation.annotationType().getSimpleName());
					importSet.add(annotation.annotationType().getName().substring(0, annotation.annotationType().getName().lastIndexOf(".")));
				}

				String returnType = "ResultStatus";
				String returnTypeGen = method.getReturnType().getSimpleName();

				if (returnTypeGen.equals("int")) {
					returnTypeGen = "Integer";
				} else if (returnTypeGen.equals("long")) {
					returnTypeGen = "Long";
				} else {
					returnTypeGen = returnTypeGen + "<" + javaFileBody.getUpperDomainName() + ">";
				}
				MethodFeature methodFeature = new MethodFeature(descriptionList, annotationList, returnType, returnTypeGen, method.getName(), serviceParams, method.getName(), serviceParamString.toString());
				methodItemList.add(methodFeature);
			}
			javaFileBody.setMethodFeatureList(methodItemList);
		} else if (javaFileBody.getJavaFileType().getType().equals(JavaFileType.PROVIDER.getType())) {
			javFileTemplate.setTemplateFileName("provider.ftl");
			javaFileBody.setPackageName(packageName + ".provider");
			javaDocfile = new File(javaFilePath + SEPARATOR + "provider");
			List<MethodFeature> methodItemList = new ArrayList<MethodFeature>();
			Class<?> clazz = null;
			try {
				clazz = Class.forName(packageName + ".dao.master." + javaFileBody.getUpperDomainName() + "Mapper");
			} catch (ClassNotFoundException e) {

			}
			Method[] methods = clazz.getMethods();
			Set<String> importSet = new HashSet<String>();

			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				Class<?>[] types = method.getParameterTypes();
				// getGenericReturnType
				StringBuilder providerParamsString = new StringBuilder();
				StringBuilder serviceParamString = new StringBuilder();
				for (int j = 0; j < types.length; j++) {
					Class<?> type = types[j];
					if (j == types.length - 1) {
						if (null != type.getSimpleName() && !type.getSimpleName().toLowerCase().endsWith("example")) {
							providerParamsString.append(type.getSimpleName()).append(" ").append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName()));
							serviceParamString.append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName()));
						} else {
							providerParamsString.append(javaFileBody.getUpperDomainName() + "Condition").append(" ").append(javaFileBody.getLowerDomainName() + "Condition");
							serviceParamString.append(javaFileBody.getUpperDomainName() + "Condition").append(" ").append(javaFileBody.getLowerDomainName() + "Condition");
						}
					} else {
						if (null != type.getSimpleName() && !type.getSimpleName().toLowerCase().endsWith("example")) {
							providerParamsString.append(type.getSimpleName()).append(" ").append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName())).append(", ");
							serviceParamString.append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName())).append(", ");
						} else {
							providerParamsString.append(javaFileBody.getUpperDomainName() + "Condition").append(" ").append(javaFileBody.getLowerDomainName() + "Condition").append(", ");
							serviceParamString.append(javaFileBody.getUpperDomainName() + "Condition").append(" ").append(javaFileBody.getLowerDomainName() + "Condition").append(", ");
						}
					}
//					importSet.add(type.getName().substring(0, type.getName().lastIndexOf(".")));
				}
				String serviceParams = providerParamsString.toString();
				if (serviceParams.endsWith(",")) {
					serviceParams = serviceParams.substring(0, serviceParams.length() - 1);
				}
				List<String> descriptionList = new ArrayList<String>();
				descriptionList.add("/**");
				descriptionList.add(" * @Title: " + clazz.getSimpleName() + ">" + method.getName());
				descriptionList.add(" * @Description: TODO ");
				descriptionList.add(" * @return");
				descriptionList.add(" */");

				Annotation[] annotations = method.getAnnotations();
				List<String> annotationList = new ArrayList<String>();
				for (int j = 0; j < annotations.length; j++) {
					Annotation annotation = annotations[j];
					annotationList.add(annotation.annotationType().getSimpleName());
					importSet.add(annotation.annotationType().getName().substring(0, annotation.annotationType().getName().lastIndexOf(".")));
				}

				String returnType = "ResultStatus";
				String returnTypeGen = method.getReturnType().getSimpleName();

				if (returnTypeGen.equals("int")) {
					returnTypeGen = "Integer";
				} else if (returnTypeGen.equals("long")) {
					returnTypeGen = "Long";
				} else {
					returnTypeGen = returnTypeGen + "<" + javaFileBody.getUpperDomainName() + ">";
				}
				MethodFeature methodFeature = new MethodFeature(descriptionList, annotationList, returnType, returnTypeGen, method.getName(), serviceParams, method.getName(), serviceParamString.toString());
				methodItemList.add(methodFeature);
			}
			javaFileBody.setMethodFeatureList(methodItemList);
		} else if (javaFileBody.getJavaFileType().getType().equals(JavaFileType.TEST.getType())) {
			javFileTemplate.setTemplateFileName("test.ftl");
			// H:\platformMybatisPlugin\master\code\platform-mybatis-plugin\platform.mybatis.plugin.common\src\test\java\com\platform\provider\test
			javaFilePath = userDir + SEPARATOR + "test" + SEPARATOR + "java" + SEPARATOR + packagePath;
			javaDocfile = new File(javaFilePath + SEPARATOR + "provider" + SEPARATOR + "test");
			javaFileBody.setPackageName(packageName + ".provider.test");
			List<MethodFeature> methodItemList = new ArrayList<MethodFeature>();
			Class<?> clazz = null;
			Class<?> conditionClass = null;
			try {
				clazz = Class.forName(packageName + ".dao.master." + javaFileBody.getUpperDomainName() + "Mapper");
				conditionClass = Class.forName(packageName + ".entity." + javaFileBody.getUpperDomainName());
			} catch (ClassNotFoundException e) {

			}
			Method[] methods = clazz.getMethods();

			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];

				Field[] conditionFiled = conditionClass.getDeclaredFields();

				

				Class<?>[] types = method.getParameterTypes();
				// getGenericReturnType
				StringBuilder serviceParamString = new StringBuilder();
				for (int j = 0; j < types.length; j++) {
					Class<?> type = types[j];
					if (j == types.length - 1) {
						if (null != type.getSimpleName() && !type.getSimpleName().toLowerCase().endsWith("example")) {
							
							serviceParamString.append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName()));
						} else {

							serviceParamString.append(javaFileBody.getLowerDomainName() + "Condition");
						}
					} else {
						if (null != type.getSimpleName() && !type.getSimpleName().toLowerCase().endsWith("example")) {
							serviceParamString.append(WordFirstCharChangeUtils.toLowerCaseFirstChar(type.getSimpleName())).append(", ");
						} else {
							serviceParamString.append(javaFileBody.getLowerDomainName() + "Condition").append(", ");
						}
					}
				}

				String returnType = "void";

				MethodFeature methodFeature = new MethodFeature(null, null, returnType, null, method.getName(), null, method.getName(), serviceParamString.toString());
				ConditionFeature feature = null;
				String typeo = null;
				List<ConditionFeature> conditonList = new ArrayList<ConditionFeature>();
				for (int k = 0; k < conditionFiled.length; k++) {
					Field field = conditionFiled[k];
					if (field.getName().equals("serialVersionUID")) {
						continue;
					}
					feature = new ConditionFeature();
					feature.setFieldName(field.getName());
					typeo = field.getType().getSimpleName();

					if (typeo.equals("int")) {
						typeo = "Integer";
					} else if (typeo.equals("long")) {
						typeo = "Long";
					}
					feature.setFieldType(typeo);
					feature.setCondition(WordFirstCharChangeUtils.toUpperCaseFirstChar(field.getName()));
					conditonList.add(feature);
				}
				
				
				for (int j = 0; j < types.length; j++) {
					Class<?> type = types[j];
					if (null != type.getSimpleName() && type.getSimpleName().toLowerCase().endsWith("example")) {
						methodFeature.setConditionFeature(conditonList);
					}else {
						methodFeature.setConditionFeature(new ArrayList<ConditionFeature>());
					}
				}

				methodItemList.add(methodFeature);
			}
			javaFileBody.setMethodFeatureList(methodItemList);

		}

		if (javaDocfile.exists() && !javaDocfile.isDirectory()) {
			javaDocfile.mkdir();
		}
		javFileTemplate.setTemplatePath(templatePath);
		javFileTemplate.setFileBody(javaFileBody);
		;
		javFileTemplate.setJavaFilePath(javaDocfile.getPath());
		javFileTemplate.setCharacterCoding("UTF-8");
		return javFileTemplate;
	}
}