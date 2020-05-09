package com.cognizant.ams.bean;

public class SmConfig {
    private Integer id;

    private String type;

    private String ckey;

    private String cval1;

    private String cval2;

    private String cval3;

    private String createTime;

    private String chk;

    private String cval4;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey == null ? null : ckey.trim();
    }

    public String getCval1() {
        return cval1;
    }

    public void setCval1(String cval1) {
        this.cval1 = cval1 == null ? null : cval1.trim();
    }

    public String getCval2() {
        return cval2;
    }

    public void setCval2(String cval2) {
        this.cval2 = cval2 == null ? null : cval2.trim();
    }

    public String getCval3() {
        return cval3;
    }

    public void setCval3(String cval3) {
        this.cval3 = cval3 == null ? null : cval3.trim();
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

    public String getCval4() {
        return cval4;
    }

    public void setCval4(String cval4) {
        this.cval4 = cval4 == null ? null : cval4.trim();
    }
}