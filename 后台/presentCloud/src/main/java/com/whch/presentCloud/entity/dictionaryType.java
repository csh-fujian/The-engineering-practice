package com.whch.presentCloud.entity;

import java.util.Date;

public class dictionaryType {
    private Integer id;

    private String typed;

    private String type;

    private String description;

    private Integer creator;

    private Date creatordate;

    private Date modificationdate;

    private Integer modifier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTyped() {
        return typed;
    }

    public void setTyped(String typed) {
        this.typed = typed == null ? null : typed.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getCreatordate() {
        return creatordate;
    }

    public void setCreatordate(Date creatordate) {
        this.creatordate = creatordate;
    }

    public Date getModificationdate() {
        return modificationdate;
    }

    public void setModificationdate(Date modificationdate) {
        this.modificationdate = modificationdate;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(Integer modifier) {
        this.modifier = modifier;
    }
}