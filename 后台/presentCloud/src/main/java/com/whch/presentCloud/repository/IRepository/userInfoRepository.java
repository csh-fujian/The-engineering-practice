package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.userInfo;

public interface userInfoRepository {
    public userInfo get(userInfo UserInfo);
    public List<userInfo> getAll();
    public int add(userInfo UserInfo);
    public int update(userInfo UserInfo);
    public int delete(userInfo UserInfo);
	public userInfo get(String phone);
    public Integer login(userInfo user);
}