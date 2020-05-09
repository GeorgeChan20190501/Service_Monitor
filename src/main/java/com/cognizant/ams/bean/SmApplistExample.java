package com.cognizant.ams.bean;

import java.util.ArrayList;
import java.util.List;

public class SmApplistExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmApplistExample() {
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

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("app_name is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("app_name is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("app_name =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("app_name <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("app_name >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("app_name >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("app_name <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("app_name <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("app_name like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("app_name not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("app_name in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("app_name not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("app_name between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("app_name not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppDescribIsNull() {
            addCriterion("app_describ is null");
            return (Criteria) this;
        }

        public Criteria andAppDescribIsNotNull() {
            addCriterion("app_describ is not null");
            return (Criteria) this;
        }

        public Criteria andAppDescribEqualTo(String value) {
            addCriterion("app_describ =", value, "appDescrib");
            return (Criteria) this;
        }

        public Criteria andAppDescribNotEqualTo(String value) {
            addCriterion("app_describ <>", value, "appDescrib");
            return (Criteria) this;
        }

        public Criteria andAppDescribGreaterThan(String value) {
            addCriterion("app_describ >", value, "appDescrib");
            return (Criteria) this;
        }

        public Criteria andAppDescribGreaterThanOrEqualTo(String value) {
            addCriterion("app_describ >=", value, "appDescrib");
            return (Criteria) this;
        }

        public Criteria andAppDescribLessThan(String value) {
            addCriterion("app_describ <", value, "appDescrib");
            return (Criteria) this;
        }

        public Criteria andAppDescribLessThanOrEqualTo(String value) {
            addCriterion("app_describ <=", value, "appDescrib");
            return (Criteria) this;
        }

        public Criteria andAppDescribLike(String value) {
            addCriterion("app_describ like", value, "appDescrib");
            return (Criteria) this;
        }

        public Criteria andAppDescribNotLike(String value) {
            addCriterion("app_describ not like", value, "appDescrib");
            return (Criteria) this;
        }

        public Criteria andAppDescribIn(List<String> values) {
            addCriterion("app_describ in", values, "appDescrib");
            return (Criteria) this;
        }

        public Criteria andAppDescribNotIn(List<String> values) {
            addCriterion("app_describ not in", values, "appDescrib");
            return (Criteria) this;
        }

        public Criteria andAppDescribBetween(String value1, String value2) {
            addCriterion("app_describ between", value1, value2, "appDescrib");
            return (Criteria) this;
        }

        public Criteria andAppDescribNotBetween(String value1, String value2) {
            addCriterion("app_describ not between", value1, value2, "appDescrib");
            return (Criteria) this;
        }

        public Criteria andAppOwnerIsNull() {
            addCriterion("app_owner is null");
            return (Criteria) this;
        }

        public Criteria andAppOwnerIsNotNull() {
            addCriterion("app_owner is not null");
            return (Criteria) this;
        }

        public Criteria andAppOwnerEqualTo(String value) {
            addCriterion("app_owner =", value, "appOwner");
            return (Criteria) this;
        }

        public Criteria andAppOwnerNotEqualTo(String value) {
            addCriterion("app_owner <>", value, "appOwner");
            return (Criteria) this;
        }

        public Criteria andAppOwnerGreaterThan(String value) {
            addCriterion("app_owner >", value, "appOwner");
            return (Criteria) this;
        }

        public Criteria andAppOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("app_owner >=", value, "appOwner");
            return (Criteria) this;
        }

        public Criteria andAppOwnerLessThan(String value) {
            addCriterion("app_owner <", value, "appOwner");
            return (Criteria) this;
        }

        public Criteria andAppOwnerLessThanOrEqualTo(String value) {
            addCriterion("app_owner <=", value, "appOwner");
            return (Criteria) this;
        }

        public Criteria andAppOwnerLike(String value) {
            addCriterion("app_owner like", value, "appOwner");
            return (Criteria) this;
        }

        public Criteria andAppOwnerNotLike(String value) {
            addCriterion("app_owner not like", value, "appOwner");
            return (Criteria) this;
        }

        public Criteria andAppOwnerIn(List<String> values) {
            addCriterion("app_owner in", values, "appOwner");
            return (Criteria) this;
        }

        public Criteria andAppOwnerNotIn(List<String> values) {
            addCriterion("app_owner not in", values, "appOwner");
            return (Criteria) this;
        }

        public Criteria andAppOwnerBetween(String value1, String value2) {
            addCriterion("app_owner between", value1, value2, "appOwner");
            return (Criteria) this;
        }

        public Criteria andAppOwnerNotBetween(String value1, String value2) {
            addCriterion("app_owner not between", value1, value2, "appOwner");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailIsNull() {
            addCriterion("owner_email is null");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailIsNotNull() {
            addCriterion("owner_email is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailEqualTo(String value) {
            addCriterion("owner_email =", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailNotEqualTo(String value) {
            addCriterion("owner_email <>", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailGreaterThan(String value) {
            addCriterion("owner_email >", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailGreaterThanOrEqualTo(String value) {
            addCriterion("owner_email >=", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailLessThan(String value) {
            addCriterion("owner_email <", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailLessThanOrEqualTo(String value) {
            addCriterion("owner_email <=", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailLike(String value) {
            addCriterion("owner_email like", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailNotLike(String value) {
            addCriterion("owner_email not like", value, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailIn(List<String> values) {
            addCriterion("owner_email in", values, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailNotIn(List<String> values) {
            addCriterion("owner_email not in", values, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailBetween(String value1, String value2) {
            addCriterion("owner_email between", value1, value2, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andOwnerEmailNotBetween(String value1, String value2) {
            addCriterion("owner_email not between", value1, value2, "ownerEmail");
            return (Criteria) this;
        }

        public Criteria andAppMaintenanceIsNull() {
            addCriterion("app_maintenance is null");
            return (Criteria) this;
        }

        public Criteria andAppMaintenanceIsNotNull() {
            addCriterion("app_maintenance is not null");
            return (Criteria) this;
        }

        public Criteria andAppMaintenanceEqualTo(String value) {
            addCriterion("app_maintenance =", value, "appMaintenance");
            return (Criteria) this;
        }

        public Criteria andAppMaintenanceNotEqualTo(String value) {
            addCriterion("app_maintenance <>", value, "appMaintenance");
            return (Criteria) this;
        }

        public Criteria andAppMaintenanceGreaterThan(String value) {
            addCriterion("app_maintenance >", value, "appMaintenance");
            return (Criteria) this;
        }

        public Criteria andAppMaintenanceGreaterThanOrEqualTo(String value) {
            addCriterion("app_maintenance >=", value, "appMaintenance");
            return (Criteria) this;
        }

        public Criteria andAppMaintenanceLessThan(String value) {
            addCriterion("app_maintenance <", value, "appMaintenance");
            return (Criteria) this;
        }

        public Criteria andAppMaintenanceLessThanOrEqualTo(String value) {
            addCriterion("app_maintenance <=", value, "appMaintenance");
            return (Criteria) this;
        }

        public Criteria andAppMaintenanceLike(String value) {
            addCriterion("app_maintenance like", value, "appMaintenance");
            return (Criteria) this;
        }

        public Criteria andAppMaintenanceNotLike(String value) {
            addCriterion("app_maintenance not like", value, "appMaintenance");
            return (Criteria) this;
        }

        public Criteria andAppMaintenanceIn(List<String> values) {
            addCriterion("app_maintenance in", values, "appMaintenance");
            return (Criteria) this;
        }

        public Criteria andAppMaintenanceNotIn(List<String> values) {
            addCriterion("app_maintenance not in", values, "appMaintenance");
            return (Criteria) this;
        }

        public Criteria andAppMaintenanceBetween(String value1, String value2) {
            addCriterion("app_maintenance between", value1, value2, "appMaintenance");
            return (Criteria) this;
        }

        public Criteria andAppMaintenanceNotBetween(String value1, String value2) {
            addCriterion("app_maintenance not between", value1, value2, "appMaintenance");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEmailIsNull() {
            addCriterion("maintenance_email is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEmailIsNotNull() {
            addCriterion("maintenance_email is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEmailEqualTo(String value) {
            addCriterion("maintenance_email =", value, "maintenanceEmail");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEmailNotEqualTo(String value) {
            addCriterion("maintenance_email <>", value, "maintenanceEmail");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEmailGreaterThan(String value) {
            addCriterion("maintenance_email >", value, "maintenanceEmail");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEmailGreaterThanOrEqualTo(String value) {
            addCriterion("maintenance_email >=", value, "maintenanceEmail");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEmailLessThan(String value) {
            addCriterion("maintenance_email <", value, "maintenanceEmail");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEmailLessThanOrEqualTo(String value) {
            addCriterion("maintenance_email <=", value, "maintenanceEmail");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEmailLike(String value) {
            addCriterion("maintenance_email like", value, "maintenanceEmail");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEmailNotLike(String value) {
            addCriterion("maintenance_email not like", value, "maintenanceEmail");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEmailIn(List<String> values) {
            addCriterion("maintenance_email in", values, "maintenanceEmail");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEmailNotIn(List<String> values) {
            addCriterion("maintenance_email not in", values, "maintenanceEmail");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEmailBetween(String value1, String value2) {
            addCriterion("maintenance_email between", value1, value2, "maintenanceEmail");
            return (Criteria) this;
        }

        public Criteria andMaintenanceEmailNotBetween(String value1, String value2) {
            addCriterion("maintenance_email not between", value1, value2, "maintenanceEmail");
            return (Criteria) this;
        }

        public Criteria andAppUrl1IsNull() {
            addCriterion("app_url1 is null");
            return (Criteria) this;
        }

        public Criteria andAppUrl1IsNotNull() {
            addCriterion("app_url1 is not null");
            return (Criteria) this;
        }

        public Criteria andAppUrl1EqualTo(String value) {
            addCriterion("app_url1 =", value, "appUrl1");
            return (Criteria) this;
        }

        public Criteria andAppUrl1NotEqualTo(String value) {
            addCriterion("app_url1 <>", value, "appUrl1");
            return (Criteria) this;
        }

        public Criteria andAppUrl1GreaterThan(String value) {
            addCriterion("app_url1 >", value, "appUrl1");
            return (Criteria) this;
        }

        public Criteria andAppUrl1GreaterThanOrEqualTo(String value) {
            addCriterion("app_url1 >=", value, "appUrl1");
            return (Criteria) this;
        }

        public Criteria andAppUrl1LessThan(String value) {
            addCriterion("app_url1 <", value, "appUrl1");
            return (Criteria) this;
        }

        public Criteria andAppUrl1LessThanOrEqualTo(String value) {
            addCriterion("app_url1 <=", value, "appUrl1");
            return (Criteria) this;
        }

        public Criteria andAppUrl1Like(String value) {
            addCriterion("app_url1 like", value, "appUrl1");
            return (Criteria) this;
        }

        public Criteria andAppUrl1NotLike(String value) {
            addCriterion("app_url1 not like", value, "appUrl1");
            return (Criteria) this;
        }

        public Criteria andAppUrl1In(List<String> values) {
            addCriterion("app_url1 in", values, "appUrl1");
            return (Criteria) this;
        }

        public Criteria andAppUrl1NotIn(List<String> values) {
            addCriterion("app_url1 not in", values, "appUrl1");
            return (Criteria) this;
        }

        public Criteria andAppUrl1Between(String value1, String value2) {
            addCriterion("app_url1 between", value1, value2, "appUrl1");
            return (Criteria) this;
        }

        public Criteria andAppUrl1NotBetween(String value1, String value2) {
            addCriterion("app_url1 not between", value1, value2, "appUrl1");
            return (Criteria) this;
        }

        public Criteria andAppUrl2IsNull() {
            addCriterion("app_url2 is null");
            return (Criteria) this;
        }

        public Criteria andAppUrl2IsNotNull() {
            addCriterion("app_url2 is not null");
            return (Criteria) this;
        }

        public Criteria andAppUrl2EqualTo(String value) {
            addCriterion("app_url2 =", value, "appUrl2");
            return (Criteria) this;
        }

        public Criteria andAppUrl2NotEqualTo(String value) {
            addCriterion("app_url2 <>", value, "appUrl2");
            return (Criteria) this;
        }

        public Criteria andAppUrl2GreaterThan(String value) {
            addCriterion("app_url2 >", value, "appUrl2");
            return (Criteria) this;
        }

        public Criteria andAppUrl2GreaterThanOrEqualTo(String value) {
            addCriterion("app_url2 >=", value, "appUrl2");
            return (Criteria) this;
        }

        public Criteria andAppUrl2LessThan(String value) {
            addCriterion("app_url2 <", value, "appUrl2");
            return (Criteria) this;
        }

        public Criteria andAppUrl2LessThanOrEqualTo(String value) {
            addCriterion("app_url2 <=", value, "appUrl2");
            return (Criteria) this;
        }

        public Criteria andAppUrl2Like(String value) {
            addCriterion("app_url2 like", value, "appUrl2");
            return (Criteria) this;
        }

        public Criteria andAppUrl2NotLike(String value) {
            addCriterion("app_url2 not like", value, "appUrl2");
            return (Criteria) this;
        }

        public Criteria andAppUrl2In(List<String> values) {
            addCriterion("app_url2 in", values, "appUrl2");
            return (Criteria) this;
        }

        public Criteria andAppUrl2NotIn(List<String> values) {
            addCriterion("app_url2 not in", values, "appUrl2");
            return (Criteria) this;
        }

        public Criteria andAppUrl2Between(String value1, String value2) {
            addCriterion("app_url2 between", value1, value2, "appUrl2");
            return (Criteria) this;
        }

        public Criteria andAppUrl2NotBetween(String value1, String value2) {
            addCriterion("app_url2 not between", value1, value2, "appUrl2");
            return (Criteria) this;
        }

        public Criteria andAppUrl3IsNull() {
            addCriterion("app_url3 is null");
            return (Criteria) this;
        }

        public Criteria andAppUrl3IsNotNull() {
            addCriterion("app_url3 is not null");
            return (Criteria) this;
        }

        public Criteria andAppUrl3EqualTo(String value) {
            addCriterion("app_url3 =", value, "appUrl3");
            return (Criteria) this;
        }

        public Criteria andAppUrl3NotEqualTo(String value) {
            addCriterion("app_url3 <>", value, "appUrl3");
            return (Criteria) this;
        }

        public Criteria andAppUrl3GreaterThan(String value) {
            addCriterion("app_url3 >", value, "appUrl3");
            return (Criteria) this;
        }

        public Criteria andAppUrl3GreaterThanOrEqualTo(String value) {
            addCriterion("app_url3 >=", value, "appUrl3");
            return (Criteria) this;
        }

        public Criteria andAppUrl3LessThan(String value) {
            addCriterion("app_url3 <", value, "appUrl3");
            return (Criteria) this;
        }

        public Criteria andAppUrl3LessThanOrEqualTo(String value) {
            addCriterion("app_url3 <=", value, "appUrl3");
            return (Criteria) this;
        }

        public Criteria andAppUrl3Like(String value) {
            addCriterion("app_url3 like", value, "appUrl3");
            return (Criteria) this;
        }

        public Criteria andAppUrl3NotLike(String value) {
            addCriterion("app_url3 not like", value, "appUrl3");
            return (Criteria) this;
        }

        public Criteria andAppUrl3In(List<String> values) {
            addCriterion("app_url3 in", values, "appUrl3");
            return (Criteria) this;
        }

        public Criteria andAppUrl3NotIn(List<String> values) {
            addCriterion("app_url3 not in", values, "appUrl3");
            return (Criteria) this;
        }

        public Criteria andAppUrl3Between(String value1, String value2) {
            addCriterion("app_url3 between", value1, value2, "appUrl3");
            return (Criteria) this;
        }

        public Criteria andAppUrl3NotBetween(String value1, String value2) {
            addCriterion("app_url3 not between", value1, value2, "appUrl3");
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