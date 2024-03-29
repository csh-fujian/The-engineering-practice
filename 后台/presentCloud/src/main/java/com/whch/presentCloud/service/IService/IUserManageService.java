package com.whch.presentCloud.service.IService;

import com.github.pagehelper.Page;
import com.whch.presentCloud.entity.userInfo;

import java.util.List;
import java.util.Map;

public interface IUserManageService {

    public List<userInfo> getAllUser();

    public userInfo    getUser(String username);

    public String addUser(userInfo user);

    public int delete(userInfo user);

    public String updatebyid(userInfo user, String number);

    public Page<userInfo> findByPaging(Integer pageNum, Integer pageSize);

    public List<userInfo> multiquery(String number, String role, String school, String department);

	public Map<String, Object> getUserInfo(String username);
}
