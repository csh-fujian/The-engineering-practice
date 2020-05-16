package com.whch.presentCloud.service.IService;

import com.whch.presentCloud.entity.container;
import com.whch.presentCloud.entity.menu;

import java.util.List;

public interface IMenuManageService {

    public List<container> findAll();
    public container getChildList(List<menu> list, int pId, container c);
    public boolean ifChilds(List<menu> list,int pId);
    public int addmenu(String menuname, List<String> menus);
    public int addmenu1(String menuname);
    public int addpage(String menuname, String supermenu, List<String> buttons);
    public int addpage1(String menuname, String supermenu);
    public int addbutton(String button, String supermenu);
    public int deletemenu(List<String> menus);
}
