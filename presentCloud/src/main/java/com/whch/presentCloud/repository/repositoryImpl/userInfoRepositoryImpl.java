package com.whch.presentCloud.repository.repositoryImpl;

import java.util.List;

import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.mapper.userInfoMapper;
import com.whch.presentCloud.repository.IRepository.userInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class userInfoRepositoryImpl implements userInfoRepository {
    @Autowired
    private userInfoMapper userInfoM;

    @Override
    public userInfo get(String Number, String password) {

        return userInfoM.findOne(Number, password);
    }

    @Override
    public List<userInfo> getAll() {
       
        return userInfoM.getAll();
    }

    @Override
    public int add(userInfo UserInfo) {
        
        return userInfoM.insertSelective(UserInfo);
    }

    @Override
    public int update(userInfo UserInfo) {
       
        return userInfoM.updateByPrimaryKeySelective(UserInfo);
    }

    @Override
    public int delete(userInfo UserInfo) {
        return userInfoM.deleteByPrimaryKey(UserInfo.getId());
    }

}