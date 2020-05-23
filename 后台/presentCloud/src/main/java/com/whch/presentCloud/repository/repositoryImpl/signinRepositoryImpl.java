package com.whch.presentCloud.repository.repositoryImpl;

import java.util.List;

import com.whch.presentCloud.entity.signin;
import com.whch.presentCloud.mapper.signinMapper;
import com.whch.presentCloud.repository.IRepository.signinRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class signinRepositoryImpl implements signinRepository {
    @Autowired
    private signinMapper siginM;
    @Override
    public signin get(Integer userId, Integer classId) {
        // TODO Auto-generated method stub
        return siginM.findOne(userId,classId);
    }

    @Override
    public List<signin> get(Integer userId) {
        // TODO Auto-generated method stub
        return siginM.find(userId);
    }

    @Override
    public int add(signin sign) {
        // TODO Auto-generated method stub
        return siginM.insertSelective(sign);
    }

    @Override
    public int update(signin sign) {
        // TODO Auto-generated method stub
        return siginM.updateByPrimaryKeySelective(sign);
    }

    @Override
    public int delete(signin sign) {
        // TODO Auto-generated method stub
        return siginM.deleteByPrimaryKey(sign.getId());
    }

    @Override
    public signin get(String classId) {
        // TODO Auto-generated method stub
        return siginM.findByClassId(classId);
    }

}