package com.platform.mybatis.plugin.common.base;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * @ClassName: BaseEntity   
 * @Description: TODO  
 * @author: Administrator  
 * @date:2018年9月1日 下午7:37:24
 */
public class BaseEntity implements Serializable{
	private static final long serialVersionUID = 8955199657445481544L;
	private Date createDate;
	private Date lastUpdateDate;
	private String createBy;
	private String lastUpdateBy;
	private boolean deleteFlag;
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getLastUpdateBy() {
		return lastUpdateBy;
	}
	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	public boolean isDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
}
