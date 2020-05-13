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
    public int addtype(@RequestBody dictionaryType dict)
    {
        return dictype.addtype(dict);
    }

    @DeleteMapping("deletetype")
    public int deletetype(@RequestBody dictionaryType dict)
    {
        return dictype.delete(dict);
    }

    @GetMapping("findtype")
    public List<dictionaryType> findtype() { return dictype.findAll(); }

    @GetMapping("finddata")
    public List<directoryData> finddata(@RequestBody directoryData dicd)
    {
        return dicdata.findbytype(dicd);
    }

    @PostMapping("adddata")
    public int adddata(@RequestBody directoryData dicd)
    {
        return dicdata.adddata(dicd);
    }

    @DeleteMapping("deletedata")
    public int delete(@RequestBody directoryData dicd)
    {
        return dicdata.deletebykey(dicd);
    }

    @PutMapping("updatedata")
    public int updatedata(@RequestBody directoryData dicd,@RequestBody directoryData record)
    {
        return dicdata.findbyvalue(dicd, record);
    }

    @GetMapping("getdefault")
    public String getdefault(@RequestBody directoryData dicd)
    {
        return dicdata.finddefault(dicd);
    }
}
