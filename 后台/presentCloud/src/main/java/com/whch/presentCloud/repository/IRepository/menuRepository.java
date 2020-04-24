package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.menu;

public interface menuRepository {
    public menu get(Integer id);
    public List<menu> getAll();
    public int add(menu men);
    public int update(menu men);
    public int delete(menu men);
}