package com.whch.presentCloud.controller.web;

import com.whch.presentCloud.entity.*;
import com.whch.presentCloud.service.IService.IMenuManageService;
import com.whch.presentCloud.service.IService.Isha256Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webmenu")
public class WebMenuController {

    @Autowired
    private IMenuManageService menuS;

    @Autowired
    private Isha256Service sha256S;

    @GetMapping("findAll")
    public List<container> findAll()
    {
        return menuS.findAll();
    }

    @PostMapping("addmenu")
    public int addmenu(@RequestBody addmenu Menu)
    {
        return menuS.addmenu(Menu.getMenuname(), Menu.getSubmenu());
    }

    @PostMapping("addmenu1/{menuname}")
    public String addmenu1(@PathVariable String menuname)
    {
        try{
            menuS.addmenu1(menuname);
            return "添加菜单成功";
        }catch (DataAccessException e){
            return "添加失败，菜单不能为空";
        }
    }

    @PostMapping("addpage")
    public int addpage(@RequestBody addpage Page1)
    {
        return menuS.addpage(Page1.getMenuname(), Page1.getSupermenu(), Page1.getButtons());
    }

    @PostMapping("addpage1")
    public String addpage1(@RequestBody addpage Page)
    {
        try{
            menuS.addpage1(Page.getMenuname(), Page.getSupermenu());
            return "添加菜单成功";
        }catch (DataAccessException e){
            return "添加失败，页面名称不能为空，或该上级菜单不存在";
        }
    }

    @PostMapping("addbutton")
    public String addbutton(@RequestBody addbutton button1)
    {
        try{
            menuS.addbutton(button1.getButton(), button1.getSupermenu());
            return "添加按钮成功";
        }catch (DataAccessException e){
            return "添加失败，按钮名称不能为空，或该上级页面不存在";
        }
    }

    @RequestMapping("deletemenu")
    public int deletemenu(@RequestBody addmenu delSel)
    {
        List<String> menus = delSel.getSubmenu();
        return menuS.deletemenu(menus);
    }

}
