package com.whch.presentCloud.service.IService;

import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.entity.userInfo;




public interface IUserLoginService {
    public int IsExistUser(String number, String password);

	public int addUser(userInfo user);

	public Map<String,Object> IsExistUser(String phone);

	
}