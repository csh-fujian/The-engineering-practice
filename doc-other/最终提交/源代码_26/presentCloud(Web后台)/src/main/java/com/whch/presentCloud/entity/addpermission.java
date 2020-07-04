package com.whch.presentCloud.entity;

import java.util.List;

public class addpermission {
    public String role;
    public List<String> selected;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getMenus() {
        return selected;
    }

    public void setMenus(List<String> menus) {
        this.selected = menus;
    }
}
