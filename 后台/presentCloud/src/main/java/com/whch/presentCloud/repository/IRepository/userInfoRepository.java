package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.userInfo;

public interface userInfoRepository {
    public userInfo get(String name);
    public List<userInfo> getAll();
    public int add(userInfo UserInfo);
    public int update(userInfo UserInfo);
    public int delete(userInfo UserInfo);
<<<<<<< HEAD:后台/presentCloud/src/main/java/com/whch/presentCloud/repository/IRepository/userInfoRepository.java
	public userInfo get(String phone);
=======
    public Integer login(userInfo user);
>>>>>>> 0236528e59ea8e265af16299a78997b50d35f252:presentCloud/src/main/java/com/whch/presentCloud/repository/IRepository/userInfoRepository.java
}