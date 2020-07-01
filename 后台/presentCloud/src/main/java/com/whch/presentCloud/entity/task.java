package com.whch.presentCloud.entity;

import java.util.Date;

public class task {
    private Integer id;

    private Integer userid;

    private Integer grade;

    private String answer;

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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
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

    public task(Integer id, Integer userid, Integer grade, String answer, String gradepoint, String task,
            Integer classid, Integer team, String scoringmethod, Date lastsubmittime) {
        this.id = id;
        this.userid = userid;
        this.grade = grade;
        this.answer = answer;
        this.gradepoint = gradepoint;
        this.task = task;
        this.classid = classid;
        this.team = team;
        this.scoringmethod = scoringmethod;
        this.lastsubmittime = lastsubmittime;
    }

    public task(Integer userid, String gradepoint, String task, Integer classid, Integer grade,
            Date lastsubmittime) {
        this.userid = userid;
        this.gradepoint = gradepoint;
        this.task = task;
        this.classid = classid;
        this.grade = grade;
        this.lastsubmittime = lastsubmittime;
    }
}