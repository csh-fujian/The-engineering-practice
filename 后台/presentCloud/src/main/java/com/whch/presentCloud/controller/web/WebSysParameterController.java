package com.whch.presentCloud.controller.web;

import com.whch.presentCloud.entity.sysparameter;
import com.whch.presentCloud.service.IService.ISysparameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("websysparameter")
public class WebSysParameterController {

    @Autowired
    private ISysparameterService syspara;

    @GetMapping("findAll")
    public List<sysparameter> findAll()
    {
        return syspara.findAll();
    }

    @RequestMapping("delete")
    public int delete(String name)
    {
        return syspara.delete(name);
    }
}
