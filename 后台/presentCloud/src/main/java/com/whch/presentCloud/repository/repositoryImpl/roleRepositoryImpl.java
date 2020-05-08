package com.whch.presentCloud.repository.repositoryImpl;

import java.util.List;

import com.github.pagehelper.Page;
import com.whch.presentCloud.entity.role;
import com.whch.presentCloud.mapper.roleMapper;
import com.whch.presentCloud.repository.IRepository.roleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class roleRepositoryImpl implements roleRepository {
    @Autowired
    private roleMapper roleM;
    @Override
    public List<role> get(String name) {
        // TODO Auto-generated method stub
        return roleM.find(name);
    }

    @Override
    public List<role> getAll() {
        // TODO Auto-generated method stub
        return roleM.getAll();
    }

    @Override
    public int add(role ro) {
        // TODO Auto-generated method stub
        return roleM.insertSelective(ro);
    }

    @Override
    public int update(role ro) {
        // TODO Auto-generated method stub
        return roleM.updateByPrimaryKeySelective(ro);
    }

    @Override
    public int delete(role ro) {
        // TODO Auto-generated method stub
        return roleM.deletebyname(ro.getName());
    }

}