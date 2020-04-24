package com.whch.presentCloud.entity;

import java.util.Date;

public class taskMemory {
    private Integer id;

    private Integer studentid;

    private Integer isparticipate;

    private Integer grade;

    private String anser;

    private String gradepoint;

    private String task;

    private Integer classid;

    private Integer team;

    private String scoringmethod;

    private Date lastsubmittime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public Integer getIsparticipate() {
        return isparticipate;
    }

    public void setIsparticipate(Integer isparticipate) {
        this.isparticipate = isparticipate;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getAnser() {
        return anser;
    }

    public void setAnser(String anser) {
        this.anser = anser == null ? null : anser.trim();
    }

    public String getGradepoint() {
        return gradepoint;
    }

    public void setGradepoint(String gradepoint) {
        this.gradepoint = gradepoint == null ? null : gradepoint.trim();
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task == null ? null : task.trim();
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public Integer getTeam() {
        return team;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }

    public String getScoringmethod() {
        return scoringmethod;
    }

    public void setScoringmethod(String scoringmethod) {
        this.scoringmethod = scoringmethod == null ? null : scoringmethod.trim();
    }

    public Date getLastsubmittime() {
        return lastsubmittime;
    }

    public void setLastsubmittime(Date lastsubmittime) {
        this.lastsubmittime = lastsubmittime;
    }
}