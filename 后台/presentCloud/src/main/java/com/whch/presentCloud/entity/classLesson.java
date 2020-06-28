package com.whch.presentCloud.entity;

public class classLesson {
    private Integer classid;

    private String classname;

    private String teachername;

    private Integer teacherid;

    private String type;

    private String master;

    private Integer peopleCount;

    private String location;

    private String classtime;

    private String college;

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername == null ? null : teachername.trim();
    }

    public Integer getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(Integer teacherid) {
        this.teacherid = teacherid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master == null ? null : master.trim();
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getClasstime() {
        return classtime;
    }

    public void setClasstime(String classtime) {
        this.classtime = classtime == null ? null : classtime.trim();
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college == null ? null : college.trim();
    }

    public classLesson(Integer classid, String classname, String teachername, Integer teacherid, String type,
            String master, Integer peopleCount, String location, String classtime, String college) {
        this.classid = classid;
        this.classname = classname;
        this.teachername = teachername;
        this.teacherid = teacherid;
        this.type = type;
        this.master = master;
        this.peopleCount = peopleCount;
        this.location = location;
        this.classtime = classtime;
        this.college = college;
    }
    public classLesson(){}
    public classLesson(Integer classid, String type) {
        this.classid = classid;
        this.type = type;
    }
}