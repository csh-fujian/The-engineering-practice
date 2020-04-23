package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.userInfo;

public interface userInfoRepository {
    public userInfo get(String name);
    public List<userInfo> getAll();
    public int add(userInfo UserInfo);
    public int update(userInfo UserInfo);
    public int delete(userInfo UserInfo);
    public Integer login(userInfo user);
}