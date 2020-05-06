package com.whch.presentCloud.service.serviceImpl;

import com.whch.presentCloud.entity.dictionaryType;
import com.whch.presentCloud.repository.IRepository.dictionaryTypeRepository;
import com.whch.presentCloud.service.IService.IDictionaryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dictionaryTypeServiceImpl implements IDictionaryTypeService {

    @Autowired
    private dictionaryTypeRepository dicT;

    @Override
    public int addtype(dictionaryType dictionary) {
        return dicT.add(dictionary);
    }

    @Override
    public int delete(dictionaryType dictionary) {
        return dicT.delete(dictionary);
    }

    @Override
    public List<dictionaryType> findAll() {
        return dicT.getAll();
    }
}
