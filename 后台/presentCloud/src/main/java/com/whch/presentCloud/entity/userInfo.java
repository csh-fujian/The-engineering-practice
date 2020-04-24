package com.whch.presentCloud.entity;

import java.util.Date;

public class userInfo {
    private Integer id;

    private String number;

    private String password;

    private String name;

    private String nickname;

    private Date birthday;

    private Integer sex;

    private String school;

    private String department;

    private String role;

    private String phone;

    private String master;

    private Date creationdate;

    private Date modificationdate;

    private Integer creator;

    private Integer modifier;

    private byte[] image;

    

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(final String number) {
        this.number = number == null ? null : number.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(final String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(final Date birthday) {
        this.birthday = birthday;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(final Integer sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(final String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(final String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(final String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(final String master) {
        this.master = master == null ? null : master.trim();
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(final Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getModificationdate() {
        return modificationdate;
    }

    public void setModificationdate(final Date modificationdate) {
        this.modificationdate = modificationdate;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(final Integer creator) {
        this.creator = creator;
    }

    public Integer getModifier() {
        return modifier;
    }

    public void setModifier(final Integer modifier) {
        this.modifier = modifier;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(final byte[] image) {
        this.image = image;
    }

    public userInfo(String number,  String password, String name, String school, String department, String role,
            String phone) {
        this.number = number;
        this.password = password;
        this.name = name;
        this.school = school;
        this.department = department;
        this.role = role;
        this.phone = phone;
    }
}