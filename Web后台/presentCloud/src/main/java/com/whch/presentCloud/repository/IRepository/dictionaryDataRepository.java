package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.directoryData;

public interface dictionaryDataRepository {
    public directoryData get(Integer Id);
    public List<directoryData> getAll();
    public int add(directoryData dicData);
    public int update(directoryData dicData);
    public int delete(directoryData dicData);
    public String findbykey(String keyd);
    public int deletebykey(directoryData dicData);
    public List<directoryData> findbytype(String typed);
    public String finddefault(directoryData dicData);
    public int findbyvalue1(String valued, String keyd, Integer defaultvalued, String record);
    public int findbyvalue2(String valued, String keyd, Integer defaultvalued, String record);
    public int findbyvalue0(String valued, String keyd, String record);
}