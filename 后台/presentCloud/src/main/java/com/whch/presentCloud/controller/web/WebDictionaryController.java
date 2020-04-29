package com.whch.presentCloud.controller.web;

import com.whch.presentCloud.entity.dictionaryType;
import com.whch.presentCloud.entity.directoryData;
import com.whch.presentCloud.service.IService.IDictionaryDataService;
import com.whch.presentCloud.service.IService.IDictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("webdictionary")
public class WebDictionaryController {

    @Autowired
    private IDictionaryTypeService dictype;

    @Autowired
    private IDictionaryDataService dicdata;

    @PostMapping("addtype")
    public int addtype(dictionaryType dict)
    {
        return dictype.addtype(dict);
    }

    @DeleteMapping("deletetype")
    public int deletetype(dictionaryType dict)
    {
        return dictype.delete(dict);
    }

    @RequestMapping("finddata")
    public List<directoryData> finddata(directoryData dicd)
    {
        return dicdata.findbytype(dicd);
    }

    @PostMapping("adddata")
    public int adddata(directoryData dicd)
    {
        return dicdata.adddata(dicd);
    }

    @DeleteMapping("deletedata")
    public int delete(directoryData dicd)
    {
        return dicdata.deletebykey(dicd);
    }

    @RequestMapping("updatedata")
    public int updatedata(directoryData dicd, directoryData record)
    {
        return dicdata.findbyvalue(dicd, record);
    }

    @GetMapping("getdefault")
    public String getdefault(directoryData dicd)
    {
        return dicdata.finddefault(dicd);
    }
}
