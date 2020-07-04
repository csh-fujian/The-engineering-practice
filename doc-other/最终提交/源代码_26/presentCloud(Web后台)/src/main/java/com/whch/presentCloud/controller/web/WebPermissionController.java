package com.whch.presentCloud.controller.web;

import com.whch.presentCloud.entity.addbutton;
import com.whch.presentCloud.entity.addpermission;
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

    @GetMapping("findAll/{rolename}")
    public List<container> findAll(@PathVariable String rolename)
    {
        return permS.findAll(rolename);
    }

    @PostMapping("addpermission")
    public int add(@RequestBody addpermission Permission)
    {
        return permS.addpermission(Permission.getRole(), Permission.getMenus());
    }
}
