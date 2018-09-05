package com.platform.mybatis.plugin.common.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Document;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * 生成批量删除、更新、插入接口
 * 
 * @ClassName: MapperPlugin
 * @Description: 生成批量删除、更新、插入接口
 * @author: kangjin.zhao@accenture.com
 * @date:2018年9月1日 下午11:42:42
 */
public class PlatformMapperPlugin extends PluginAdapter {
	private Logger logger = LoggerFactory.getLogger(PlatformMapperPlugin.class);

	// 校验 无参数传递 直接返回 设置为true
	@Override
	public boolean validate(List<String> arg0) {
		return true;
	}

	// 生成DAO 每个DAO继承基类DAO,同时向DAO中添加自定义方法
	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));
		//添加批量插入方法
		interfaze.addMethod(batchUpdateByPrimaryKey(introspectedTable));
		interfaze.addMethod(selectByListInDao(introspectedTable));
		return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
	}

	// 向mapping中添加自定义方法
	@Override
	public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {

		// 添加批量更新方法
		batchUpdateByPrimaryKeySelectiveXMLGenerated(document, introspectedTable);
		selectByListInXML(document, introspectedTable);
		return true;
	}

	private Method batchUpdateByPrimaryKey(IntrospectedTable introspectedTable) {
		Method method = new Method("batchUpdateByPrimaryKeySelective");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		method.addParameter(new Parameter(new FullyQualifiedJavaType("java.util.List<" + introspectedTable.getBaseRecordType() + ">"), "list", "@Param(\"list\")"));
		method.addParameter(new Parameter(new FullyQualifiedJavaType(introspectedTable.getExampleType()), "example", "@Param(\"example\")"));
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		return method;
	}
	private Method selectByListInDao(IntrospectedTable introspectedTable) {
		Method method = new Method("selectFieldByList");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		method.addParameter(new Parameter(new FullyQualifiedJavaType("java.lang.String"), "fieldName", "@Param(\"fieldName\")"));
		method.addParameter(new Parameter(new FullyQualifiedJavaType("java.util.List<java.lang.String>"), "paramList", "@Param(\"paramList\")"));
		FullyQualifiedJavaType returnType=new FullyQualifiedJavaType("java.util.List<" + introspectedTable.getBaseRecordType() + ">");
		method.setReturnType(returnType);
		context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
		return method;
	}
	private boolean selectByListInXML(Document document, IntrospectedTable introspectedTable) {
		XmlElement parentElement = document.getRootElement();
		XmlElement select = new XmlElement("select");
		select.addAttribute(new Attribute("id", "selectFieldByList"));
		select.addAttribute(new Attribute("resultMap","BaseResultMap"));
		select.addElement(new TextElement(" select "));
		select.addElement(new TextElement("<include refid=\"Base_Column_List\"/>"));
		select.addElement(new TextElement(" from "+introspectedTable.getFullyQualifiedTableNameAtRuntime()+" t " ));
		
		
		select.addElement(new TextElement("	where 1=1 "));
		select.addElement(new TextElement("		<if test=\"fieldName != null\">"));
		select.addElement(new TextElement("			and t.${fieldName} in "));
		select.addElement(new TextElement("				<foreach collection=\"paramList\" item=\"item\" open=\"(\" close=\")\" separator=\",\">"));
		select.addElement(new TextElement("					#{item,jdbcType=VARCHAR}"));
		select.addElement(new TextElement("				</foreach>"));
		select.addElement(new TextElement("		</if>"));
		parentElement.addElement(select);
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}
	// 生成mapping 拼装 sql
	public boolean batchUpdateByPrimaryKeySelectiveXMLGenerated(Document document, IntrospectedTable introspectedTable) {
		XmlElement parentElement = document.getRootElement();

		XmlElement update = new XmlElement("update");
		update.addAttribute(new Attribute("id", "batchUpdateByPrimaryKeySelective"));
		update.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
		update.addElement(new TextElement("<foreach collection=\"list\" item=\"item\" separator=\";\">"));
		update.addElement(new TextElement("	update " + introspectedTable.getFullyQualifiedTableNameAtRuntime()));
		update.addElement(new TextElement("	<set>"));
		String baseResultMapStr=getBaseResultMapStr(parentElement);
		if(null!=baseResultMapStr) {
			List<Map<String, String>> list = getField2Propertie(baseResultMapStr);
			logger.info("columnListlist:" + JSON.toJSONString(list));
			list.forEach((map) -> {
				update.addElement(new TextElement("		<if test=\"item." + map.get("propertie") + " != null\">"));
				update.addElement(new TextElement("			" + map.get("fieldName") + " = #{item." + map.get("propertie") + ",jdbcType=" + map.get("type") + "},"));
				update.addElement(new TextElement("		</if>"));
			});
		}
		update.addElement(new TextElement("	</set>"));
		update.addElement(new TextElement("	<if test=\"_parameter != null\">"));
		update.addElement(new TextElement("		<include refid=\"Update_By_Example_Where_Clause\" />"));
		update.addElement(new TextElement("	</if>"));
		update.addElement(new TextElement("</foreach>"));
		parentElement.addElement(update);
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}
	//获取baseResultMap
	private String getBaseResultMapStr(XmlElement parentElement) {
		List<Element> elements = parentElement.getElements();
		for (int i = 0; i < elements.size(); i++) {
			if (i == 0) {
				Element elementItem = elements.get(i);
				return elementItem.getFormattedContent(0);
			}
		}
		return null;
	}
	
	//通过打印结果调试出来 字段，属性，类型的方法
	private List<Map<String, String>> getField2Propertie(String str) {
		try {
			str = str.replaceAll("\\r\\n", "");
			str = str.replaceAll("<!--.{0,}-->", "");
			str = str.replaceAll("<resultMap.*?>", "").trim();
			str = str.replaceAll("</resultMap>", "").trim();
			String[] columns = str.split("  ");
			Map<String, String> columnMap = null;
			List<Map<String, String>> columnList = new ArrayList<Map<String, String>>();

			for (int i = 0; i < columns.length; i++) {
				String item = columns[i];
				String[] it = item.split("\"");
				if (it[0].equals("<result column=")) {
					columnMap = new HashMap<String, String>();
					columnMap.put("fieldName", it[1]);
					columnMap.put("type", it[3]);
					columnMap.put("propertie", it[5]);
					columnList.add(columnMap);
				} 
			}
			logger.info("columnList:" + JSON.toJSONString(columnList));
			return columnList;
		} catch (Exception e) {
			logger.error("PlatformMapperPlugin>getField2Propertie>e:" + e);
			throw e;
		}
	}
}