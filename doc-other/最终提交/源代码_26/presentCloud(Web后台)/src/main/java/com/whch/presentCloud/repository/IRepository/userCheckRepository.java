package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.userCheck;

public interface userCheckRepository {

    public List<userCheck> get(Integer userId);
    public int add(userCheck uCheck);
    public int update(userCheck uCheck);
    public int delete(userCheck uCheck);
}