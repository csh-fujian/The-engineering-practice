package com.whch.presentCloud.entity;

public class directoryData {
    private Integer id;

    private String typed;

    private String keyd;

    private String valued;

    private Integer defaultvalued;

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

    public String getKeyd() {
        return keyd;
    }

    public void setKeyd(String keyd) {
        this.keyd = keyd == null ? null : keyd.trim();
    }

    public String getValued() {
        return valued;
    }

    public void setValued(String valued) {
        this.valued = valued == null ? null : valued.trim();
    }

    public Integer getDefaultvalued() {
        return defaultvalued;
    }

    public void setDefaultvalued(Integer defaultvalued) {
        this.defaultvalued = defaultvalued;
    }
}