package com.whch.presentCloud.repository.IRepository;

import com.whch.presentCloud.entity.sysparameter;

import java.util.List;

public interface sysparameterRepository {

    public List<sysparameter> findAll();

    public int delete(String name);
}
