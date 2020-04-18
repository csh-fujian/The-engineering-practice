package com.whch.presentCloud.repository.repositoryImpl;

import java.util.List;

import com.whch.presentCloud.entity.classLesson;
import com.whch.presentCloud.mapper.classLessonMapper;
import com.whch.presentCloud.repository.IRepository.classLessonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class classLessonRepositoryImpl implements classLessonRepository {
    @Autowired
    private classLessonMapper lessonM;
    @Override
    public classLesson get(String teacherId, Integer classId) {
        // TODO Auto-generated method stub
        return lessonM.findOne(teacherId,classId);
    }

    @Override
    public List<classLesson> get(String teacherId) {
        // TODO Auto-generated method stub
        return lessonM.find(teacherId);
    }

    @Override
    public int add(classLesson lesson) {
        // TODO Auto-generated method stub
        return lessonM.insertSelective(lesson);
    }

    @Override
    public int update(classLesson lesson) {
        // TODO Auto-generated method stub
        return lessonM.updateByPrimaryKeySelective(lesson);
    }

    @Override
    public int delete(classLesson lesson) {
        // TODO Auto-generated method stub
        return lessonM.deleteByPrimaryKey(lesson.getClassid());
    }

}