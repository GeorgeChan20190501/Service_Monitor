package com.cognizant.ams.bean;

public class SmSn {
    private Integer id;

    private String ticketNo;

    private String appName;

    private String incidentState;

    private String assignTo;

    private String priority;

    private String caller;

    private String assignmentGroup;

    private String createTime;

    private String wipTime;

    private String pendingTime;

    private String resolvedTime;

    private String slaFlag;

    private String chk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo == null ? null : ticketNo.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getIncidentState() {
        return incidentState;
    }

    public void setIncidentState(String incidentState) {
        this.incidentState = incidentState == null ? null : incidentState.trim();
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo == null ? null : assignTo.trim();
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller == null ? null : caller.trim();
    }

    public String getAssignmentGroup() {
        return assignmentGroup;
    }

    public void setAssignmentGroup(String assignmentGroup) {
        this.assignmentGroup = assignmentGroup == null ? null : assignmentGroup.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getWipTime() {
        return wipTime;
    }

    public void setWipTime(String wipTime) {
        this.wipTime = wipTime == null ? null : wipTime.trim();
    }

    public String getPendingTime() {
        return pendingTime;
    }

    public void setPendingTime(String pendingTime) {
        this.pendingTime = pendingTime == null ? null : pendingTime.trim();
    }

    public String getResolvedTime() {
        return resolvedTime;
    }

    public void setResolvedTime(String resolvedTime) {
        this.resolvedTime = resolvedTime == null ? null : resolvedTime.trim();
    }

    public String getSlaFlag() {
        return slaFlag;
    }

    public void setSlaFlag(String slaFlag) {
        this.slaFlag = slaFlag == null ? null : slaFlag.trim();
    }

    public String getChk() {
        return chk;
    }

    public void setChk(String chk) {
        this.chk = chk == null ? null : chk.trim();
    }
}