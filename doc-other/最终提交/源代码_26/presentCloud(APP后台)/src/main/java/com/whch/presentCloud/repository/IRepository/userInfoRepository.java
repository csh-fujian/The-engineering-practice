package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.userInfo;

public interface userInfoRepository {
    public userInfo get(userInfo UserInfo);
    public List<userInfo> getAll();
    public int add(userInfo UserInfo);
    public int update(userInfo user, String number);
    public int delete(userInfo UserInfo);
	public userInfo get(String phone);
    public userInfo get(String number, String nickname);
    public userInfo login(String nickname, String password);
    public List<userInfo> multiquery(String number, String role, String school, String department);
}