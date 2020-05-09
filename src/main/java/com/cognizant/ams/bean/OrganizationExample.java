package com.cognizant.ams.bean;

import java.util.ArrayList;
import java.util.List;

public class OrganizationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrganizationExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andParentidIsNull() {
            addCriterion("ParentID is null");
            return (Criteria) this;
        }

        public Criteria andParentidIsNotNull() {
            addCriterion("ParentID is not null");
            return (Criteria) this;
        }

        public Criteria andParentidEqualTo(Integer value) {
            addCriterion("ParentID =", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotEqualTo(Integer value) {
            addCriterion("ParentID <>", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThan(Integer value) {
            addCriterion("ParentID >", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ParentID >=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThan(Integer value) {
            addCriterion("ParentID <", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidLessThanOrEqualTo(Integer value) {
            addCriterion("ParentID <=", value, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidIn(List<Integer> values) {
            addCriterion("ParentID in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotIn(List<Integer> values) {
            addCriterion("ParentID not in", values, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidBetween(Integer value1, Integer value2) {
            addCriterion("ParentID between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andParentidNotBetween(Integer value1, Integer value2) {
            addCriterion("ParentID not between", value1, value2, "parentid");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNull() {
            addCriterion("OrgName is null");
            return (Criteria) this;
        }

        public Criteria andOrgnameIsNotNull() {
            addCriterion("OrgName is not null");
            return (Criteria) this;
        }

        public Criteria andOrgnameEqualTo(String value) {
            addCriterion("OrgName =", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotEqualTo(String value) {
            addCriterion("OrgName <>", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThan(String value) {
            addCriterion("OrgName >", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameGreaterThanOrEqualTo(String value) {
            addCriterion("OrgName >=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThan(String value) {
            addCriterion("OrgName <", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLessThanOrEqualTo(String value) {
            addCriterion("OrgName <=", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameLike(String value) {
            addCriterion("OrgName like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotLike(String value) {
            addCriterion("OrgName not like", value, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameIn(List<String> values) {
            addCriterion("OrgName in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotIn(List<String> values) {
            addCriterion("OrgName not in", values, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameBetween(String value1, String value2) {
            addCriterion("OrgName between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgnameNotBetween(String value1, String value2) {
            addCriterion("OrgName not between", value1, value2, "orgname");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIsNull() {
            addCriterion("OrgCode is null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIsNotNull() {
            addCriterion("OrgCode is not null");
            return (Criteria) this;
        }

        public Criteria andOrgcodeEqualTo(String value) {
            addCriterion("OrgCode =", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotEqualTo(String value) {
            addCriterion("OrgCode <>", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThan(String value) {
            addCriterion("OrgCode >", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeGreaterThanOrEqualTo(String value) {
            addCriterion("OrgCode >=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThan(String value) {
            addCriterion("OrgCode <", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLessThanOrEqualTo(String value) {
            addCriterion("OrgCode <=", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeLike(String value) {
            addCriterion("OrgCode like", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotLike(String value) {
            addCriterion("OrgCode not like", value, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeIn(List<String> values) {
            addCriterion("OrgCode in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotIn(List<String> values) {
            addCriterion("OrgCode not in", values, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeBetween(String value1, String value2) {
            addCriterion("OrgCode between", value1, value2, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodeNotBetween(String value1, String value2) {
            addCriterion("OrgCode not between", value1, value2, "orgcode");
            return (Criteria) this;
        }

        public Criteria andOrgcodepathIsNull() {
            addCriterion("OrgCodePath is null");
            return (Criteria) this;
        }

        public Criteria andOrgcodepathIsNotNull() {
            addCriterion("OrgCodePath is not null");
            return (Criteria) this;
        }

        public Criteria andOrgcodepathEqualTo(String value) {
            addCriterion("OrgCodePath =", value, "orgcodepath");
            return (Criteria) this;
        }

        public Criteria andOrgcodepathNotEqualTo(String value) {
            addCriterion("OrgCodePath <>", value, "orgcodepath");
            return (Criteria) this;
        }

        public Criteria andOrgcodepathGreaterThan(String value) {
            addCriterion("OrgCodePath >", value, "orgcodepath");
            return (Criteria) this;
        }

        public Criteria andOrgcodepathGreaterThanOrEqualTo(String value) {
            addCriterion("OrgCodePath >=", value, "orgcodepath");
            return (Criteria) this;
        }

        public Criteria andOrgcodepathLessThan(String value) {
            addCriterion("OrgCodePath <", value, "orgcodepath");
            return (Criteria) this;
        }

        public Criteria andOrgcodepathLessThanOrEqualTo(String value) {
            addCriterion("OrgCodePath <=", value, "orgcodepath");
            return (Criteria) this;
        }

        public Criteria andOrgcodepathLike(String value) {
            addCriterion("OrgCodePath like", value, "orgcodepath");
            return (Criteria) this;
        }

        public Criteria andOrgcodepathNotLike(String value) {
            addCriterion("OrgCodePath not like", value, "orgcodepath");
            return (Criteria) this;
        }

        public Criteria andOrgcodepathIn(List<String> values) {
            addCriterion("OrgCodePath in", values, "orgcodepath");
            return (Criteria) this;
        }

        public Criteria andOrgcodepathNotIn(List<String> values) {
            addCriterion("OrgCodePath not in", values, "orgcodepath");
            return (Criteria) this;
        }

        public Criteria andOrgcodepathBetween(String value1, String value2) {
            addCriterion("OrgCodePath between", value1, value2, "orgcodepath");
            return (Criteria) this;
        }

        public Criteria andOrgcodepathNotBetween(String value1, String value2) {
            addCriterion("OrgCodePath not between", value1, value2, "orgcodepath");
            return (Criteria) this;
        }

        public Criteria andSecondorgcodeIsNull() {
            addCriterion("SecondOrgCode is null");
            return (Criteria) this;
        }

        public Criteria andSecondorgcodeIsNotNull() {
            addCriterion("SecondOrgCode is not null");
            return (Criteria) this;
        }

        public Criteria andSecondorgcodeEqualTo(String value) {
            addCriterion("SecondOrgCode =", value, "secondorgcode");
            return (Criteria) this;
        }

        public Criteria andSecondorgcodeNotEqualTo(String value) {
            addCriterion("SecondOrgCode <>", value, "secondorgcode");
            return (Criteria) this;
        }

        public Criteria andSecondorgcodeGreaterThan(String value) {
            addCriterion("SecondOrgCode >", value, "secondorgcode");
            return (Criteria) this;
        }

        public Criteria andSecondorgcodeGreaterThanOrEqualTo(String value) {
            addCriterion("SecondOrgCode >=", value, "secondorgcode");
            return (Criteria) this;
        }

        public Criteria andSecondorgcodeLessThan(String value) {
            addCriterion("SecondOrgCode <", value, "secondorgcode");
            return (Criteria) this;
        }

        public Criteria andSecondorgcodeLessThanOrEqualTo(String value) {
            addCriterion("SecondOrgCode <=", value, "secondorgcode");
            return (Criteria) this;
        }

        public Criteria andSecondorgcodeLike(String value) {
            addCriterion("SecondOrgCode like", value, "secondorgcode");
            return (Criteria) this;
        }

        public Criteria andSecondorgcodeNotLike(String value) {
            addCriterion("SecondOrgCode not like", value, "secondorgcode");
            return (Criteria) this;
        }

        public Criteria andSecondorgcodeIn(List<String> values) {
            addCriterion("SecondOrgCode in", values, "secondorgcode");
            return (Criteria) this;
        }

        public Criteria andSecondorgcodeNotIn(List<String> values) {
            addCriterion("SecondOrgCode not in", values, "secondorgcode");
            return (Criteria) this;
        }

        public Criteria andSecondorgcodeBetween(String value1, String value2) {
            addCriterion("SecondOrgCode between", value1, value2, "secondorgcode");
            return (Criteria) this;
        }

        public Criteria andSecondorgcodeNotBetween(String value1, String value2) {
            addCriterion("SecondOrgCode not between", value1, value2, "secondorgcode");
            return (Criteria) this;
        }

        public Criteria andSortidIsNull() {
            addCriterion("SortID is null");
            return (Criteria) this;
        }

        public Criteria andSortidIsNotNull() {
            addCriterion("SortID is not null");
            return (Criteria) this;
        }

        public Criteria andSortidEqualTo(Integer value) {
            addCriterion("SortID =", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidNotEqualTo(Integer value) {
            addCriterion("SortID <>", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidGreaterThan(Integer value) {
            addCriterion("SortID >", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SortID >=", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidLessThan(Integer value) {
            addCriterion("SortID <", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidLessThanOrEqualTo(Integer value) {
            addCriterion("SortID <=", value, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidIn(List<Integer> values) {
            addCriterion("SortID in", values, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidNotIn(List<Integer> values) {
            addCriterion("SortID not in", values, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidBetween(Integer value1, Integer value2) {
            addCriterion("SortID between", value1, value2, "sortid");
            return (Criteria) this;
        }

        public Criteria andSortidNotBetween(Integer value1, Integer value2) {
            addCriterion("SortID not between", value1, value2, "sortid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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