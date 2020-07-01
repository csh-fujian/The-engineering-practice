package com.whch.presentCloud.service.IService;

import java.util.List;
import java.util.Map;

import com.whch.presentCloud.entity.LoginResult;
import com.whch.presentCloud.entity.ResponseData;
import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.entity.result;
import com.whch.presentCloud.entity.userInfo;




public interface IUserLoginService {
    public int IsExistUser(String number, String password);

	public int addUser(userInfo user);

	public result regist(userInfo user);

	public result phoneLoginResult(String phone,String remoteAddr);

	public userInfo findbyphone(String phone);

	public int setpw(userInfo user, String password);

	public userInfo login(String nickname, String password);

	public result loginResult(String number, String password);

	public List<Map<String,Object>> classsInfo(String number, int flag);

	public result userLoginResult(String number, String password, String remoteAddr);

	public ResponseData setPassword(String phone, String newPassWord);
}