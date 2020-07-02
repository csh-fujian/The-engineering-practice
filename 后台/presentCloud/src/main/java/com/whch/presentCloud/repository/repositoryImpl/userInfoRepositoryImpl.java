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
    public userInfo get(userInfo user) {

        return userInfoM.findOne(user.getPhone(), user.getPassword());
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
    public int update(userInfo UserInfo, String number) {
       
        return userInfoM.updateByPrimaryKeySelective(UserInfo, number);
    }

    @Override
    public int delete(userInfo UserInfo) {
        return userInfoM.deleteuser(UserInfo.getNumber());
    }

    @Override
    public userInfo get(String phone) {
        
        return userInfoM.getUser(phone);
    }

    @Override
    public userInfo get(String number, String nickname) {

        return userInfoM.getUser1(number,nickname);
    }

    public userInfo login(String number, String password){
        return userInfoM.findOne(number, password);
    }

    @Override
    public List<userInfo> multiquery(String number, String role, String school, String department) {
        return userInfoM.multiquery(number, role, school, department);
    }
}