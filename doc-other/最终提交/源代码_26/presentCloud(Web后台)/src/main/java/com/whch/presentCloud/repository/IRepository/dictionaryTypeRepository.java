package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.dictionaryType;

public interface dictionaryTypeRepository {
    public dictionaryType get(Integer Id);
    public List<dictionaryType> getAll();
    public int add(dictionaryType dictionaryT);
    public int update(dictionaryType dictionaryT);
    public int delete(dictionaryType dictionaryT);
}