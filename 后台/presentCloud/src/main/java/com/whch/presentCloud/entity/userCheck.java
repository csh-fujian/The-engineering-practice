package com.whch.presentCloud.entity;

import java.util.Date;

public class userCheck {
    private Integer id;

    private Integer fkUserinfoUsercheckId;

    private Integer type;

    private Integer thirdparty;

    private String identifier;

    private String passwordtoken;

    private Date creationdate;

    private Integer creater;

    private Date modificationdate;

    private String modifier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFkUserinfoUsercheckId() {
        return fkUserinfoUsercheckId;
    }

    public void setFkUserinfoUsercheckId(Integer fkUserinfoUsercheckId) {
        this.fkUserinfoUsercheckId = fkUserinfoUsercheckId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getThirdparty() {
        return thirdparty;
    }

    public void setThirdparty(Integer thirdparty) {
        this.thirdparty = thirdparty;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier == null ? null : identifier.trim();
    }

    public String getPasswordtoken() {
        return passwordtoken;
    }

    public void setPasswordtoken(String passwordtoken) {
        this.passwordtoken = passwordtoken == null ? null : passwordtoken.trim();
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    public Date getModificationdate() {
        return modificationdate;
    }

    public void setModificationdate(Date modificationdate) {
        this.modificationdate = modificationdate;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }
}