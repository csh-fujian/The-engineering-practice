package com.whch.presentCloud.controller.web;

import com.whch.presentCloud.entity.role;
import com.whch.presentCloud.entity.sysparameter;
import com.whch.presentCloud.entity.updatesys;
import com.whch.presentCloud.entity.updateuser;
import com.whch.presentCloud.service.IService.ISysparameterService;
import com.whch.presentCloud.service.IService.Isha256Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("websysparameter")
public class WebSysParameterController {

    @Autowired
    private ISysparameterService syspara;
    @Autowired
    private Isha256Service sha256S;

    @GetMapping("findAll")
    public List<sysparameter> findAll()
    {
        List<sysparameter> sys = syspara.findAll();
        int i = 0;
        for(sysparameter s : sys)
        {
            i++;
            s.setId(i);
        }
        return sys;
    }

    @RequestMapping("delete/{name}")
    public int delete(@PathVariable String name)
    {
        return syspara.delete(name);
    }

    @RequestMapping("update")
    public int update(@RequestBody updatesys editSys){
        return syspara.update(editSys.getSysp(), editSys.getRecord());
    }
}
