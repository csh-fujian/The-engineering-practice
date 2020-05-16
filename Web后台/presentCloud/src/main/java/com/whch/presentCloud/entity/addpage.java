package com.whch.presentCloud.entity;

import java.util.List;

public class addpage {
    public String menuname;
    public String supermenu;
    public List<String> buttons;

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getSupermenu() {
        return supermenu;
    }

    public void setSupermenu(String supermenu) {
        this.supermenu = supermenu;
    }

    public List<String> getButtons() {
        return buttons;
    }

    public void setButtons(List<String> buttons) {
        this.buttons = buttons;
    }
}
