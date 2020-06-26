package com.whch.presentCloud.controller.web;

import com.whch.presentCloud.entity.container2;
import com.whch.presentCloud.entity.dictionaryType;
import com.whch.presentCloud.entity.directoryData;
import com.whch.presentCloud.entity.updatedata;
import com.whch.presentCloud.service.IService.IDictionaryDataService;
import com.whch.presentCloud.service.IService.IDictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        return dictype.addtype(diction);
    }

    @RequestMapping("deletetype")
    public int deletetype(@RequestBody dictionaryType deleteDict)
    {
        return dictype.delete(deleteDict);
    }

    @GetMapping("findtype")
    public List<dictionaryType> findtype()
    {
        List<dictionaryType> dict = dictype.findAll();
        int i = 0;
        for(dictionaryType d : dict)
        {
            i++;
            d.setId(i);
        }
        return dict;
    }

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
    public int updatedata(@RequestBody updatedata Data)
    {
        return dicdata.findbyvalue(Data.getDicd(), Data.getRecord());
    }

    @GetMapping("getdefault/{typed}")
    public String getdefault(@PathVariable String typed)
    {
        return dicdata.finddefault(typed);
    }



    @GetMapping("findAllvalued/{typed}")
    public List<String> findAll(@PathVariable String typed) { return dicdata.findAllvalue(typed); }

    @GetMapping("findAllvalued2/{typed}")
    public List<container2> findAll2(@PathVariable String typed)
    {
        List<String> list1 = dicdata.findAllvalue(typed);
        List<container2> cont2 = new ArrayList<>();
        for (String l : list1){
            container2 c = new container2();
            c.setLabel(l);
            c.setValue(l);
            cont2.add(c);
        }
        return cont2;
    }
}
