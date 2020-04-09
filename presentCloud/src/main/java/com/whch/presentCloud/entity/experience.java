package com.whch.presentCloud.entity;

public class experience {
    private String studentid;

    private String name;

    private Integer experiencevalue;

    private Integer classid;

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid == null ? null : studentid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getExperiencevalue() {
        return experiencevalue;
    }

    public void setExperiencevalue(Integer experiencevalue) {
        this.experiencevalue = experiencevalue;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }
}