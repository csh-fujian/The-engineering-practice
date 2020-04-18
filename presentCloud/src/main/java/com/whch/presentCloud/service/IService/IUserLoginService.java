package com.whch.presentCloud.service.IService;

import com.whch.presentCloud.entity.userInfo;




public interface IUserLoginService {
    public userInfo getUserInfo(String number, String password);
}