package com.cognizant.ams.bean;

import java.util.ArrayList;
import java.util.List;

public class SmFunExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmFunExample() {
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

        public Criteria andFkeyIsNull() {
            addCriterion("fkey is null");
            return (Criteria) this;
        }

        public Criteria andFkeyIsNotNull() {
            addCriterion("fkey is not null");
            return (Criteria) this;
        }

        public Criteria andFkeyEqualTo(String value) {
            addCriterion("fkey =", value, "fkey");
            return (Criteria) this;
        }

        public Criteria andFkeyNotEqualTo(String value) {
            addCriterion("fkey <>", value, "fkey");
            return (Criteria) this;
        }

        public Criteria andFkeyGreaterThan(String value) {
            addCriterion("fkey >", value, "fkey");
            return (Criteria) this;
        }

        public Criteria andFkeyGreaterThanOrEqualTo(String value) {
            addCriterion("fkey >=", value, "fkey");
            return (Criteria) this;
        }

        public Criteria andFkeyLessThan(String value) {
            addCriterion("fkey <", value, "fkey");
            return (Criteria) this;
        }

        public Criteria andFkeyLessThanOrEqualTo(String value) {
            addCriterion("fkey <=", value, "fkey");
            return (Criteria) this;
        }

        public Criteria andFkeyLike(String value) {
            addCriterion("fkey like", value, "fkey");
            return (Criteria) this;
        }

        public Criteria andFkeyNotLike(String value) {
            addCriterion("fkey not like", value, "fkey");
            return (Criteria) this;
        }

        public Criteria andFkeyIn(List<String> values) {
            addCriterion("fkey in", values, "fkey");
            return (Criteria) this;
        }

        public Criteria andFkeyNotIn(List<String> values) {
            addCriterion("fkey not in", values, "fkey");
            return (Criteria) this;
        }

        public Criteria andFkeyBetween(String value1, String value2) {
            addCriterion("fkey between", value1, value2, "fkey");
            return (Criteria) this;
        }

        public Criteria andFkeyNotBetween(String value1, String value2) {
            addCriterion("fkey not between", value1, value2, "fkey");
            return (Criteria) this;
        }

        public Criteria andFval1IsNull() {
            addCriterion("fval1 is null");
            return (Criteria) this;
        }

        public Criteria andFval1IsNotNull() {
            addCriterion("fval1 is not null");
            return (Criteria) this;
        }

        public Criteria andFval1EqualTo(String value) {
            addCriterion("fval1 =", value, "fval1");
            return (Criteria) this;
        }

        public Criteria andFval1NotEqualTo(String value) {
            addCriterion("fval1 <>", value, "fval1");
            return (Criteria) this;
        }

        public Criteria andFval1GreaterThan(String value) {
            addCriterion("fval1 >", value, "fval1");
            return (Criteria) this;
        }

        public Criteria andFval1GreaterThanOrEqualTo(String value) {
            addCriterion("fval1 >=", value, "fval1");
            return (Criteria) this;
        }

        public Criteria andFval1LessThan(String value) {
            addCriterion("fval1 <", value, "fval1");
            return (Criteria) this;
        }

        public Criteria andFval1LessThanOrEqualTo(String value) {
            addCriterion("fval1 <=", value, "fval1");
            return (Criteria) this;
        }

        public Criteria andFval1Like(String value) {
            addCriterion("fval1 like", value, "fval1");
            return (Criteria) this;
        }

        public Criteria andFval1NotLike(String value) {
            addCriterion("fval1 not like", value, "fval1");
            return (Criteria) this;
        }

        public Criteria andFval1In(List<String> values) {
            addCriterion("fval1 in", values, "fval1");
            return (Criteria) this;
        }

        public Criteria andFval1NotIn(List<String> values) {
            addCriterion("fval1 not in", values, "fval1");
            return (Criteria) this;
        }

        public Criteria andFval1Between(String value1, String value2) {
            addCriterion("fval1 between", value1, value2, "fval1");
            return (Criteria) this;
        }

        public Criteria andFval1NotBetween(String value1, String value2) {
            addCriterion("fval1 not between", value1, value2, "fval1");
            return (Criteria) this;
        }

        public Criteria andFval2IsNull() {
            addCriterion("fval2 is null");
            return (Criteria) this;
        }

        public Criteria andFval2IsNotNull() {
            addCriterion("fval2 is not null");
            return (Criteria) this;
        }

