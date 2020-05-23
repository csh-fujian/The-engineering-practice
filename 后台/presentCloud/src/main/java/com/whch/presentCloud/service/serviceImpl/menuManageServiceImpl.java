package com.whch.presentCloud.service.serviceImpl;

import com.whch.presentCloud.entity.container;
import com.whch.presentCloud.entity.menu;
import com.whch.presentCloud.entity.permission;
import com.whch.presentCloud.repository.IRepository.menuRepository;
import com.whch.presentCloud.repository.IRepository.permissionRepository;
import com.whch.presentCloud.service.IService.IMenuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class menuManageServiceImpl implements IMenuManageService {

    @Autowired
    private menuRepository menuR;

    @Autowired
    private permissionRepository permR;

    @Override
    public List<container> findAll() {

        List<menu> list1 = menuR.getAll();

        List<container> resultList = new ArrayList<>();

        for (menu m : list1) {
            if (m.getSuperiormenunumber() == 0) {//父级菜单开始添加
                container c = new container();
                c.setName(m.getMenuname());
                c.setState("unchecked");
                c.setLayer(m.getIsmenu());
                if (ifChilds(list1, m.getId())) {//存在子集
                    c = getChildList(list1, m.getId(), c);
                }
                resultList.add(c);
            }
        }
        return resultList;
    }


    //获取父id下的子集合
    public container getChildList(List<menu> list, int pId, container c) {

        List<container> sublist = new ArrayList<container>();

        for (menu m : list) {
            if (m.getSuperiormenunumber()==pId) {//查询下级菜单
                container co = new container();
                co.setName(m.getMenuname());
                co.setState("unchecked");
                co.setLayer(m.getIsmenu());
                if (ifChilds(list, m.getId())) {
                    co = getChildList(list, m.getId(), co);
                }
                sublist.add(co);
            }
        }
        c.setSub(sublist);

        return c;
    }

    //判断是否存在子集
    public boolean ifChilds(List<menu> list,int pId) {
        boolean flag = false;
        for (menu m : list) {
            if (m.getSuperiormenunumber()==pId) {
                flag=true;
                break;
            }
        }
        return flag;
    }

    /**
     * 添加一级菜单
     * @param menuname
     * @param menus
     * @return
     */
    @Override
    public int addmenu(String menuname, List<String> menus) {

        // 先将根菜单加入menu表，并取出其id
        menu m = new menu();
        m.setSuperiormenunumber(0);
        m.setMenuname(menuname);
        m.setIsmenu(1);
        menuR.add(m);
        Integer i = menuR.findmenuid(0, menuname);
        // 将二级菜单逐个加入menu表并将其父菜单设置为上面取出的id
        for (String submenu : menus){
            menu m1 = new menu();
            m1.setSuperiormenunumber(i);
            m1.setMenuname(submenu);
            m1.setIsmenu(2);
            menuR.add(m1);
        }

        // 先将根菜单加入permission表，并取出其id
        permission p = new permission();
        p.setSuperiormenunumber(0);
        p.setMenuname(menuname);
        p.setIsmenu(1);
        permR.add(p);
        Integer j = permR.findmenuid(0, menuname);
        // 将二级菜单逐个加入permission表并将其父菜单设置为上面取出的id
        for (String submenu : menus){
            permission p1 = new permission();
            p1.setSuperiormenunumber(j);
            p1.setMenuname(submenu);
            p1.setIsmenu(2);
            permR.add(p1);
        }
        return 1;
    }

    /**
     * 添加二级菜单
     * @param menuname
     * @param supermenu
     * @param buttons
     * @return
     */
    @Override
    public int addpage(String menuname, String supermenu, List<String> buttons) {

        // 先将二级菜单加入menu表，并取出其id
        menu m = new menu();
        m.setSuperiormenunumber(menuR.findmenuid(0, supermenu)); // 设置其父菜单为supermenu的id
        m.setMenuname(menuname);
        m.setIsmenu(2);
        menuR.add(m);
        Integer i = menuR.findmenuid(m.getSuperiormenunumber(), menuname);
        // 将按钮逐个加入menu表并将其父菜单设置为上面取出的id
        for (String subbutton : buttons){
            menu m1 = new menu();
            m1.setSuperiormenunumber(i);
            m1.setMenuname(subbutton);
            m1.setIsmenu(3);
            menuR.add(m1);
        }

        // 先将二级菜单加入permission表，并取出其id
        permission p = new permission();
        p.setSuperiormenunumber(permR.findmenuid(0, supermenu)); // 设置其父菜单为supermenu的id
        p.setMenuname(menuname);
        p.setIsmenu(2);
        permR.add(p);
        Integer j = permR.findmenuid(p.getSuperiormenunumber(), menuname);
        // 将按钮逐个加入permission表并将其父菜单设置为上面取出的id
        for (String subbutton : buttons){
            permission p1 = new permission();
            p1.setSuperiormenunumber(j);
            p1.setMenuname(subbutton);
            p1.setIsmenu(3);
            permR.add(p1);
        }
        return 1;
    }

    /**
     * 添加按钮
     * @param button
     * @param supermenu
     * @return
     */
    @Override
    public int addbutton(String button, String supermenu) {

        // 将按钮添加进menu表
        menu m = new menu();
        Integer i = menuR.findmenuid(2, supermenu);
        m.setSuperiormenunumber(i);
        m.setMenuname(button);
        m.setIsmenu(3);
        menuR.add(m);

        // 将按钮添加进permission表
        permission p = new permission();
        Integer j = permR.findmenuid(2, supermenu);
        p.setSuperiormenunumber(j);
        p.setMenuname(button);
        p.setIsmenu(3);
        permR.add(p);

        return 1;
    }

    @Override
    public int deletemenu(List<String> menus) {
        for (String m : menus)
        {
            menuR.deletemenu(m);
            permR.deletemenu(m);
        }
        return 1;
    }
}

