package com.whch.presentCloud.controller.web;

import com.whch.presentCloud.entity.container;
import com.whch.presentCloud.entity.menu;
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
    public int addmenu(@RequestParam("menuname") String menuname, @RequestParam(value = "submenus[]") List<String> submenus)
    {
        return menuS.addmenu(menuname, submenus);
    }

    @PostMapping("addpage")
    public int addpage(@RequestParam("menuname") String menuname, @RequestParam("supermenu") String supermenu, @RequestParam(value = "button[]") List<String> buttons)
    {
        return menuS.addpage(menuname, supermenu, buttons);
    }

    @PostMapping("addbutton")
    public int addbutton(@RequestParam("button") String button, @RequestParam("supermenu") String supermenu)
    {
        return menuS.addbutton(button, supermenu);
    }

    @DeleteMapping("deletemenu")
    public int deletemenu(@RequestParam(value = "menus[]") List<String> menus)
    {
        return menuS.deletemenu(menus);
    }

}
