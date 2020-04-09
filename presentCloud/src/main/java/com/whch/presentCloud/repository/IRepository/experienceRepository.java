package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.experience;

public interface experienceRepository {
    public experience get(String studentId, Integer classId);
    public List<experience> getAll();
    public int add(experience exper);
    public int update(experience exper);
    public int delete(experience exper);
}