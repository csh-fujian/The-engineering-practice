package com.whch.presentCloud.repository.repositoryImpl;

import java.util.List;

import com.whch.presentCloud.entity.directoryData;
import com.whch.presentCloud.mapper.directoryDataMapper;
import com.whch.presentCloud.repository.IRepository.dictionaryDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class dictionaryDataRepositoryImpl implements dictionaryDataRepository {
    @Autowired
    private directoryDataMapper dicM;
    @Override
    public directoryData get(Integer Id) {
        // TODO Auto-generated method stub
        return dicM.selectByPrimaryKey(Id);
    }

    @Override
    public List<directoryData> getAll() {
        // TODO Auto-generated method stub
        return dicM.getAll();
    }

    @Override
    public int add(directoryData dicData) {
        // TODO Auto-generated method stub
        return dicM.insertSelective(dicData);
    }

    @Override
    public int update(directoryData dicData) {
        // TODO Auto-generated method stub
        return dicM.updateByPrimaryKeySelective(dicData);
    }

    @Override
    public int delete(directoryData dicData) {
        // TODO Auto-generated method stub
        return dicM.deleteByPrimaryKey(dicData.getId());
    }

}