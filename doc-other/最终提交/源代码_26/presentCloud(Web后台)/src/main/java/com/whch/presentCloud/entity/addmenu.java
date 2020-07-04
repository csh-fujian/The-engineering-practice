package com.whch.presentCloud.entity;

import java.util.List;

public class addmenu {
    public String menuname;
    public List<String> submenus;

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public List<String> getSubmenu() {
        return submenus;
    }

    public void setSubmenu(List<String> submenus) {
        this.submenus = submenus;
    }
}
