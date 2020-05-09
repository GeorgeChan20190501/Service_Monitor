package com.cognizant.ams.bean;

public class SmApplist {
    private Integer id;

    private String appId;

    private String appName;

    private String appDescrib;

    private String appOwner;

    private String ownerEmail;

    private String appMaintenance;

    private String maintenanceEmail;

    private String appUrl1;

    private String appUrl2;

    private String appUrl3;

    private String isDeleted;

    private String createTime;

    private String updateTime;

    private String chk;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getAppDescrib() {
        return appDescrib;
    }

    public void setAppDescrib(String appDescrib) {
        this.appDescrib = appDescrib == null ? null : appDescrib.trim();
    }

    public String getAppOwner() {
        return appOwner;
    }

    public void setAppOwner(String appOwner) {
        this.appOwner = appOwner == null ? null : appOwner.trim();
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail == null ? null : ownerEmail.trim();
    }

    public String getAppMaintenance() {
        return appMaintenance;
    }

    public void setAppMaintenance(String appMaintenance) {
        this.appMaintenance = appMaintenance == null ? null : appMaintenance.trim();
    }

    public String getMaintenanceEmail() {
        return maintenanceEmail;
    }

    public void setMaintenanceEmail(String maintenanceEmail) {
        this.maintenanceEmail = maintenanceEmail == null ? null : maintenanceEmail.trim();
    }

    public String getAppUrl1() {
        return appUrl1;
    }

    public void setAppUrl1(String appUrl1) {
        this.appUrl1 = appUrl1 == null ? null : appUrl1.trim();
    }

    public String getAppUrl2() {
        return appUrl2;
    }

    public void setAppUrl2(String appUrl2) {
        this.appUrl2 = appUrl2 == null ? null : appUrl2.trim();
    }

    public String getAppUrl3() {
        return appUrl3;
    }

    public void setAppUrl3(String appUrl3) {
        this.appUrl3 = appUrl3 == null ? null : appUrl3.trim();
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getChk() {
        return chk;
    }

    public void setChk(String chk) {
        this.chk = chk == null ? null : chk.trim();
    }
}