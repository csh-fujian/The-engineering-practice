package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.classLesson;

public interface classLessonRepository {
    public classLesson get(String teacherId, Integer classId);
    public List<classLesson> get(String teacherId);
    public int add(classLesson lesson);
    public int update(classLesson lesson);
    public int delete(classLesson lesson);

}