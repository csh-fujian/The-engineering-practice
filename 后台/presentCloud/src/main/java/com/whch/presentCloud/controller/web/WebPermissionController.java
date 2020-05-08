package com.whch.presentCloud.controller.web;

import com.whch.presentCloud.entity.container;
import com.whch.presentCloud.service.IService.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webpermission")
public class WebPermissionController {

    @Autowired
    private IPermissionService permS;

    @GetMapping("findAll")
    public List<container> findAll(@RequestParam String rolename)
    {
        return permS.findAll(rolename);
    }

    @PostMapping("addpermission")
    public int add(@RequestParam String role, @RequestParam(value = "menus[]") List<String> menus)
    {
        return permS.addpermission(role, menus);
    }
}
