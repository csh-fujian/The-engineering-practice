package com.whch.presentCloud.repository.repositoryImpl;

import java.util.List;

import com.whch.presentCloud.entity.userCheck;
import com.whch.presentCloud.mapper.userCheckMapper;
import com.whch.presentCloud.repository.IRepository.userCheckRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class userCheckRepositoryImpl implements userCheckRepository {
    @Autowired
    private userCheckMapper uCheckM;

    @Override
    public List<userCheck> get(Integer userId) {
        
        return uCheckM.findOne(userId);
    }


    @Override
    public int add(userCheck uCheck) {
       
        return uCheckM.insertSelective(uCheck);
    }

    @Override
    public int update(userCheck uCheck) {
        
        return uCheckM.updateByPrimaryKeySelective(uCheck);
    }

    @Override
    public int delete(userCheck uCheck) {
        
        return uCheckM.deleteByPrimaryKey(uCheck.getId());
    }
}