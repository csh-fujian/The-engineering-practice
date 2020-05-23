package com.whch.presentCloud.service.IService;

import com.whch.presentCloud.entity.sysparameter;

import java.util.List;

public interface ISysparameterService {

    public List<sysparameter> findAll();

    public int delete(String name);
}
