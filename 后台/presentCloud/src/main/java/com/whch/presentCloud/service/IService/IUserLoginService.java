package com.whch.presentCloud.service.IService;

import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.LoginResult;
import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.entity.userInfo;




public interface IUserLoginService {
    public int IsExistUser(String number, String password);

	public int addUser(userInfo user);

	public result regist(userInfo user);

	public Map<String,Object> IsExistUser(String phone);

	public userInfo findbyphone(String phone);

	public int setpw(userInfo user, String password);

	
}