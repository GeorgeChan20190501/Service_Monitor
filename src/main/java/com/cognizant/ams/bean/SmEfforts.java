package com.cognizant.ams.bean;

public class SmEfforts {
    private Integer id;

    private String userid;

    private String workday;

    private String tasktype;

    private String eaiCode;

    private String ticketNumber;

    private String effortsHours;

    private String createTime;

    private String chk;

    private String chk1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getWorkday() {
        return workday;
    }

    public void setWorkday(String workday) {
        this.workday = workday == null ? null : workday.trim();
    }

    public String getTasktype() {
        return tasktype;
    }

    public void setTasktype(String tasktype) {
        this.tasktype = tasktype == null ? null : tasktype.trim();
    }

    public String getEaiCode() {
        return eaiCode;
    }

    public void setEaiCode(String eaiCode) {
        this.eaiCode = eaiCode == null ? null : eaiCode.trim();
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber == null ? null : ticketNumber.trim();
    }

    public String getEffortsHours() {
        return effortsHours;
    }

    public void setEffortsHours(String string) {
        this.effortsHours = string;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getChk() {
        return chk;
    }

    public void setChk(String chk) {
        this.chk = chk == null ? null : chk.trim();
    }

    public String getChk1() {
        return chk1;
    }

    public void setChk1(String chk1) {
        this.chk1 = chk1 == null ? null : chk1.trim();
    }
}