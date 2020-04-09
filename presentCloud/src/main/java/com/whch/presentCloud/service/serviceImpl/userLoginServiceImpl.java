package com.whch.presentCloud.service.serviceImpl;

import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.repository.IRepository.userInfoRepository;
import com.whch.presentCloud.service.IService.IUserLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userLoginServiceImpl implements IUserLoginService {

    @Autowired
    private userInfoRepository userInfoRepo;
    @Override
    public userInfo getUserInfo(String number, String password) {
       
        return userInfoRepo.get(number, password);
    }

}