package com.whch.presentCloud.service.IService;


import com.whch.presentCloud.entity.directoryData;

import java.util.List;

public interface IDictionaryDataService {

    public int adddata(directoryData dirtdata);
    public int deletebykey(directoryData dirtdata);
    public int updatadata(directoryData dirtdata);
    public String findbykey(String keyd);
    public List<directoryData> findbytype(String typed);
    public String finddefault(String typed);
    public List<String> findAllvalue(String typed);
    public int findbyvalue(directoryData dirtdata, directoryData record);
}
