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

    @Override
    public String findbykey(String keyd) {
        return dicM.findbykey(keyd);
    }

    @Override
    public int deletebykey(directoryData dicData) {
        return dicM.deletebykey(dicData.getKeyd());
    }

    @Override
    public List<directoryData> findbytype(directoryData dicData) {
        return dicM.findbytype(dicData.getTyped());
    }

    @Override
    public String finddefault(directoryData dicData) {
        return dicM.finddefault(dicData.getTyped());
    }

    @Override
    public int findbyvalue1(String valued, String keyd, String record) {
        dicM.updatebyvalue11(valued, keyd, record);
        dicM.updatebyvalue12(valued, keyd, record);
        return 1;
    }

    @Override
    public int findbyvalue2(String valued, String keyd, String record) {
        dicM.updatebyvalue21(valued, keyd, record);
        dicM.updatebyvalue22(valued, keyd, record);
        return 1;
    }

    @Override
    public int findbyvalue0(String valued, String keyd, String record) {
        return dicM.updatebyvalue0(valued, keyd, record);
    }


}