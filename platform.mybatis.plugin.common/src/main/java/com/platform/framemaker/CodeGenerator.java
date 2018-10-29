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

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class CodeGenerator {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		String templatePath = "H:/platformMybatisPlugin/master/code/platform-mybatis-plugin/platform.mybatis.plugin.common/src/main/templates";
		PojoTemplate pojoTemplate = new PojoTemplate();
		pojoTemplate.setTemplatePath(templatePath);
		pojoTemplate.setCharacterCoding("UTF-8");
		pojoTemplate.setTemplateFileName("person.ftl");
		JavaFileBody javaFileBody = new JavaFileBody();
		javaFileBody.setPackageName("com.platform.framemaker");
		javaFileBody.setClassName("Person");
		javaFileBody.setImportPackage(null);
		javaFileBody.setAuthor("kangjin.zhao");
		List<Attribute> attrList = new ArrayList<Attribute>();
		attrList.add(new Attribute("id", "java.lang.Long"));
		attrList.add(new Attribute("name", "java.lang.String"));
		attrList.add(new Attribute("age", "java.lang.Integer"));
		attrList.add(new Attribute("hobby", "java.util.List<String>"));
		javaFileBody.setAttrList(attrList);
		pojoTemplate.setJavaFileBody(javaFileBody);
		String javaFilePath = "H:/platformMybatisPlugin/master/code/platform-mybatis-plugin/platform.mybatis.plugin.common/src/main/java/com/platform/framemaker";
		pojoTemplate.setJavaFilePath(javaFilePath);
		new CodeGenerator().gen(pojoTemplate);
	}

	public void gen(PojoTemplate pojoTemplate) {

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
}