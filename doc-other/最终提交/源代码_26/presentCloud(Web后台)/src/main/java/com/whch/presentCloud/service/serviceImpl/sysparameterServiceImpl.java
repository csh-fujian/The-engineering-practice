package com.whch.presentCloud.service.serviceImpl;

import com.whch.presentCloud.entity.sysparameter;
import com.whch.presentCloud.repository.IRepository.sysparameterRepository;
import com.whch.presentCloud.service.IService.ISysparameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sysparameterServiceImpl implements ISysparameterService {

    @Autowired
    private sysparameterRepository sysR;

    @Override
    public List<sysparameter> findAll() {
        return sysR.findAll();
    }

    @Override
    public int delete(String name) {
        return sysR.delete(name);
    }

    @Override
    public int update(sysparameter sysp, sysparameter record) {
        return sysR.updatesys(sysp.getValue(), sysp.getName(), record.getName());
    }
}
