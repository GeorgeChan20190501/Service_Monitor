package com.cognizant.ams.bean;

import java.util.ArrayList;
import java.util.List;

public class SysMenuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysMenuExample() {
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

        public Criteria andNodeCodeIsNull() {
            addCriterion("node_code is null");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIsNotNull() {
            addCriterion("node_code is not null");
            return (Criteria) this;
        }

        public Criteria andNodeCodeEqualTo(String value) {
            addCriterion("node_code =", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotEqualTo(String value) {
            addCriterion("node_code <>", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeGreaterThan(String value) {
            addCriterion("node_code >", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("node_code >=", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLessThan(String value) {
            addCriterion("node_code <", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("node_code <=", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLike(String value) {
            addCriterion("node_code like", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotLike(String value) {
            addCriterion("node_code not like", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIn(List<String> values) {
            addCriterion("node_code in", values, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotIn(List<String> values) {
            addCriterion("node_code not in", values, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeBetween(String value1, String value2) {
            addCriterion("node_code between", value1, value2, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotBetween(String value1, String value2) {
            addCriterion("node_code not between", value1, value2, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andParentNodeCodeIsNull() {
            addCriterion("parent_node_code is null");
            return (Criteria) this;
        }

        public Criteria andParentNodeCodeIsNotNull() {
            addCriterion("parent_node_code is not null");
            return (Criteria) this;
        }

        public Criteria andParentNodeCodeEqualTo(String value) {
            addCriterion("parent_node_code =", value, "parentNodeCode");
            return (Criteria) this;
        }

        public Criteria andParentNodeCodeNotEqualTo(String value) {
            addCriterion("parent_node_code <>", value, "parentNodeCode");
            return (Criteria) this;
        }

        public Criteria andParentNodeCodeGreaterThan(String value) {
            addCriterion("parent_node_code >", value, "parentNodeCode");
            return (Criteria) this;
        }

        public Criteria andParentNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("parent_node_code >=", value, "parentNodeCode");
            return (Criteria) this;
        }

        public Criteria andParentNodeCodeLessThan(String value) {
            addCriterion("parent_node_code <", value, "parentNodeCode");
            return (Criteria) this;
        }

        public Criteria andParentNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("parent_node_code <=", value, "parentNodeCode");
            return (Criteria) this;
        }

        public Criteria andParentNodeCodeLike(String value) {
            addCriterion("parent_node_code like", value, "parentNodeCode");
            return (Criteria) this;
        }

        public Criteria andParentNodeCodeNotLike(String value) {
            addCriterion("parent_node_code not like", value, "parentNodeCode");
            return (Criteria) this;
        }

        public Criteria andParentNodeCodeIn(List<String> values) {
            addCriterion("parent_node_code in", values, "parentNodeCode");
            return (Criteria) this;
        }

        public Criteria andParentNodeCodeNotIn(List<String> values) {
            addCriterion("parent_node_code not in", values, "parentNodeCode");
            return (Criteria) this;
        }

        public Criteria andParentNodeCodeBetween(String value1, String value2) {
            addCriterion("parent_node_code between", value1, value2, "parentNodeCode");
            return (Criteria) this;
        }

        public Criteria andParentNodeCodeNotBetween(String value1, String value2) {
            addCriterion("parent_node_code not between", value1, value2, "parentNodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNull() {
            addCriterion("node_name is null");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNotNull() {
            addCriterion("node_name is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNameEqualTo(String value) {
            addCriterion("node_name =", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotEqualTo(String value) {
            addCriterion("node_name <>", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThan(String value) {
            addCriterion("node_name >", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("node_name >=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThan(String value) {
            addCriterion("node_name <", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThanOrEqualTo(String value) {
            addCriterion("node_name <=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLike(String value) {
            addCriterion("node_name like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotLike(String value) {
            addCriterion("node_name not like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameIn(List<String> values) {
            addCriterion("node_name in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotIn(List<String> values) {
            addCriterion("node_name not in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameBetween(String value1, String value2) {
            addCriterion("node_name between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotBetween(String value1, String value2) {
            addCriterion("node_name not between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andChildNumIsNull() {
            addCriterion("child_num is null");
            return (Criteria) this;
        }

        public Criteria andChildNumIsNotNull() {
            addCriterion("child_num is not null");
            return (Criteria) this;
        }

        public Criteria andChildNumEqualTo(String value) {
            addCriterion("child_num =", value, "childNum");
            return (Criteria) this;
        }

        public Criteria andChildNumNotEqualTo(String value) {
            addCriterion("child_num <>", value, "childNum");
            return (Criteria) this;
        }

        public Criteria andChildNumGreaterThan(String value) {
            addCriterion("child_num >", value, "childNum");
            return (Criteria) this;
        }

        public Criteria andChildNumGreaterThanOrEqualTo(String value) {
            addCriterion("child_num >=", value, "childNum");
            return (Criteria) this;
        }

        public Criteria andChildNumLessThan(String value) {
            addCriterion("child_num <", value, "childNum");
            return (Criteria) this;
        }

        public Criteria andChildNumLessThanOrEqualTo(String value) {
            addCriterion("child_num <=", value, "childNum");
            return (Criteria) this;
        }

        public Criteria andChildNumLike(String value) {
            addCriterion("child_num like", value, "childNum");
            return (Criteria) this;
        }

        public Criteria andChildNumNotLike(String value) {
            addCriterion("child_num not like", value, "childNum");
            return (Criteria) this;
        }

        public Criteria andChildNumIn(List<String> values) {
            addCriterion("child_num in", values, "childNum");
            return (Criteria) this;
        }

        public Criteria andChildNumNotIn(List<String> values) {
            addCriterion("child_num not in", values, "childNum");
            return (Criteria) this;
        }

        public Criteria andChildNumBetween(String value1, String value2) {
            addCriterion("child_num between", value1, value2, "childNum");
            return (Criteria) this;
        }

        public Criteria andChildNumNotBetween(String value1, String value2) {
            addCriterion("child_num not between", value1, value2, "childNum");
            return (Criteria) this;
        }

        public Criteria andPageUrlIsNull() {
            addCriterion("page_url is null");
            return (Criteria) this;
        }

        public Criteria andPageUrlIsNotNull() {
            addCriterion("page_url is not null");
            return (Criteria) this;
        }

        public Criteria andPageUrlEqualTo(String value) {
            addCriterion("page_url =", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotEqualTo(String value) {
            addCriterion("page_url <>", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlGreaterThan(String value) {
            addCriterion("page_url >", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("page_url >=", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlLessThan(String value) {
            addCriterion("page_url <", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlLessThanOrEqualTo(String value) {
            addCriterion("page_url <=", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlLike(String value) {
            addCriterion("page_url like", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotLike(String value) {
            addCriterion("page_url not like", value, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlIn(List<String> values) {
            addCriterion("page_url in", values, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotIn(List<String> values) {
            addCriterion("page_url not in", values, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlBetween(String value1, String value2) {
            addCriterion("page_url between", value1, value2, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andPageUrlNotBetween(String value1, String value2) {
            addCriterion("page_url not between", value1, value2, "pageUrl");
            return (Criteria) this;
        }

        public Criteria andNodeDescriptionIsNull() {
            addCriterion("node_description is null");
            return (Criteria) this;
        }

        public Criteria andNodeDescriptionIsNotNull() {
            addCriterion("node_description is not null");
            return (Criteria) this;
        }

        public Criteria andNodeDescriptionEqualTo(String value) {
            addCriterion("node_description =", value, "nodeDescription");
            return (Criteria) this;
        }

        public Criteria andNodeDescriptionNotEqualTo(String value) {
            addCriterion("node_description <>", value, "nodeDescription");
            return (Criteria) this;
        }

        public Criteria andNodeDescriptionGreaterThan(String value) {
            addCriterion("node_description >", value, "nodeDescription");
            return (Criteria) this;
        }

        public Criteria andNodeDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("node_description >=", value, "nodeDescription");
            return (Criteria) this;
        }

        public Criteria andNodeDescriptionLessThan(String value) {
            addCriterion("node_description <", value, "nodeDescription");
            return (Criteria) this;
        }

        public Criteria andNodeDescriptionLessThanOrEqualTo(String value) {
            addCriterion("node_description <=", value, "nodeDescription");
            return (Criteria) this;
        }

        public Criteria andNodeDescriptionLike(String value) {
            addCriterion("node_description like", value, "nodeDescription");
            return (Criteria) this;
        }

        public Criteria andNodeDescriptionNotLike(String value) {
            addCriterion("node_description not like", value, "nodeDescription");
            return (Criteria) this;
        }

        public Criteria andNodeDescriptionIn(List<String> values) {
            addCriterion("node_description in", values, "nodeDescription");
            return (Criteria) this;
        }

        public Criteria andNodeDescriptionNotIn(List<String> values) {
            addCriterion("node_description not in", values, "nodeDescription");
            return (Criteria) this;
        }

        public Criteria andNodeDescriptionBetween(String value1, String value2) {
            addCriterion("node_description between", value1, value2, "nodeDescription");
            return (Criteria) this;
        }

        public Criteria andNodeDescriptionNotBetween(String value1, String value2) {
            addCriterion("node_description not between", value1, value2, "nodeDescription");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(String value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(String value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(String value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(String value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(String value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLike(String value) {
            addCriterion("is_deleted like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotLike(String value) {
            addCriterion("is_deleted not like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<String> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<String> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(String value1, String value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(String value1, String value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
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

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(String value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(String value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(String value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(String value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(String value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLike(String value) {
            addCriterion("update_time like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotLike(String value) {
            addCriterion("update_time not like", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<String> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<String> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(String value1, String value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(String value1, String value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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