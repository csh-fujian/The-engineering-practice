package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.signin;

public interface signinRepository {
    public signin get(Integer userId, Integer classId);
    public List<signin> get(Integer userId);
    // public List<signin> getAll();
    public int add(signin sign);
    public int update(signin sign);
    public int delete(signin sign);
}