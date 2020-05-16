package com.whch.presentCloud.repository.repositoryImpl;

import com.whch.presentCloud.entity.sysparameter;
import com.whch.presentCloud.mapper.sysparameterMapper;
import com.whch.presentCloud.repository.IRepository.sysparameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class sysparameterRepositoryImple implements sysparameterRepository {

    @Autowired
    private sysparameterMapper sysM;

    @Override
    public List<sysparameter> findAll() {
        return sysM.findsysparameter();
    }

    @Override
    public int delete(String name) {
        return sysM.delete(name);
    }

    @Override
    public int updatesys(Integer value, String name, String record) {
        return sysM.updatesys(value, name, record);
    }
}
