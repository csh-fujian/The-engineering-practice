package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.task;

public interface taskRepository {
    public task get(Integer userId, Integer classId);
    public List<task> get(Integer userId);
    // public List<task> getAll();
    public int add(task ta);
    public int update(task ta);
    public int delete(task ta);
}