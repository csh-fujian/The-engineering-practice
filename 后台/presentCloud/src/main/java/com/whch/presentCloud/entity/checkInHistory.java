package com.whch.presentCloud.entity;

import java.util.Date;

public class checkInHistory {
    private Integer id;

    private Date start;

    private Date over;

    private String checkintype;

    private String number;

    private Integer state;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getOver() {
        return over;
    }

    public void setOver(Date over) {
        this.over = over;
    }

    public String getCheckintype() {
        return checkintype;
    }

    public void setCheckintype(String checkintype) {
        this.checkintype = checkintype == null ? null : checkintype.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}