package com.whch.presentCloud.service.IService;

import com.whch.presentCloud.entity.LoginResult;
import com.whch.presentCloud.entity.userInfo;




public interface IUserLoginService {
    public LoginResult regist(userInfo user);
    public LoginResult login(userInfo user);
}