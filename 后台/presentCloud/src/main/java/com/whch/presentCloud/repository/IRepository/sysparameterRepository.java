package com.whch.presentCloud.repository.IRepository;

import com.whch.presentCloud.entity.sysparameter;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface sysparameterRepository {

    public List<sysparameter> findAll();

    public int delete(String name);

    int updatesys(Integer value, String name, String record);
}
