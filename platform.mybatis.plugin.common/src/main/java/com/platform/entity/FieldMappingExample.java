package com.platform.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FieldMappingExample {
    //tpl_field_mapping
    protected String orderByClause;

    //tpl_field_mapping
    protected boolean distinct;

    //tpl_field_mapping
    protected List<Criteria> oredCriteria;

    public FieldMappingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tpl_field_mapping
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andFieldidIsNull() {
            addCriterion("FIELDID is null");
            return (Criteria) this;
        }

        public Criteria andFieldidIsNotNull() {
            addCriterion("FIELDID is not null");
            return (Criteria) this;
        }

        public Criteria andFieldidEqualTo(String value) {
            addCriterion("FIELDID =", value, "fieldid");
            return (Criteria) this;
        }

        public Criteria andFieldidNotEqualTo(String value) {
            addCriterion("FIELDID <>", value, "fieldid");
            return (Criteria) this;
        }

        public Criteria andFieldidGreaterThan(String value) {
            addCriterion("FIELDID >", value, "fieldid");
            return (Criteria) this;
        }

        public Criteria andFieldidGreaterThanOrEqualTo(String value) {
            addCriterion("FIELDID >=", value, "fieldid");
            return (Criteria) this;
        }

        public Criteria andFieldidLessThan(String value) {
            addCriterion("FIELDID <", value, "fieldid");
            return (Criteria) this;
        }

        public Criteria andFieldidLessThanOrEqualTo(String value) {
            addCriterion("FIELDID <=", value, "fieldid");
            return (Criteria) this;
        }

        public Criteria andFieldidLike(String value) {
            addCriterion("FIELDID like", value, "fieldid");
            return (Criteria) this;
        }

        public Criteria andFieldidNotLike(String value) {
            addCriterion("FIELDID not like", value, "fieldid");
            return (Criteria) this;
        }

        public Criteria andFieldidIn(List<String> values) {
            addCriterion("FIELDID in", values, "fieldid");
            return (Criteria) this;
        }

        public Criteria andFieldidNotIn(List<String> values) {
            addCriterion("FIELDID not in", values, "fieldid");
            return (Criteria) this;
        }

        public Criteria andFieldidBetween(String value1, String value2) {
            addCriterion("FIELDID between", value1, value2, "fieldid");
            return (Criteria) this;
        }

        public Criteria andFieldidNotBetween(String value1, String value2) {
            addCriterion("FIELDID not between", value1, value2, "fieldid");
            return (Criteria) this;
        }

        public Criteria andFieldCnIsNull() {
            addCriterion("FIELD_CN is null");
            return (Criteria) this;
        }

        public Criteria andFieldCnIsNotNull() {
            addCriterion("FIELD_CN is not null");
            return (Criteria) this;
        }

        public Criteria andFieldCnEqualTo(String value) {
            addCriterion("FIELD_CN =", value, "fieldCn");
            return (Criteria) this;
        }

        public Criteria andFieldCnNotEqualTo(String value) {
            addCriterion("FIELD_CN <>", value, "fieldCn");
            return (Criteria) this;
        }

        public Criteria andFieldCnGreaterThan(String value) {
            addCriterion("FIELD_CN >", value, "fieldCn");
            return (Criteria) this;
        }

        public Criteria andFieldCnGreaterThanOrEqualTo(String value) {
            addCriterion("FIELD_CN >=", value, "fieldCn");
            return (Criteria) this;
        }

        public Criteria andFieldCnLessThan(String value) {
            addCriterion("FIELD_CN <", value, "fieldCn");
            return (Criteria) this;
        }

        public Criteria andFieldCnLessThanOrEqualTo(String value) {
            addCriterion("FIELD_CN <=", value, "fieldCn");
            return (Criteria) this;
        }

        public Criteria andFieldCnLike(String value) {
            addCriterion("FIELD_CN like", value, "fieldCn");
            return (Criteria) this;
        }

        public Criteria andFieldCnNotLike(String value) {
            addCriterion("FIELD_CN not like", value, "fieldCn");
            return (Criteria) this;
        }

        public Criteria andFieldCnIn(List<String> values) {
            addCriterion("FIELD_CN in", values, "fieldCn");
            return (Criteria) this;
        }

        public Criteria andFieldCnNotIn(List<String> values) {
            addCriterion("FIELD_CN not in", values, "fieldCn");
            return (Criteria) this;
        }

        public Criteria andFieldCnBetween(String value1, String value2) {
            addCriterion("FIELD_CN between", value1, value2, "fieldCn");
            return (Criteria) this;
        }

        public Criteria andFieldCnNotBetween(String value1, String value2) {
            addCriterion("FIELD_CN not between", value1, value2, "fieldCn");
            return (Criteria) this;
        }

        public Criteria andFieldEnIsNull() {
            addCriterion("FIELD_EN is null");
            return (Criteria) this;
        }

        public Criteria andFieldEnIsNotNull() {
            addCriterion("FIELD_EN is not null");
            return (Criteria) this;
        }

        public Criteria andFieldEnEqualTo(String value) {
            addCriterion("FIELD_EN =", value, "fieldEn");
            return (Criteria) this;
        }

        public Criteria andFieldEnNotEqualTo(String value) {
            addCriterion("FIELD_EN <>", value, "fieldEn");
            return (Criteria) this;
        }

        public Criteria andFieldEnGreaterThan(String value) {
            addCriterion("FIELD_EN >", value, "fieldEn");
            return (Criteria) this;
        }

        public Criteria andFieldEnGreaterThanOrEqualTo(String value) {
            addCriterion("FIELD_EN >=", value, "fieldEn");
            return (Criteria) this;
        }

        public Criteria andFieldEnLessThan(String value) {
            addCriterion("FIELD_EN <", value, "fieldEn");
            return (Criteria) this;
        }

        public Criteria andFieldEnLessThanOrEqualTo(String value) {
            addCriterion("FIELD_EN <=", value, "fieldEn");
            return (Criteria) this;
        }

        public Criteria andFieldEnLike(String value) {
            addCriterion("FIELD_EN like", value, "fieldEn");
            return (Criteria) this;
        }

        public Criteria andFieldEnNotLike(String value) {
            addCriterion("FIELD_EN not like", value, "fieldEn");
            return (Criteria) this;
        }

        public Criteria andFieldEnIn(List<String> values) {
            addCriterion("FIELD_EN in", values, "fieldEn");
            return (Criteria) this;
        }

        public Criteria andFieldEnNotIn(List<String> values) {
            addCriterion("FIELD_EN not in", values, "fieldEn");
            return (Criteria) this;
        }

        public Criteria andFieldEnBetween(String value1, String value2) {
            addCriterion("FIELD_EN between", value1, value2, "fieldEn");
            return (Criteria) this;
        }

        public Criteria andFieldEnNotBetween(String value1, String value2) {
            addCriterion("FIELD_EN not between", value1, value2, "fieldEn");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdatePeopleIsNull() {
            addCriterion("EVENTUALLY_UPDATE_PEOPLE is null");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdatePeopleIsNotNull() {
            addCriterion("EVENTUALLY_UPDATE_PEOPLE is not null");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdatePeopleEqualTo(String value) {
            addCriterion("EVENTUALLY_UPDATE_PEOPLE =", value, "eventuallyUpdatePeople");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdatePeopleNotEqualTo(String value) {
            addCriterion("EVENTUALLY_UPDATE_PEOPLE <>", value, "eventuallyUpdatePeople");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdatePeopleGreaterThan(String value) {
            addCriterion("EVENTUALLY_UPDATE_PEOPLE >", value, "eventuallyUpdatePeople");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdatePeopleGreaterThanOrEqualTo(String value) {
            addCriterion("EVENTUALLY_UPDATE_PEOPLE >=", value, "eventuallyUpdatePeople");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdatePeopleLessThan(String value) {
            addCriterion("EVENTUALLY_UPDATE_PEOPLE <", value, "eventuallyUpdatePeople");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdatePeopleLessThanOrEqualTo(String value) {
            addCriterion("EVENTUALLY_UPDATE_PEOPLE <=", value, "eventuallyUpdatePeople");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdatePeopleLike(String value) {
            addCriterion("EVENTUALLY_UPDATE_PEOPLE like", value, "eventuallyUpdatePeople");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdatePeopleNotLike(String value) {
            addCriterion("EVENTUALLY_UPDATE_PEOPLE not like", value, "eventuallyUpdatePeople");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdatePeopleIn(List<String> values) {
            addCriterion("EVENTUALLY_UPDATE_PEOPLE in", values, "eventuallyUpdatePeople");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdatePeopleNotIn(List<String> values) {
            addCriterion("EVENTUALLY_UPDATE_PEOPLE not in", values, "eventuallyUpdatePeople");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdatePeopleBetween(String value1, String value2) {
            addCriterion("EVENTUALLY_UPDATE_PEOPLE between", value1, value2, "eventuallyUpdatePeople");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdatePeopleNotBetween(String value1, String value2) {
            addCriterion("EVENTUALLY_UPDATE_PEOPLE not between", value1, value2, "eventuallyUpdatePeople");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("CREATOR is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("CREATOR is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("CREATOR =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("CREATOR <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("CREATOR >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("CREATOR >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("CREATOR <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("CREATOR <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("CREATOR like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("CREATOR not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("CREATOR in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("CREATOR not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("CREATOR between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("CREATOR not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatecreationTimeIsNull() {
            addCriterion("CREATECREATION_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreatecreationTimeIsNotNull() {
            addCriterion("CREATECREATION_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreatecreationTimeEqualTo(Date value) {
            addCriterion("CREATECREATION_TIME =", value, "createcreationTime");
            return (Criteria) this;
        }

        public Criteria andCreatecreationTimeNotEqualTo(Date value) {
            addCriterion("CREATECREATION_TIME <>", value, "createcreationTime");
            return (Criteria) this;
        }

        public Criteria andCreatecreationTimeGreaterThan(Date value) {
            addCriterion("CREATECREATION_TIME >", value, "createcreationTime");
            return (Criteria) this;
        }

        public Criteria andCreatecreationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATECREATION_TIME >=", value, "createcreationTime");
            return (Criteria) this;
        }

        public Criteria andCreatecreationTimeLessThan(Date value) {
            addCriterion("CREATECREATION_TIME <", value, "createcreationTime");
            return (Criteria) this;
        }

        public Criteria andCreatecreationTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATECREATION_TIME <=", value, "createcreationTime");
            return (Criteria) this;
        }

        public Criteria andCreatecreationTimeIn(List<Date> values) {
            addCriterion("CREATECREATION_TIME in", values, "createcreationTime");
            return (Criteria) this;
        }

        public Criteria andCreatecreationTimeNotIn(List<Date> values) {
            addCriterion("CREATECREATION_TIME not in", values, "createcreationTime");
            return (Criteria) this;
        }

        public Criteria andCreatecreationTimeBetween(Date value1, Date value2) {
            addCriterion("CREATECREATION_TIME between", value1, value2, "createcreationTime");
            return (Criteria) this;
        }

        public Criteria andCreatecreationTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATECREATION_TIME not between", value1, value2, "createcreationTime");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdateTimeIsNull() {
            addCriterion("EVENTUALLY_UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdateTimeIsNotNull() {
            addCriterion("EVENTUALLY_UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdateTimeEqualTo(Date value) {
            addCriterion("EVENTUALLY_UPDATE_TIME =", value, "eventuallyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdateTimeNotEqualTo(Date value) {
            addCriterion("EVENTUALLY_UPDATE_TIME <>", value, "eventuallyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdateTimeGreaterThan(Date value) {
            addCriterion("EVENTUALLY_UPDATE_TIME >", value, "eventuallyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EVENTUALLY_UPDATE_TIME >=", value, "eventuallyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdateTimeLessThan(Date value) {
            addCriterion("EVENTUALLY_UPDATE_TIME <", value, "eventuallyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("EVENTUALLY_UPDATE_TIME <=", value, "eventuallyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdateTimeIn(List<Date> values) {
            addCriterion("EVENTUALLY_UPDATE_TIME in", values, "eventuallyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdateTimeNotIn(List<Date> values) {
            addCriterion("EVENTUALLY_UPDATE_TIME not in", values, "eventuallyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("EVENTUALLY_UPDATE_TIME between", value1, value2, "eventuallyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andEventuallyUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("EVENTUALLY_UPDATE_TIME not between", value1, value2, "eventuallyUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("DELETE_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("DELETE_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(String value) {
            addCriterion("DELETE_FLAG =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(String value) {
            addCriterion("DELETE_FLAG <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(String value) {
            addCriterion("DELETE_FLAG >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(String value) {
            addCriterion("DELETE_FLAG >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(String value) {
            addCriterion("DELETE_FLAG <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(String value) {
            addCriterion("DELETE_FLAG <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLike(String value) {
            addCriterion("DELETE_FLAG like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotLike(String value) {
            addCriterion("DELETE_FLAG not like", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<String> values) {
            addCriterion("DELETE_FLAG in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<String> values) {
            addCriterion("DELETE_FLAG not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(String value1, String value2) {
            addCriterion("DELETE_FLAG between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(String value1, String value2) {
            addCriterion("DELETE_FLAG not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tpl_field_mapping
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table tpl_field_mapping
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}