package com.cognizant.ams.bean;

public class Organization {
    private Integer id;

    private Integer parentid;

    private String orgname;

    private String orgcode;

    private String orgcodepath;

    private String secondorgcode;

    private Integer sortid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname == null ? null : orgname.trim();
    }

    public String getOrgcode() {
        return orgcode;
    }

    public void setOrgcode(String orgcode) {
        this.orgcode = orgcode == null ? null : orgcode.trim();
    }

    public String getOrgcodepath() {
        return orgcodepath;
    }

    public void setOrgcodepath(String orgcodepath) {
        this.orgcodepath = orgcodepath == null ? null : orgcodepath.trim();
    }

    public String getSecondorgcode() {
        return secondorgcode;
    }

    public void setSecondorgcode(String secondorgcode) {
        this.secondorgcode = secondorgcode == null ? null : secondorgcode.trim();
    }

    public Integer getSortid() {
        return sortid;
    }

    public void setSortid(Integer sortid) {
        this.sortid = sortid;
    }
}