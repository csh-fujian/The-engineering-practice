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
    public int addtype(@RequestBody dictionaryType diction)
    {
        dictionaryType dic = diction;
        System.out.println(dic.getTyped());
        return dictype.addtype(diction);
    }

    @RequestMapping("deletetype")
    public int deletetype(@RequestBody dictionaryType deleteDict)
    {
        return dictype.delete(deleteDict);
    }

    @GetMapping("findtype")
    public List<dictionaryType> findtype() { return dictype.findAll(); }

    @GetMapping("finddata/{typed}")
    public List<directoryData> finddata(@PathVariable String typed)
    {
        List<directoryData> directoryDatas = dicdata.findbytype(typed);
        int i = 0;
        for(directoryData d : directoryDatas)
        {
            i++;
            d.setId(i);
        }
        return directoryDatas;
    }

    @PostMapping("adddata")
    public int adddata(@RequestBody directoryData dicd)
    {
        return dicdata.adddata(dicd);
    }

    @RequestMapping("deletedata")
    public int delete(@RequestBody directoryData dicd)
    {
        return dicdata.deletebykey(dicd);
    }

    @RequestMapping("updatedata")
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
