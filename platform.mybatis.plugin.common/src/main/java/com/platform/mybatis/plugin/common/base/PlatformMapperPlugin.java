package com.platform.mybatis.plugin.common.base;

import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
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
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;

/**
 * 生成批量删除、更新、插入接口
 * 
 * @ClassName: MapperPlugin
 * @Description: 生成批量删除、更新、插入接口
 * @author: kangjin.zhao@accenture.com
 * @date:2018年9月1日 下午11:42:42
 */
public class PlatformMapperPlugin extends PluginAdapter {
	// 标识 是否继承BaseDao 默认不继承 false
	private boolean isBase = false;

	// 校验 无参数传递 直接返回 设置为true
	@Override
	public boolean validate(List<String> arg0) {
		return true;
	}

	//生成DAO 每个DAO继承基类DAO,同时向DAO中添加自定义方法
	@Override
	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		if (isBase) {
			FullyQualifiedJavaType fqjt = new FullyQualifiedJavaType("BaseDao<" + introspectedTable.getBaseRecordType() + ">");
			FullyQualifiedJavaType imp = new FullyQualifiedJavaType("com.sl.api.common.base.BaseDao");
			// 添加 extends BaseDao<User>
			interfaze.addSuperInterface(fqjt);
			// 添加import common.BaseDao;
			interfaze.addImportedType(imp);
			interfaze.getMethods().clear();
		} else {
			interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Param"));
			// 在DAO中添加自定义方法(一) 逻辑批量删除
			interfaze.addMethod(delRecordsByLogic(introspectedTable));
			// 在DAO中添加自定义方法(二) 真实批量删除
			interfaze.addMethod(delRecords(introspectedTable));
		}
		return super.clientGenerated(interfaze, topLevelClass, introspectedTable);
	}


	//向mapping中添加自定义方法
	@Override
	public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {

		// 添加自定义sql
		sqlXMLGenerated(document, introspectedTable);
		// 添加自定义方法(一)
		methodXMLGenerated_one(document, introspectedTable);
		// 添加自定义方法(二)
		methodXMLGenerated_two(document, introspectedTable);
		// 添加自定义方法(三)
		methodXMLGenerated_three(document, introspectedTable);
		// 添加自定义方法(四)
		methodXMLGenerated_four(document, introspectedTable);

		return true;
	}

	// 对应于xml文件中的自定义方法 在DAO中添加自定义方法(一) 逻辑批量删除
	private Method delRecordsByLogic(IntrospectedTable introspectedTable) {
		Method m = new Method("delRecordsByLogic");
		m.setVisibility(JavaVisibility.PRIVATE);
		m.setReturnType(FullyQualifiedJavaType.getIntInstance());
		m.addParameter(new Parameter(new FullyQualifiedJavaType("Integer"), "delFlag", "@Param(\"delFlag\")"));
		m.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "ids", "@Param(\"ids\")"));
		context.getCommentGenerator().addGeneralMethodComment(m, introspectedTable);
		return m;
	}

	// 对应于xml文件中的自定义方法 在DAO中添加自定义方法(二) 真实批量删除
	private Method delRecords(IntrospectedTable introspectedTable) {
		Method m = new Method("delRecords");
		m.setVisibility(JavaVisibility.PRIVATE);
		m.setReturnType(FullyQualifiedJavaType.getIntInstance());
		m.addParameter(new Parameter(new FullyQualifiedJavaType("String"), "ids", "@Param(\"ids\")"));
		context.getCommentGenerator().addGeneralMethodComment(m, introspectedTable);
		return m;
	}


	// 生成mapping 添加自定义sql Base_Where_List
	public boolean sqlXMLGenerated(Document document, IntrospectedTable introspectedTable) {
		XmlElement parentElement = document.getRootElement();
		XmlElement sql = new XmlElement("sql");
		sql.addAttribute(new Attribute("id", "Base_Where_List"));
		XmlElement where = new XmlElement("where");
		// 加入 逻辑删除 del_flag标识 根据选择是否添加
		where.addElement(new TextElement(" DEL_FLAG != 1 "));
		StringBuilder sb = new StringBuilder();
		for (IntrospectedColumn introspectedColumn : introspectedTable.getNonPrimaryKeyColumns()) {
			XmlElement isNotNullElement = new XmlElement("if");
			sb.setLength(0);
			sb.append(introspectedColumn.getJavaProperty() + " != null");
			sb.append(" and ");
			sb.append(introspectedColumn.getJavaProperty() + " != ''");
			isNotNullElement.addAttribute(new Attribute("test", sb.toString()));
			where.addElement(isNotNullElement);

			sb.setLength(0);
			sb.append(" and ");
			sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
			sb.append(" = "); //$NON-NLS-1$
			sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
			isNotNullElement.addElement(new TextElement(sb.toString()));
		}
		sql.addElement(where);
		parentElement.addElement(sql);
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}

	// 生成mapping 添加自定义方法(一) 条件查询列表记录 findRecords
	public boolean methodXMLGenerated_one(Document document, IntrospectedTable introspectedTable) {
		XmlElement parentElement = document.getRootElement();
		XmlElement select = new XmlElement("select");
		select.addAttribute(new Attribute("id", "findRecords"));
		select.addAttribute(new Attribute("resultMap", "BaseResultMap"));
		select.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
		select.addElement(new TextElement(" select "));
		XmlElement include1 = new XmlElement("include");
		include1.addAttribute(new Attribute("refid", "Base_Column_List"));
		select.addElement(include1);
		select.addElement(new TextElement(" from " + introspectedTable.getFullyQualifiedTableNameAtRuntime()));

		XmlElement include2 = new XmlElement("include");
		include2.addAttribute(new Attribute("refid", "Base_Where_List"));
		select.addElement(include2);
		select.addElement(new TextElement("ORDER BY ID DESC <if test=\"pageSize!=-1\"> LIMIT #{pageNo,jdbcType=INTEGER}, #{pageSize,jdbcType=INTEGER}</if>"));
		parentElement.addElement(select);
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}

	// 生成mapping 添加自定义方法(二)条件查询列表记录总数 findRecordsCount
	public boolean methodXMLGenerated_two(Document document, IntrospectedTable introspectedTable) {
		XmlElement parentElement = document.getRootElement();
		XmlElement selectCount = new XmlElement("select");
		selectCount.addAttribute(new Attribute("id", "findRecordsCount"));
		selectCount.addAttribute(new Attribute("resultType", "java.lang.Long"));
		selectCount.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
		selectCount.addElement(new TextElement("select count(1) from " + introspectedTable.getFullyQualifiedTableNameAtRuntime()));

		XmlElement include = new XmlElement("include");
		include.addAttribute(new Attribute("refid", "Base_Where_List"));
		selectCount.addElement(include);
		parentElement.addElement(selectCount);
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}

	// 生成mapping 添加自定义方法(三) 真实批量删除
	public boolean methodXMLGenerated_three(Document document, IntrospectedTable introspectedTable) {
		XmlElement parentElement = document.getRootElement();
		XmlElement deleteByIds = new XmlElement("delete");
		deleteByIds.addAttribute(new Attribute("id", "delRecords"));
		deleteByIds.addAttribute(new Attribute("parameterType", "java.lang.String"));
		deleteByIds.addElement(new TextElement("delete from " + introspectedTable.getFullyQualifiedTableNameAtRuntime() + " where id IN(${ids})"));
		parentElement.addElement(deleteByIds);
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}

	// 生成mapping 添加自定义方法(四) 逻辑批量删除
	public boolean methodXMLGenerated_four(Document document, IntrospectedTable introspectedTable) {
		XmlElement parentElement = document.getRootElement();
		XmlElement deleteByIds = new XmlElement("update");
		deleteByIds.addAttribute(new Attribute("id", "delRecordsByLogic"));
		deleteByIds.addAttribute(new Attribute("parameterType", "java.lang.String"));
		deleteByIds.addElement(new TextElement("update " + introspectedTable.getFullyQualifiedTableNameAtRuntime() + "set DEL_FLAG=#{delFlag,jdbcType=INTEGER} where id IN(${ids})"));
		parentElement.addElement(deleteByIds);
		return super.sqlMapDocumentGenerated(document, introspectedTable);
	}
}