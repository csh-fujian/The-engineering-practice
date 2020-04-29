package com.whch.presentCloud.service.IService;


import com.whch.presentCloud.entity.directoryData;

import java.util.List;

public interface IDictionaryDataService {

    public int adddata(directoryData dirtdata);
    public int deletebykey(directoryData dirtdata);
    public int updatadata(directoryData dirtdata);
    public String findbykey(String keyd);
    public List<directoryData> findbytype(directoryData dirtdata);
    public String finddefault(directoryData dirtdata);
    public int findbyvalue(directoryData dirtdata, directoryData record);
}
