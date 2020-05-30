package com.whch.presentCloud.service.IService;

import com.whch.presentCloud.entity.admin;

import java.util.List;

public interface IAdminService {
    public int addadmin(String name);
    public List<admin> find();
    public int delete(String name);
    public int update(String password, String name);
}
