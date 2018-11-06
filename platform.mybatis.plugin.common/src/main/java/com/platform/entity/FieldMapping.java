package com.platform.entity;

import com.platform.configure.base.BaseEntity;
import java.io.Serializable;
import java.util.Date;

public class FieldMapping extends BaseEntity implements Serializable {
    // tpl_field_mapping.FIELDID
    private String fieldid;

    // tpl_field_mapping.FIELD_CN
    private String fieldCn;

    // tpl_field_mapping.FIELD_EN
    private String fieldEn;

    // tpl_field_mapping.EVENTUALLY_UPDATE_PEOPLE
    private String eventuallyUpdatePeople;

    // tpl_field_mapping.CREATOR
    private String creator;

    // tpl_field_mapping.CREATECREATION_TIME
    private Date createcreationTime;

    // tpl_field_mapping.EVENTUALLY_UPDATE_TIME
    private Date eventuallyUpdateTime;

    // tpl_field_mapping.DELETE_FLAG
    private String deleteFlag;

    //tpl_field_mapping
    private static final long serialVersionUID = 1L;

    public String getFieldid() {
        return fieldid;
    }

    public void setFieldid(String fieldid) {
        this.fieldid = fieldid == null ? null : fieldid.trim();
    }

    public String getFieldCn() {
        return fieldCn;
    }

    public void setFieldCn(String fieldCn) {
        this.fieldCn = fieldCn == null ? null : fieldCn.trim();
    }

    public String getFieldEn() {
        return fieldEn;
    }

    public void setFieldEn(String fieldEn) {
        this.fieldEn = fieldEn == null ? null : fieldEn.trim();
    }

    public String getEventuallyUpdatePeople() {
        return eventuallyUpdatePeople;
    }

    public void setEventuallyUpdatePeople(String eventuallyUpdatePeople) {
        this.eventuallyUpdatePeople = eventuallyUpdatePeople == null ? null : eventuallyUpdatePeople.trim();
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreatecreationTime() {
        return createcreationTime;
    }

    public void setCreatecreationTime(Date createcreationTime) {
        this.createcreationTime = createcreationTime;
    }

    public Date getEventuallyUpdateTime() {
        return eventuallyUpdateTime;
    }

    public void setEventuallyUpdateTime(Date eventuallyUpdateTime) {
        this.eventuallyUpdateTime = eventuallyUpdateTime;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag == null ? null : deleteFlag.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FieldMapping other = (FieldMapping) that;
        return (this.getFieldid() == null ? other.getFieldid() == null : this.getFieldid().equals(other.getFieldid()))
            && (this.getFieldCn() == null ? other.getFieldCn() == null : this.getFieldCn().equals(other.getFieldCn()))
            && (this.getFieldEn() == null ? other.getFieldEn() == null : this.getFieldEn().equals(other.getFieldEn()))
            && (this.getEventuallyUpdatePeople() == null ? other.getEventuallyUpdatePeople() == null : this.getEventuallyUpdatePeople().equals(other.getEventuallyUpdatePeople()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatecreationTime() == null ? other.getCreatecreationTime() == null : this.getCreatecreationTime().equals(other.getCreatecreationTime()))
            && (this.getEventuallyUpdateTime() == null ? other.getEventuallyUpdateTime() == null : this.getEventuallyUpdateTime().equals(other.getEventuallyUpdateTime()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFieldid() == null) ? 0 : getFieldid().hashCode());
        result = prime * result + ((getFieldCn() == null) ? 0 : getFieldCn().hashCode());
        result = prime * result + ((getFieldEn() == null) ? 0 : getFieldEn().hashCode());
        result = prime * result + ((getEventuallyUpdatePeople() == null) ? 0 : getEventuallyUpdatePeople().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatecreationTime() == null) ? 0 : getCreatecreationTime().hashCode());
        result = prime * result + ((getEventuallyUpdateTime() == null) ? 0 : getEventuallyUpdateTime().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fieldid=").append(fieldid);
        sb.append(", fieldCn=").append(fieldCn);
        sb.append(", fieldEn=").append(fieldEn);
        sb.append(", eventuallyUpdatePeople=").append(eventuallyUpdatePeople);
        sb.append(", creator=").append(creator);
        sb.append(", createcreationTime=").append(createcreationTime);
        sb.append(", eventuallyUpdateTime=").append(eventuallyUpdateTime);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}