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
    public String addmenu(@RequestBody addmenu Menu)
    {
        try{
            menuS.addmenu(Menu.getMenuname(), Menu.getSubmenu());
            return "添加菜单成功";
        }catch (DataAccessException e){
            return "添加失败，菜单名称不能为空";
        }
    }

    @PostMapping("addmenu1/{menuname}")
    public String addmenu1(@PathVariable String menuname)
    {
        if(menuname == null){
            return "添加失败，菜单名称不能为空";
        }
        try{
            menuS.addmenu1(menuname);
            return "添加菜单成功";
        }catch (DataAccessException e){
            return "添加失败，菜单名称不能为空";
        }
    }

    @PostMapping("addpage")
    public String addpage(@RequestBody addpage Page1)
    {
        try{
            menuS.addpage(Page1.getMenuname(), Page1.getSupermenu(), Page1.getButtons());
            return "添加页面成功";
        }catch (DataAccessException e){
            return "添加失败，该上级菜单不存在";
        }

    }

    @PostMapping("addpage1")
    public String addpage1(@RequestBody addpage Page)
    {
        if(Page.getMenuname() == null){
            return "添加失败，页面名称不能为空";
        }
        try{
            menuS.addpage1(Page.getMenuname(), Page.getSupermenu());
            return "添加页面成功";
        }catch (DataAccessException e){
            return "添加失败，该上级菜单不存在";
        }
    }

    @PostMapping("addbutton")
    public String addbutton(@RequestBody addbutton button1)
    {
        if(button1.getButton() == null){
            return "添加失败，页面名称不能为空";
        }
        try{
            menuS.addbutton(button1.getButton(), button1.getSupermenu());
            return "添加按钮成功";
        }catch (DataAccessException e){
            return "添加失败，该上级页面不存在";
        }
    }

    @RequestMapping("deletemenu")
    public int deletemenu(@RequestBody addmenu delSel)
    {
        List<String> menus = delSel.getSubmenu();
        return menuS.deletemenu(menus);
    }

}
