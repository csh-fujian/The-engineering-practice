package com.whch.presentCloud.controller.web;

import com.whch.presentCloud.entity.*;
import com.whch.presentCloud.service.IService.IMenuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webmenu")
public class WebMenuController {

    @Autowired
    private IMenuManageService menuS;

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
    public int addmenu(@PathVariable String menuname)
    {
        System.out.println(menuname);
        return menuS.addmenu1(menuname);
    }

    @PostMapping("addpage")
    public int addpage(@RequestBody addpage Page1)
    {
        addpage p = Page1;
        System.out.println(p.getMenuname());
        System.out.println(p.getButtons());
        return menuS.addpage(Page1.getMenuname(), Page1.getSupermenu(), Page1.getButtons());
    }

    @PostMapping("addpage1")
    public int addpage1(@RequestBody addpage Page)
    {
        addpage p = Page;
        System.out.println(p.getMenuname());
        System.out.println(p.getButtons());
        return menuS.addpage1(Page.getMenuname(), Page.getSupermenu());
    }
    @PostMapping("addbutton")
    public int addbutton(@RequestBody addbutton button1)
    {
        System.out.println(button1);
        return menuS.addbutton(button1.getButton(), button1.getSupermenu());
    }

    @RequestMapping("deletemenu")
    public int deletemenu(@RequestBody addmenu delSel)
    {
        List<String> menus = delSel.getSubmenu();
        return menuS.deletemenu(menus);
    }

}
