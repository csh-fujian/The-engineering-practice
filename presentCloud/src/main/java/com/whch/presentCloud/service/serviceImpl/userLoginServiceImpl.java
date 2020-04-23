package com.whch.presentCloud.service.serviceImpl;

import com.whch.presentCloud.entity.LoginResult;
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
    public LoginResult regist(userInfo user) {
        LoginResult result = new LoginResult();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            userInfo existUser = userInfoRepo.get(user.getName());
            if(existUser != null){
                //如果用户名已存在
                result.setMsg("用户名已存在");

            }else{
                userInfoRepo.add(user);
                //System.out.println(user.getId());
                result.setMsg("注册成功");
                result.setSuccess(true);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 登录
     * @param user 用户名和密码
     * @return Result
     */
    @Override
    public LoginResult login(userInfo user) {
        LoginResult result = new LoginResult();
        result.setSuccess(false);
        result.setDetail(null);
        try {
            Integer userId= userInfoRepo.login(user);
            if(userId == null){
                result.setMsg("用户名或密码错误");
            }else{
                result.setMsg("登录成功");
                result.setSuccess(true);
                user.setId(userId);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
