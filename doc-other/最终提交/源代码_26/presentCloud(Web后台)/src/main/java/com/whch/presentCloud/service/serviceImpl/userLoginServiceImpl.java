package com.whch.presentCloud.service.serviceImpl;

import com.whch.presentCloud.entity.admin;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.entity.userInfo;
import com.whch.presentCloud.mapper.adminMapper;
import com.whch.presentCloud.repository.IRepository.userInfoRepository;
import com.whch.presentCloud.service.IService.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class userLoginServiceImpl implements IUserLoginService {

    @Autowired
    private userInfoRepository userInfoRepo;

    @Autowired
    private adminMapper adminM;

    //判断用户的角色
    @Override
    public int IsExistUser(String number, String password) {
        userInfo user1 = new userInfo();
        user1.setName(number);
        user1.setPassword(password);
        userInfo user = userInfoRepo.get(user1);
        if (user != null) {
            if(user.getRole() == "学生")
            {
                return 1;
            }
            else if(user.getRole() == "教师")
            {
                return 2;
            }
            else if(user.getRole() == "助教")
            {
                return 3;
            }
            else if(user.getRole() == "管理员")
            {
                return 4;
            }
            
        }
        return 0;
    }

    //添加用户
    @Override
    public int addUser(userInfo user) {

        return userInfoRepo.add(user);

    }

    //通过手机号查询用户是否存在，若存在返回含用户名和角色的res
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

    @Override
    public userInfo findbyphone(String phone)
    {
        userInfo user = userInfoRepo.get(phone);
        if(user != null){
            return user;
        }
        return null;
    }

    @Override
    public result regist(userInfo user) {
        result Registresult = new result();
        Registresult.setState("false");
        Registresult.setRole(null);
        try {
            userInfo existUser = userInfoRepo.get(user.getNumber(),user.getNickname());
            if(existUser != null){
                //如果用户名或学/工号已存在
                Registresult.setInfo("用户名或学/工号已存在");
            }else{
                userInfoRepo.add(user);
                Registresult.setInfo("注册成功");
                Registresult.setRole(user.getRole());
            }
        } catch (Exception e) {
            Registresult.setState(e.getMessage());
            e.printStackTrace();
        }
        return Registresult;
    }

    @Override
    public int setpw(userInfo user, String password) {
        user.setPassword(password);
        return userInfoRepo.update(user, user.getNumber());
    }


    @Override
    public userInfo login(String nickname, String password) {
        return userInfoRepo.login(nickname, password);
    }

    @Override
    public admin adminlogin(String name, String password) {
        return adminM.adminlogin(name, password);
    }

    @Override
    public admin admintoken(String name) {
        return adminM.admintoken(name);
    }
}