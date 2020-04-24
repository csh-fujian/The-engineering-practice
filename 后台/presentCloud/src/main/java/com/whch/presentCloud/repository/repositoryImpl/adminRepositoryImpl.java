package com.whch.presentCloud.repository.repositoryImpl;

import java.util.List;

import com.whch.presentCloud.entity.admin;
import com.whch.presentCloud.mapper.adminMapper;
import com.whch.presentCloud.repository.IRepository.adminRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class adminRepositoryImpl implements adminRepository {
    @Autowired
    private adminMapper adminM;
    @Override
    public admin get(String number, String password) {
        
        return adminM.findOne(number,password);
    }

    @Override
    public List<admin> getAll() {
        return adminM.getAll();
    }

    @Override
    public int add(admin adm) {
        return adminM.insertSelective(adm);
    }

    @Override
    public int update(admin adm) {
        // TODO Auto-generated method stub
        return adminM.updateByPrimaryKeySelective(adm);
    }

    @Override
    public int delete(admin adm) {
        // TODO Auto-generated method stub
        return adminM.deleteByPrimaryKey(adm.getId());
    }

}