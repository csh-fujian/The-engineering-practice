package com.whch.presentCloud.service.IService;

import com.whch.presentCloud.entity.dictionaryType;

import java.util.List;

public interface IDictionaryTypeService {

    public int addtype(dictionaryType dictionary);

    public int delete(dictionaryType dictionary);

    public List<dictionaryType> findAll();
}
