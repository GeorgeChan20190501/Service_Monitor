package com.cognizant.ams.bean;

import java.util.ArrayList;
import java.util.List;

public class SmConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmConfigExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCkeyIsNull() {
            addCriterion("ckey is null");
            return (Criteria) this;
        }

        public Criteria andCkeyIsNotNull() {
            addCriterion("ckey is not null");
            return (Criteria) this;
        }

        public Criteria andCkeyEqualTo(String value) {
            addCriterion("ckey =", value, "ckey");
            return (Criteria) this;
        }

        public Criteria andCkeyNotEqualTo(String value) {
            addCriterion("ckey <>", value, "ckey");
            return (Criteria) this;
        }

        public Criteria andCkeyGreaterThan(String value) {
            addCriterion("ckey >", value, "ckey");
            return (Criteria) this;
        }

        public Criteria andCkeyGreaterThanOrEqualTo(String value) {
            addCriterion("ckey >=", value, "ckey");
            return (Criteria) this;
        }

        public Criteria andCkeyLessThan(String value) {
            addCriterion("ckey <", value, "ckey");
            return (Criteria) this;
        }

        public Criteria andCkeyLessThanOrEqualTo(String value) {
            addCriterion("ckey <=", value, "ckey");
            return (Criteria) this;
        }

        public Criteria andCkeyLike(String value) {
            addCriterion("ckey like", value, "ckey");
            return (Criteria) this;
        }

        public Criteria andCkeyNotLike(String value) {
            addCriterion("ckey not like", value, "ckey");
            return (Criteria) this;
        }

        public Criteria andCkeyIn(List<String> values) {
            addCriterion("ckey in", values, "ckey");
            return (Criteria) this;
        }

        public Criteria andCkeyNotIn(List<String> values) {
            addCriterion("ckey not in", values, "ckey");
            return (Criteria) this;
        }

        public Criteria andCkeyBetween(String value1, String value2) {
            addCriterion("ckey between", value1, value2, "ckey");
            return (Criteria) this;
        }

        public Criteria andCkeyNotBetween(String value1, String value2) {
            addCriterion("ckey not between", value1, value2, "ckey");
            return (Criteria) this;
        }

        public Criteria andCval1IsNull() {
            addCriterion("cval1 is null");
            return (Criteria) this;
        }

        public Criteria andCval1IsNotNull() {
            addCriterion("cval1 is not null");
            return (Criteria) this;
        }

        public Criteria andCval1EqualTo(String value) {
            addCriterion("cval1 =", value, "cval1");
            return (Criteria) this;
        }

        public Criteria andCval1NotEqualTo(String value) {
            addCriterion("cval1 <>", value, "cval1");
            return (Criteria) this;
        }

        public Criteria andCval1GreaterThan(String value) {
            addCriterion("cval1 >", value, "cval1");
            return (Criteria) this;
        }

        public Criteria andCval1GreaterThanOrEqualTo(String value) {
            addCriterion("cval1 >=", value, "cval1");
            return (Criteria) this;
        }

        public Criteria andCval1LessThan(String value) {
            addCriterion("cval1 <", value, "cval1");
            return (Criteria) this;
        }

        public Criteria andCval1LessThanOrEqualTo(String value) {
            addCriterion("cval1 <=", value, "cval1");
            return (Criteria) this;
        }

        public Criteria andCval1Like(String value) {
            addCriterion("cval1 like", value, "cval1");
            return (Criteria) this;
        }

        public Criteria andCval1NotLike(String value) {
            addCriterion("cval1 not like", value, "cval1");
            return (Criteria) this;
        }

        public Criteria andCval1In(List<String> values) {
            addCriterion("cval1 in", values, "cval1");
            return (Criteria) this;
        }

        public Criteria andCval1NotIn(List<String> values) {
            addCriterion("cval1 not in", values, "cval1");
            return (Criteria) this;
        }

        public Criteria andCval1Between(String value1, String value2) {
            addCriterion("cval1 between", value1, value2, "cval1");
            return (Criteria) this;
        }

        public Criteria andCval1NotBetween(String value1, String value2) {
            addCriterion("cval1 not between", value1, value2, "cval1");
            return (Criteria) this;
        }

        public Criteria andCval2IsNull() {
            addCriterion("cval2 is null");
            return (Criteria) this;
        }

        public Criteria andCval2IsNotNull() {
            addCriterion("cval2 is not null");
            return (Criteria) this;
        }

        public Criteria andCval2EqualTo(String value) {
            addCriterion("cval2 =", value, "cval2");
            return (Criteria) this;
        }

        public Criteria andCval2NotEqualTo(String value) {
            addCriterion("cval2 <>", value, "cval2");
            return (Criteria) this;
        }

        public Criteria andCval2GreaterThan(String value) {
            addCriterion("cval2 >", value, "cval2");
            return (Criteria) this;
        }

        public Criteria andCval2GreaterThanOrEqualTo(String value) {
            addCriterion("cval2 >=", value, "cval2");
            return (Criteria) this;
        }

        public Criteria andCval2LessThan(String value) {
            addCriterion("cval2 <", value, "cval2");
            return (Criteria) this;
        }

        public Criteria andCval2LessThanOrEqualTo(String value) {
            addCriterion("cval2 <=", value, "cval2");
            return (Criteria) this;
        }

        public Criteria andCval2Like(String value) {
            addCriterion("cval2 like", value, "cval2");
            return (Criteria) this;
        }

        public Criteria andCval2NotLike(String value) {
            addCriterion("cval2 not like", value, "cval2");
            return (Criteria) this;
        }

        public Criteria andCval2In(List<String> values) {
            addCriterion("cval2 in", values, "cval2");
            return (Criteria) this;
        }

        public Criteria andCval2NotIn(List<String> values) {
            addCriterion("cval2 not in", values, "cval2");
            return (Criteria) this;
        }

        public Criteria andCval2Between(String value1, String value2) {
            addCriterion("cval2 between", value1, value2, "cval2");
            return (Criteria) this;
        }

        public Criteria andCval2NotBetween(String value1, String value2) {
            addCriterion("cval2 not between", value1, value2, "cval2");
            return (Criteria) this;
        }

        public Criteria andCval3IsNull() {
            addCriterion("cval3 is null");
            return (Criteria) this;
        }

        public Criteria andCval3IsNotNull() {
            addCriterion("cval3 is not null");
            return (Criteria) this;
        }

        public Criteria andCval3EqualTo(String value) {
            addCriterion("cval3 =", value, "cval3");
            return (Criteria) this;
        }

        public Criteria andCval3NotEqualTo(String value) {
            addCriterion("cval3 <>", value, "cval3");
            return (Criteria) this;
        }

        public Criteria andCval3GreaterThan(String value) {
            addCriterion("cval3 >", value, "cval3");
            return (Criteria) this;
        }

        public Criteria andCval3GreaterThanOrEqualTo(String value) {
            addCriterion("cval3 >=", value, "cval3");
            return (Criteria) this;
        }

        public Criteria andCval3LessThan(String value) {
            addCriterion("cval3 <", value, "cval3");
            return (Criteria) this;
        }

        public Criteria andCval3LessThanOrEqualTo(String value) {
            addCriterion("cval3 <=", value, "cval3");
            return (Criteria) this;
        }

        public Criteria andCval3Like(String value) {
            addCriterion("cval3 like", value, "cval3");
            return (Criteria) this;
        }

        public Criteria andCval3NotLike(String value) {
            addCriterion("cval3 not like", value, "cval3");
            return (Criteria) this;
        }

        public Criteria andCval3In(List<String> values) {
            addCriterion("cval3 in", values, "cval3");
            return (Criteria) this;
        }

        public Criteria andCval3NotIn(List<String> values) {
            addCriterion("cval3 not in", values, "cval3");
            return (Criteria) this;
        }

        public Criteria andCval3Between(String value1, String value2) {
            addCriterion("cval3 between", value1, value2, "cval3");
            return (Criteria) this;
        }

        public Criteria andCval3NotBetween(String value1, String value2) {
            addCriterion("cval3 not between", value1, value2, "cval3");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(String value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(String value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(String value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(String value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(String value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLike(String value) {
            addCriterion("create_time like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotLike(String value) {
            addCriterion("create_time not like", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<String> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<String> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(String value1, String value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(String value1, String value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andChkIsNull() {
            addCriterion("chk is null");
            return (Criteria) this;
        }

        public Criteria andChkIsNotNull() {
            addCriterion("chk is not null");
            return (Criteria) this;
        }

        public Criteria andChkEqualTo(String value) {
            addCriterion("chk =", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkNotEqualTo(String value) {
            addCriterion("chk <>", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkGreaterThan(String value) {
            addCriterion("chk >", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkGreaterThanOrEqualTo(String value) {
            addCriterion("chk >=", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkLessThan(String value) {
            addCriterion("chk <", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkLessThanOrEqualTo(String value) {
            addCriterion("chk <=", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkLike(String value) {
            addCriterion("chk like", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkNotLike(String value) {
            addCriterion("chk not like", value, "chk");
            return (Criteria) this;
        }

        public Criteria andChkIn(List<String> values) {
            addCriterion("chk in", values, "chk");
            return (Criteria) this;
        }

        public Criteria andChkNotIn(List<String> values) {
            addCriterion("chk not in", values, "chk");
            return (Criteria) this;
        }

        public Criteria andChkBetween(String value1, String value2) {
            addCriterion("chk between", value1, value2, "chk");
            return (Criteria) this;
        }

        public Criteria andChkNotBetween(String value1, String value2) {
            addCriterion("chk not between", value1, value2, "chk");
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