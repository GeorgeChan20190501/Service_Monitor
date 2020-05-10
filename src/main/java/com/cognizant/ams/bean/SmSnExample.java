package com.cognizant.ams.bean;

import java.util.ArrayList;
import java.util.List;

public class SmSnExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmSnExample() {
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

        public Criteria andTicketNoIsNull() {
            addCriterion("ticket_no is null");
            return (Criteria) this;
        }

        public Criteria andTicketNoIsNotNull() {
            addCriterion("ticket_no is not null");
            return (Criteria) this;
        }

        public Criteria andTicketNoEqualTo(String value) {
            addCriterion("ticket_no =", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoNotEqualTo(String value) {
            addCriterion("ticket_no <>", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoGreaterThan(String value) {
            addCriterion("ticket_no >", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoGreaterThanOrEqualTo(String value) {
            addCriterion("ticket_no >=", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoLessThan(String value) {
            addCriterion("ticket_no <", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoLessThanOrEqualTo(String value) {
            addCriterion("ticket_no <=", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoLike(String value) {
            addCriterion("ticket_no like", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoNotLike(String value) {
            addCriterion("ticket_no not like", value, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoIn(List<String> values) {
            addCriterion("ticket_no in", values, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoNotIn(List<String> values) {
            addCriterion("ticket_no not in", values, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoBetween(String value1, String value2) {
            addCriterion("ticket_no between", value1, value2, "ticketNo");
            return (Criteria) this;
        }

        public Criteria andTicketNoNotBetween(String value1, String value2) {
            addCriterion("ticket_no not between", value1, value2, "ticketNo");
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

        public Criteria andIncidentStateIsNull() {
            addCriterion("incident_state is null");
            return (Criteria) this;
        }

        public Criteria andIncidentStateIsNotNull() {
            addCriterion("incident_state is not null");
            return (Criteria) this;
        }

        public Criteria andIncidentStateEqualTo(String value) {
            addCriterion("incident_state =", value, "incidentState");
            return (Criteria) this;
        }

        public Criteria andIncidentStateNotEqualTo(String value) {
            addCriterion("incident_state <>", value, "incidentState");
            return (Criteria) this;
        }

        public Criteria andIncidentStateGreaterThan(String value) {
            addCriterion("incident_state >", value, "incidentState");
            return (Criteria) this;
        }

        public Criteria andIncidentStateGreaterThanOrEqualTo(String value) {
            addCriterion("incident_state >=", value, "incidentState");
            return (Criteria) this;
        }

        public Criteria andIncidentStateLessThan(String value) {
            addCriterion("incident_state <", value, "incidentState");
            return (Criteria) this;
        }

        public Criteria andIncidentStateLessThanOrEqualTo(String value) {
            addCriterion("incident_state <=", value, "incidentState");
            return (Criteria) this;
        }

        public Criteria andIncidentStateLike(String value) {
            addCriterion("incident_state like", value, "incidentState");
            return (Criteria) this;
        }

        public Criteria andIncidentStateNotLike(String value) {
            addCriterion("incident_state not like", value, "incidentState");
            return (Criteria) this;
        }

        public Criteria andIncidentStateIn(List<String> values) {
            addCriterion("incident_state in", values, "incidentState");
            return (Criteria) this;
        }

        public Criteria andIncidentStateNotIn(List<String> values) {
            addCriterion("incident_state not in", values, "incidentState");
            return (Criteria) this;
        }

        public Criteria andIncidentStateBetween(String value1, String value2) {
            addCriterion("incident_state between", value1, value2, "incidentState");
            return (Criteria) this;
        }

        public Criteria andIncidentStateNotBetween(String value1, String value2) {
            addCriterion("incident_state not between", value1, value2, "incidentState");
            return (Criteria) this;
        }

        public Criteria andAssignToIsNull() {
            addCriterion("assign_to is null");
            return (Criteria) this;
        }

        public Criteria andAssignToIsNotNull() {
            addCriterion("assign_to is not null");
            return (Criteria) this;
        }

        public Criteria andAssignToEqualTo(String value) {
            addCriterion("assign_to =", value, "assignTo");
            return (Criteria) this;
        }

        public Criteria andAssignToNotEqualTo(String value) {
            addCriterion("assign_to <>", value, "assignTo");
            return (Criteria) this;
        }

        public Criteria andAssignToGreaterThan(String value) {
            addCriterion("assign_to >", value, "assignTo");
            return (Criteria) this;
        }

        public Criteria andAssignToGreaterThanOrEqualTo(String value) {
            addCriterion("assign_to >=", value, "assignTo");
            return (Criteria) this;
        }

        public Criteria andAssignToLessThan(String value) {
            addCriterion("assign_to <", value, "assignTo");
            return (Criteria) this;
        }

        public Criteria andAssignToLessThanOrEqualTo(String value) {
            addCriterion("assign_to <=", value, "assignTo");
            return (Criteria) this;
        }

        public Criteria andAssignToLike(String value) {
            addCriterion("assign_to like", value, "assignTo");
            return (Criteria) this;
        }

        public Criteria andAssignToNotLike(String value) {
            addCriterion("assign_to not like", value, "assignTo");
            return (Criteria) this;
        }

        public Criteria andAssignToIn(List<String> values) {
            addCriterion("assign_to in", values, "assignTo");
            return (Criteria) this;
        }

        public Criteria andAssignToNotIn(List<String> values) {
            addCriterion("assign_to not in", values, "assignTo");
            return (Criteria) this;
        }

        public Criteria andAssignToBetween(String value1, String value2) {
            addCriterion("assign_to between", value1, value2, "assignTo");
            return (Criteria) this;
        }

        public Criteria andAssignToNotBetween(String value1, String value2) {
            addCriterion("assign_to not between", value1, value2, "assignTo");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(String value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(String value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(String value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(String value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(String value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(String value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLike(String value) {
            addCriterion("priority like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotLike(String value) {
            addCriterion("priority not like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<String> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<String> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(String value1, String value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(String value1, String value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andCallerIsNull() {
            addCriterion("caller is null");
            return (Criteria) this;
        }

        public Criteria andCallerIsNotNull() {
            addCriterion("caller is not null");
            return (Criteria) this;
        }

        public Criteria andCallerEqualTo(String value) {
            addCriterion("caller =", value, "caller");
            return (Criteria) this;
        }

        public Criteria andCallerNotEqualTo(String value) {
            addCriterion("caller <>", value, "caller");
            return (Criteria) this;
        }

        public Criteria andCallerGreaterThan(String value) {
            addCriterion("caller >", value, "caller");
            return (Criteria) this;
        }

        public Criteria andCallerGreaterThanOrEqualTo(String value) {
            addCriterion("caller >=", value, "caller");
            return (Criteria) this;
        }

        public Criteria andCallerLessThan(String value) {
            addCriterion("caller <", value, "caller");
            return (Criteria) this;
        }

        public Criteria andCallerLessThanOrEqualTo(String value) {
            addCriterion("caller <=", value, "caller");
            return (Criteria) this;
        }

        public Criteria andCallerLike(String value) {
            addCriterion("caller like", value, "caller");
            return (Criteria) this;
        }

        public Criteria andCallerNotLike(String value) {
            addCriterion("caller not like", value, "caller");
            return (Criteria) this;
        }

        public Criteria andCallerIn(List<String> values) {
            addCriterion("caller in", values, "caller");
            return (Criteria) this;
        }

        public Criteria andCallerNotIn(List<String> values) {
            addCriterion("caller not in", values, "caller");
            return (Criteria) this;
        }

        public Criteria andCallerBetween(String value1, String value2) {
            addCriterion("caller between", value1, value2, "caller");
            return (Criteria) this;
        }

        public Criteria andCallerNotBetween(String value1, String value2) {
            addCriterion("caller not between", value1, value2, "caller");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupIsNull() {
            addCriterion("assignment_group is null");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupIsNotNull() {
            addCriterion("assignment_group is not null");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupEqualTo(String value) {
            addCriterion("assignment_group =", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupNotEqualTo(String value) {
            addCriterion("assignment_group <>", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupGreaterThan(String value) {
            addCriterion("assignment_group >", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupGreaterThanOrEqualTo(String value) {
            addCriterion("assignment_group >=", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupLessThan(String value) {
            addCriterion("assignment_group <", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupLessThanOrEqualTo(String value) {
            addCriterion("assignment_group <=", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupLike(String value) {
            addCriterion("assignment_group like", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupNotLike(String value) {
            addCriterion("assignment_group not like", value, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupIn(List<String> values) {
            addCriterion("assignment_group in", values, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupNotIn(List<String> values) {
            addCriterion("assignment_group not in", values, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupBetween(String value1, String value2) {
            addCriterion("assignment_group between", value1, value2, "assignmentGroup");
            return (Criteria) this;
        }

        public Criteria andAssignmentGroupNotBetween(String value1, String value2) {
            addCriterion("assignment_group not between", value1, value2, "assignmentGroup");
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

        public Criteria andWipTimeIsNull() {
            addCriterion("wip_time is null");
            return (Criteria) this;
        }

        public Criteria andWipTimeIsNotNull() {
            addCriterion("wip_time is not null");
            return (Criteria) this;
        }

        public Criteria andWipTimeEqualTo(String value) {
            addCriterion("wip_time =", value, "wipTime");
            return (Criteria) this;
        }

        public Criteria andWipTimeNotEqualTo(String value) {
            addCriterion("wip_time <>", value, "wipTime");
            return (Criteria) this;
        }

        public Criteria andWipTimeGreaterThan(String value) {
            addCriterion("wip_time >", value, "wipTime");
            return (Criteria) this;
        }

        public Criteria andWipTimeGreaterThanOrEqualTo(String value) {
            addCriterion("wip_time >=", value, "wipTime");
            return (Criteria) this;
        }

        public Criteria andWipTimeLessThan(String value) {
            addCriterion("wip_time <", value, "wipTime");
            return (Criteria) this;
        }

        public Criteria andWipTimeLessThanOrEqualTo(String value) {
            addCriterion("wip_time <=", value, "wipTime");
            return (Criteria) this;
        }

        public Criteria andWipTimeLike(String value) {
            addCriterion("wip_time like", value, "wipTime");
            return (Criteria) this;
        }

        public Criteria andWipTimeNotLike(String value) {
            addCriterion("wip_time not like", value, "wipTime");
            return (Criteria) this;
        }

        public Criteria andWipTimeIn(List<String> values) {
            addCriterion("wip_time in", values, "wipTime");
            return (Criteria) this;
        }

        public Criteria andWipTimeNotIn(List<String> values) {
            addCriterion("wip_time not in", values, "wipTime");
            return (Criteria) this;
        }

        public Criteria andWipTimeBetween(String value1, String value2) {
            addCriterion("wip_time between", value1, value2, "wipTime");
            return (Criteria) this;
        }

        public Criteria andWipTimeNotBetween(String value1, String value2) {
            addCriterion("wip_time not between", value1, value2, "wipTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeIsNull() {
            addCriterion("pending_time is null");
            return (Criteria) this;
        }

        public Criteria andPendingTimeIsNotNull() {
            addCriterion("pending_time is not null");
            return (Criteria) this;
        }

        public Criteria andPendingTimeEqualTo(String value) {
            addCriterion("pending_time =", value, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeNotEqualTo(String value) {
            addCriterion("pending_time <>", value, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeGreaterThan(String value) {
            addCriterion("pending_time >", value, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeGreaterThanOrEqualTo(String value) {
            addCriterion("pending_time >=", value, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeLessThan(String value) {
            addCriterion("pending_time <", value, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeLessThanOrEqualTo(String value) {
            addCriterion("pending_time <=", value, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeLike(String value) {
            addCriterion("pending_time like", value, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeNotLike(String value) {
            addCriterion("pending_time not like", value, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeIn(List<String> values) {
            addCriterion("pending_time in", values, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeNotIn(List<String> values) {
            addCriterion("pending_time not in", values, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeBetween(String value1, String value2) {
            addCriterion("pending_time between", value1, value2, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andPendingTimeNotBetween(String value1, String value2) {
            addCriterion("pending_time not between", value1, value2, "pendingTime");
            return (Criteria) this;
        }

        public Criteria andResolvedTimeIsNull() {
            addCriterion("resolved_time is null");
            return (Criteria) this;
        }

        public Criteria andResolvedTimeIsNotNull() {
            addCriterion("resolved_time is not null");
            return (Criteria) this;
        }

        public Criteria andResolvedTimeEqualTo(String value) {
            addCriterion("resolved_time =", value, "resolvedTime");
            return (Criteria) this;
        }

        public Criteria andResolvedTimeNotEqualTo(String value) {
            addCriterion("resolved_time <>", value, "resolvedTime");
            return (Criteria) this;
        }

        public Criteria andResolvedTimeGreaterThan(String value) {
            addCriterion("resolved_time >", value, "resolvedTime");
            return (Criteria) this;
        }

        public Criteria andResolvedTimeGreaterThanOrEqualTo(String value) {
            addCriterion("resolved_time >=", value, "resolvedTime");
            return (Criteria) this;
        }

        public Criteria andResolvedTimeLessThan(String value) {
            addCriterion("resolved_time <", value, "resolvedTime");
            return (Criteria) this;
        }

        public Criteria andResolvedTimeLessThanOrEqualTo(String value) {
            addCriterion("resolved_time <=", value, "resolvedTime");
            return (Criteria) this;
        }

        public Criteria andResolvedTimeLike(String value) {
            addCriterion("resolved_time like", value, "resolvedTime");
            return (Criteria) this;
        }

        public Criteria andResolvedTimeNotLike(String value) {
            addCriterion("resolved_time not like", value, "resolvedTime");
            return (Criteria) this;
        }

        public Criteria andResolvedTimeIn(List<String> values) {
            addCriterion("resolved_time in", values, "resolvedTime");
            return (Criteria) this;
        }

        public Criteria andResolvedTimeNotIn(List<String> values) {
            addCriterion("resolved_time not in", values, "resolvedTime");
            return (Criteria) this;
        }

        public Criteria andResolvedTimeBetween(String value1, String value2) {
            addCriterion("resolved_time between", value1, value2, "resolvedTime");
            return (Criteria) this;
        }

        public Criteria andResolvedTimeNotBetween(String value1, String value2) {
            addCriterion("resolved_time not between", value1, value2, "resolvedTime");
            return (Criteria) this;
        }

        public Criteria andSlaFlagIsNull() {
            addCriterion("SLA_Flag is null");
            return (Criteria) this;
        }

        public Criteria andSlaFlagIsNotNull() {
            addCriterion("SLA_Flag is not null");
            return (Criteria) this;
        }

        public Criteria andSlaFlagEqualTo(String value) {
            addCriterion("SLA_Flag =", value, "slaFlag");
            return (Criteria) this;
        }

        public Criteria andSlaFlagNotEqualTo(String value) {
            addCriterion("SLA_Flag <>", value, "slaFlag");
            return (Criteria) this;
        }

        public Criteria andSlaFlagGreaterThan(String value) {
            addCriterion("SLA_Flag >", value, "slaFlag");
            return (Criteria) this;
        }

        public Criteria andSlaFlagGreaterThanOrEqualTo(String value) {
            addCriterion("SLA_Flag >=", value, "slaFlag");
            return (Criteria) this;
        }

        public Criteria andSlaFlagLessThan(String value) {
            addCriterion("SLA_Flag <", value, "slaFlag");
            return (Criteria) this;
        }

        public Criteria andSlaFlagLessThanOrEqualTo(String value) {
            addCriterion("SLA_Flag <=", value, "slaFlag");
            return (Criteria) this;
        }

        public Criteria andSlaFlagLike(String value) {
            addCriterion("SLA_Flag like", value, "slaFlag");
            return (Criteria) this;
        }

        public Criteria andSlaFlagNotLike(String value) {
            addCriterion("SLA_Flag not like", value, "slaFlag");
            return (Criteria) this;
        }

        public Criteria andSlaFlagIn(List<String> values) {
            addCriterion("SLA_Flag in", values, "slaFlag");
            return (Criteria) this;
        }

        public Criteria andSlaFlagNotIn(List<String> values) {
            addCriterion("SLA_Flag not in", values, "slaFlag");
            return (Criteria) this;
        }

        public Criteria andSlaFlagBetween(String value1, String value2) {
            addCriterion("SLA_Flag between", value1, value2, "slaFlag");
            return (Criteria) this;
        }

        public Criteria andSlaFlagNotBetween(String value1, String value2) {
            addCriterion("SLA_Flag not between", value1, value2, "slaFlag");
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