        public Criteria andFval2EqualTo(String value) {
            addCriterion("fval2 =", value, "fval2");
            return (Criteria) this;
        }

        public Criteria andFval2NotEqualTo(String value) {
            addCriterion("fval2 <>", value, "fval2");
            return (Criteria) this;
        }

        public Criteria andFval2GreaterThan(String value) {
            addCriterion("fval2 >", value, "fval2");
            return (Criteria) this;
        }

        public Criteria andFval2GreaterThanOrEqualTo(String value) {
            addCriterion("fval2 >=", value, "fval2");
            return (Criteria) this;
        }

        public Criteria andFval2LessThan(String value) {
            addCriterion("fval2 <", value, "fval2");
            return (Criteria) this;
        }

        public Criteria andFval2LessThanOrEqualTo(String value) {
            addCriterion("fval2 <=", value, "fval2");
            return (Criteria) this;
        }

        public Criteria andFval2Like(String value) {
            addCriterion("fval2 like", value, "fval2");
            return (Criteria) this;
        }

        public Criteria andFval2NotLike(String value) {
            addCriterion("fval2 not like", value, "fval2");
            return (Criteria) this;
        }

        public Criteria andFval2In(List<String> values) {
            addCriterion("fval2 in", values, "fval2");
            return (Criteria) this;
        }

        public Criteria andFval2NotIn(List<String> values) {
            addCriterion("fval2 not in", values, "fval2");
            return (Criteria) this;
        }

        public Criteria andFval2Between(String value1, String value2) {
            addCriterion("fval2 between", value1, value2, "fval2");
            return (Criteria) this;
        }

        public Criteria andFval2NotBetween(String value1, String value2) {
            addCriterion("fval2 not between", value1, value2, "fval2");
            return (Criteria) this;
        }

        public Criteria andFval3IsNull() {
            addCriterion("fval3 is null");
            return (Criteria) this;
        }

        public Criteria andFval3IsNotNull() {
            addCriterion("fval3 is not null");
            return (Criteria) this;
        }

        public Criteria andFval3EqualTo(String value) {
            addCriterion("fval3 =", value, "fval3");
            return (Criteria) this;
        }

        public Criteria andFval3NotEqualTo(String value) {
            addCriterion("fval3 <>", value, "fval3");
            return (Criteria) this;
        }

        public Criteria andFval3GreaterThan(String value) {
            addCriterion("fval3 >", value, "fval3");
            return (Criteria) this;
        }

        public Criteria andFval3GreaterThanOrEqualTo(String value) {
            addCriterion("fval3 >=", value, "fval3");
            return (Criteria) this;
        }

        public Criteria andFval3LessThan(String value) {
            addCriterion("fval3 <", value, "fval3");
            return (Criteria) this;
        }

        public Criteria andFval3LessThanOrEqualTo(String value) {
            addCriterion("fval3 <=", value, "fval3");
            return (Criteria) this;
        }

        public Criteria andFval3Like(String value) {
            addCriterion("fval3 like", value, "fval3");
            return (Criteria) this;
        }

        public Criteria andFval3NotLike(String value) {
            addCriterion("fval3 not like", value, "fval3");
            return (Criteria) this;
        }

        public Criteria andFval3In(List<String> values) {
            addCriterion("fval3 in", values, "fval3");
            return (Criteria) this;
        }

        public Criteria andFval3NotIn(List<String> values) {
            addCriterion("fval3 not in", values, "fval3");
            return (Criteria) this;
        }

        public Criteria andFval3Between(String value1, String value2) {
            addCriterion("fval3 between", value1, value2, "fval3");
            return (Criteria) this;
        }

        public Criteria andFval3NotBetween(String value1, String value2) {
            addCriterion("fval3 not between", value1, value2, "fval3");
            return (Criteria) this;
        }

        public Criteria andFval4IsNull() {
            addCriterion("fval4 is null");
            return (Criteria) this;
        }

        public Criteria andFval4IsNotNull() {
            addCriterion("fval4 is not null");
            return (Criteria) this;
        }

        public Criteria andFval4EqualTo(String value) {
            addCriterion("fval4 =", value, "fval4");
            return (Criteria) this;
        }

        public Criteria andFval4NotEqualTo(String value) {
            addCriterion("fval4 <>", value, "fval4");
            return (Criteria) this;
        }

        public Criteria andFval4GreaterThan(String value) {
            addCriterion("fval4 >", value, "fval4");
            return (Criteria) this;
        }

