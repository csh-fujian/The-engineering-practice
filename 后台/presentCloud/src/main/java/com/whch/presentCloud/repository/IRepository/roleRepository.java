package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.github.pagehelper.Page;
import com.whch.presentCloud.entity.role;

public interface roleRepository {
    public List<role> get(String name);
    public List<role> getAll();
    public int add(role ro);
    public int update(role ro);
    public int delete(role ro);
}