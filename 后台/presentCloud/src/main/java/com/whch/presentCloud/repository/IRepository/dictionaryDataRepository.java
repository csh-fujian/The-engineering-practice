package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.directoryData;

public interface dictionaryDataRepository {
    public directoryData get(Integer Id);
    public List<directoryData> getAll();
    public int add(directoryData dicData);
    public int update(directoryData dicData);
    public int delete(directoryData dicData);

}