        public Criteria andFval4GreaterThanOrEqualTo(String value) {
            addCriterion("fval4 >=", value, "fval4");
            return (Criteria) this;
        }

        public Criteria andFval4LessThan(String value) {
            addCriterion("fval4 <", value, "fval4");
            return (Criteria) this;
        }

        public Criteria andFval4LessThanOrEqualTo(String value) {
            addCriterion("fval4 <=", value, "fval4");
            return (Criteria) this;
        }

        public Criteria andFval4Like(String value) {
            addCriterion("fval4 like", value, "fval4");
            return (Criteria) this;
        }

        public Criteria andFval4NotLike(String value) {
            addCriterion("fval4 not like", value, "fval4");
            return (Criteria) this;
        }

        public Criteria andFval4In(List<String> values) {
            addCriterion("fval4 in", values, "fval4");
            return (Criteria) this;
        }

        public Criteria andFval4NotIn(List<String> values) {
            addCriterion("fval4 not in", values, "fval4");
            return (Criteria) this;
        }

        public Criteria andFval4Between(String value1, String value2) {
            addCriterion("fval4 between", value1, value2, "fval4");
            return (Criteria) this;
        }

        public Criteria andFval4NotBetween(String value1, String value2) {
            addCriterion("fval4 not between", value1, value2, "fval4");
            return (Criteria) this;
        }

        public Criteria andFval5IsNull() {
            addCriterion("fval5 is null");
            return (Criteria) this;
        }

        public Criteria andFval5IsNotNull() {
            addCriterion("fval5 is not null");
            return (Criteria) this;
        }

        public Criteria andFval5EqualTo(String value) {
            addCriterion("fval5 =", value, "fval5");
            return (Criteria) this;
        }

        public Criteria andFval5NotEqualTo(String value) {
            addCriterion("fval5 <>", value, "fval5");
            return (Criteria) this;
        }

        public Criteria andFval5GreaterThan(String value) {
            addCriterion("fval5 >", value, "fval5");
            return (Criteria) this;
        }

        public Criteria andFval5GreaterThanOrEqualTo(String value) {
            addCriterion("fval5 >=", value, "fval5");
            return (Criteria) this;
        }

        public Criteria andFval5LessThan(String value) {
            addCriterion("fval5 <", value, "fval5");
            return (Criteria) this;
        }

        public Criteria andFval5LessThanOrEqualTo(String value) {
            addCriterion("fval5 <=", value, "fval5");
            return (Criteria) this;
        }

        public Criteria andFval5Like(String value) {
            addCriterion("fval5 like", value, "fval5");
            return (Criteria) this;
        }

        public Criteria andFval5NotLike(String value) {
            addCriterion("fval5 not like", value, "fval5");
            return (Criteria) this;
        }

        public Criteria andFval5In(List<String> values) {
            addCriterion("fval5 in", values, "fval5");
            return (Criteria) this;
        }

        public Criteria andFval5NotIn(List<String> values) {
            addCriterion("fval5 not in", values, "fval5");
            return (Criteria) this;
        }

        public Criteria andFval5Between(String value1, String value2) {
            addCriterion("fval5 between", value1, value2, "fval5");
            return (Criteria) this;
        }

        public Criteria andFval5NotBetween(String value1, String value2) {
            addCriterion("fval5 not between", value1, value2, "fval5");
            return (Criteria) this;
        }

        public Criteria andFval6IsNull() {
            addCriterion("fval6 is null");
            return (Criteria) this;
        }

        public Criteria andFval6IsNotNull() {
            addCriterion("fval6 is not null");
            return (Criteria) this;
        }

        public Criteria andFval6EqualTo(String value) {
            addCriterion("fval6 =", value, "fval6");
            return (Criteria) this;
        }

        public Criteria andFval6NotEqualTo(String value) {
            addCriterion("fval6 <>", value, "fval6");
            return (Criteria) this;
        }

        public Criteria andFval6GreaterThan(String value) {
            addCriterion("fval6 >", value, "fval6");
            return (Criteria) this;
        }

        public Criteria andFval6GreaterThanOrEqualTo(String value) {
            addCriterion("fval6 >=", value, "fval6");
            return (Criteria) this;
        }

        public Criteria andFval6LessThan(String value) {
            addCriterion("fval6 <", value, "fval6");
            return (Criteria) this;
        }

        public Criteria andFval6LessThanOrEqualTo(String value) {
            addCriterion("fval6 <=", value, "fval6");
            return (Criteria) this;
        }

