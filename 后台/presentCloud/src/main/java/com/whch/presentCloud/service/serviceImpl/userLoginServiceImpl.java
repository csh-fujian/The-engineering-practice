package com.whch.presentCloud.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.result;
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
    public int IsExistUser(String number, String password) {
        userInfo user1 = new userInfo();
        user1.setName(number);
        user1.setPassword(password);
        userInfo user = userInfoRepo.get(user1);
        if (user != null) {
            if(user.getRole() == "教师")
            {
                return 2;
            }else if(user.getRole() == "学生")
            {
                return 1;
            }
            
        }
        return 0;
    }

    @Override
    public int addUser(userInfo user) {

        return userInfoRepo.add(user);

    }

    @Override
    public Map<String,Object> IsExistUser(String phone) {
        userInfo user = userInfoRepo.get(phone);
        
        if(user != null){
            HashMap res = new HashMap<String,Object>();
            res.put("username", user.getNumber());
            res.put("role", user.getRole());
            
            return res;
        }
        return null;
    }

   

}