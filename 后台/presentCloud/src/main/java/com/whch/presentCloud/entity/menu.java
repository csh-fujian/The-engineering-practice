package com.whch.presentCloud.entity;

import java.util.Date;

public class menu {
    private Integer id;

    private Integer superiormenunumber;

    private String menuname;

    private String buttonenglishlogo;

    private String buttonchineselogo;

    private Integer ismenu;

    private String creator;

    private Date creationdate;

    private Date modificationdate;

    private String modifier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSuperiormenunumber() {
        return superiormenunumber;
    }

    public void setSuperiormenunumber(Integer superiormenunumber) {
        this.superiormenunumber = superiormenunumber;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getButtonenglishlogo() {
        return buttonenglishlogo;
    }

    public void setButtonenglishlogo(String buttonenglishlogo) {
        this.buttonenglishlogo = buttonenglishlogo == null ? null : buttonenglishlogo.trim();
    }

    public String getButtonchineselogo() {
        return buttonchineselogo;
    }

    public void setButtonchineselogo(String buttonchineselogo) {
        this.buttonchineselogo = buttonchineselogo == null ? null : buttonchineselogo.trim();
    }

    public Integer getIsmenu() {
        return ismenu;
    }

    public void setIsmenu(Integer ismenu) {
        this.ismenu = ismenu;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
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