        public Criteria andFval6Like(String value) {
            addCriterion("fval6 like", value, "fval6");
            return (Criteria) this;
        }

        public Criteria andFval6NotLike(String value) {
            addCriterion("fval6 not like", value, "fval6");
            return (Criteria) this;
        }

        public Criteria andFval6In(List<String> values) {
            addCriterion("fval6 in", values, "fval6");
            return (Criteria) this;
        }

        public Criteria andFval6NotIn(List<String> values) {
            addCriterion("fval6 not in", values, "fval6");
            return (Criteria) this;
        }

        public Criteria andFval6Between(String value1, String value2) {
            addCriterion("fval6 between", value1, value2, "fval6");
            return (Criteria) this;
        }

        public Criteria andFval6NotBetween(String value1, String value2) {
            addCriterion("fval6 not between", value1, value2, "fval6");
            return (Criteria) this;
        }

        public Criteria andFval7IsNull() {
            addCriterion("fval7 is null");
            return (Criteria) this;
        }

        public Criteria andFval7IsNotNull() {
            addCriterion("fval7 is not null");
            return (Criteria) this;
        }

        public Criteria andFval7EqualTo(String value) {
            addCriterion("fval7 =", value, "fval7");
            return (Criteria) this;
        }

        public Criteria andFval7NotEqualTo(String value) {
            addCriterion("fval7 <>", value, "fval7");
            return (Criteria) this;
        }

        public Criteria andFval7GreaterThan(String value) {
            addCriterion("fval7 >", value, "fval7");
            return (Criteria) this;
        }

        public Criteria andFval7GreaterThanOrEqualTo(String value) {
            addCriterion("fval7 >=", value, "fval7");
            return (Criteria) this;
        }

        public Criteria andFval7LessThan(String value) {
            addCriterion("fval7 <", value, "fval7");
            return (Criteria) this;
        }

        public Criteria andFval7LessThanOrEqualTo(String value) {
            addCriterion("fval7 <=", value, "fval7");
            return (Criteria) this;
        }

        public Criteria andFval7Like(String value) {
            addCriterion("fval7 like", value, "fval7");
            return (Criteria) this;
        }

        public Criteria andFval7NotLike(String value) {
            addCriterion("fval7 not like", value, "fval7");
            return (Criteria) this;
        }

        public Criteria andFval7In(List<String> values) {
            addCriterion("fval7 in", values, "fval7");
            return (Criteria) this;
        }

        public Criteria andFval7NotIn(List<String> values) {
            addCriterion("fval7 not in", values, "fval7");
            return (Criteria) this;
        }

        public Criteria andFval7Between(String value1, String value2) {
            addCriterion("fval7 between", value1, value2, "fval7");
            return (Criteria) this;
        }

        public Criteria andFval7NotBetween(String value1, String value2) {
            addCriterion("fval7 not between", value1, value2, "fval7");
            return (Criteria) this;
        }

        public Criteria andFval8IsNull() {
            addCriterion("fval8 is null");
            return (Criteria) this;
        }

        public Criteria andFval8IsNotNull() {
            addCriterion("fval8 is not null");
            return (Criteria) this;
        }

        public Criteria andFval8EqualTo(String value) {
            addCriterion("fval8 =", value, "fval8");
            return (Criteria) this;
        }

        public Criteria andFval8NotEqualTo(String value) {
            addCriterion("fval8 <>", value, "fval8");
            return (Criteria) this;
        }

        public Criteria andFval8GreaterThan(String value) {
            addCriterion("fval8 >", value, "fval8");
            return (Criteria) this;
        }

        public Criteria andFval8GreaterThanOrEqualTo(String value) {
            addCriterion("fval8 >=", value, "fval8");
            return (Criteria) this;
        }

        public Criteria andFval8LessThan(String value) {
            addCriterion("fval8 <", value, "fval8");
            return (Criteria) this;
        }

        public Criteria andFval8LessThanOrEqualTo(String value) {
            addCriterion("fval8 <=", value, "fval8");
            return (Criteria) this;
        }

        public Criteria andFval8Like(String value) {
            addCriterion("fval8 like", value, "fval8");
            return (Criteria) this;
        }

        public Criteria andFval8NotLike(String value) {
            addCriterion("fval8 not like", value, "fval8");
            return (Criteria) this;
        }

        public Criteria andFval8In(List<String> values) {
            addCriterion("fval8 in", values, "fval8");
            return (Criteria) this;
        }

