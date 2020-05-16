package com.whch.presentCloud.repository.repositoryImpl;

import java.util.List;

import com.whch.presentCloud.entity.dictionaryType;
import com.whch.presentCloud.mapper.dictionaryTypeMapper;
import com.whch.presentCloud.repository.IRepository.dictionaryTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class dictionaryTypeRepositoryImpl implements dictionaryTypeRepository {
    @Autowired
    private dictionaryTypeMapper dicM;
    @Override
    public dictionaryType get(Integer Id) {
        // TODO Auto-generated method stub
        return dicM.selectByPrimaryKey(Id);
    }

    @Override
    public List<dictionaryType> getAll() {
        // TODO Auto-generated method stub
        return dicM.getAll();
    }

    @Override
    public int add(dictionaryType dictionaryT) {
        // TODO Auto-generated method stub
        return dicM.insertSelective(dictionaryT);
    }

    @Override
    public int update(dictionaryType dictionaryT) {
        // TODO Auto-generated method stub
        return dicM.updateByPrimaryKeySelective(dictionaryT);
    }

    @Override
    public int delete(dictionaryType dictionaryT) {
        // TODO Auto-generated method stub
        dicM.delete(dictionaryT.getTyped());
        dicM.delete1(dictionaryT.getTyped());
        return 1;
    }

}