        public Criteria andFval8NotIn(List<String> values) {
            addCriterion("fval8 not in", values, "fval8");
            return (Criteria) this;
        }

        public Criteria andFval8Between(String value1, String value2) {
            addCriterion("fval8 between", value1, value2, "fval8");
            return (Criteria) this;
        }

        public Criteria andFval8NotBetween(String value1, String value2) {
            addCriterion("fval8 not between", value1, value2, "fval8");
            return (Criteria) this;
        }

        public Criteria andFval9IsNull() {
            addCriterion("fval9 is null");
            return (Criteria) this;
        }

        public Criteria andFval9IsNotNull() {
            addCriterion("fval9 is not null");
            return (Criteria) this;
        }

        public Criteria andFval9EqualTo(String value) {
            addCriterion("fval9 =", value, "fval9");
            return (Criteria) this;
        }

        public Criteria andFval9NotEqualTo(String value) {
            addCriterion("fval9 <>", value, "fval9");
            return (Criteria) this;
        }

        public Criteria andFval9GreaterThan(String value) {
            addCriterion("fval9 >", value, "fval9");
            return (Criteria) this;
        }

        public Criteria andFval9GreaterThanOrEqualTo(String value) {
            addCriterion("fval9 >=", value, "fval9");
            return (Criteria) this;
        }

        public Criteria andFval9LessThan(String value) {
            addCriterion("fval9 <", value, "fval9");
            return (Criteria) this;
        }

        public Criteria andFval9LessThanOrEqualTo(String value) {
            addCriterion("fval9 <=", value, "fval9");
            return (Criteria) this;
        }

        public Criteria andFval9Like(String value) {
            addCriterion("fval9 like", value, "fval9");
            return (Criteria) this;
        }

        public Criteria andFval9NotLike(String value) {
            addCriterion("fval9 not like", value, "fval9");
            return (Criteria) this;
        }

        public Criteria andFval9In(List<String> values) {
            addCriterion("fval9 in", values, "fval9");
            return (Criteria) this;
        }

        public Criteria andFval9NotIn(List<String> values) {
            addCriterion("fval9 not in", values, "fval9");
            return (Criteria) this;
        }

        public Criteria andFval9Between(String value1, String value2) {
            addCriterion("fval9 between", value1, value2, "fval9");
            return (Criteria) this;
        }

        public Criteria andFval9NotBetween(String value1, String value2) {
            addCriterion("fval9 not between", value1, value2, "fval9");
            return (Criteria) this;
        }

        public Criteria andFval10IsNull() {
            addCriterion("fval10 is null");
            return (Criteria) this;
        }

        public Criteria andFval10IsNotNull() {
            addCriterion("fval10 is not null");
            return (Criteria) this;
        }

        public Criteria andFval10EqualTo(String value) {
            addCriterion("fval10 =", value, "fval10");
            return (Criteria) this;
        }

        public Criteria andFval10NotEqualTo(String value) {
            addCriterion("fval10 <>", value, "fval10");
            return (Criteria) this;
        }

        public Criteria andFval10GreaterThan(String value) {
            addCriterion("fval10 >", value, "fval10");
            return (Criteria) this;
        }

        public Criteria andFval10GreaterThanOrEqualTo(String value) {
            addCriterion("fval10 >=", value, "fval10");
            return (Criteria) this;
        }

        public Criteria andFval10LessThan(String value) {
            addCriterion("fval10 <", value, "fval10");
            return (Criteria) this;
        }

        public Criteria andFval10LessThanOrEqualTo(String value) {
            addCriterion("fval10 <=", value, "fval10");
            return (Criteria) this;
        }

        public Criteria andFval10Like(String value) {
            addCriterion("fval10 like", value, "fval10");
            return (Criteria) this;
        }

        public Criteria andFval10NotLike(String value) {
            addCriterion("fval10 not like", value, "fval10");
            return (Criteria) this;
        }

        public Criteria andFval10In(List<String> values) {
            addCriterion("fval10 in", values, "fval10");
            return (Criteria) this;
        }

        public Criteria andFval10NotIn(List<String> values) {
            addCriterion("fval10 not in", values, "fval10");
            return (Criteria) this;
        }

        public Criteria andFval10Between(String value1, String value2) {
            addCriterion("fval10 between", value1, value2, "fval10");
            return (Criteria) this;
        }

        public Criteria andFval10NotBetween(String value1, String value2) {
            addCriterion("fval10 not between", value1, value2, "fval10");
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