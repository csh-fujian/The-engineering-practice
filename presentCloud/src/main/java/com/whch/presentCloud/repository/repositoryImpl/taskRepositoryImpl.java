package com.whch.presentCloud.repository.repositoryImpl;

import java.util.List;

import com.whch.presentCloud.entity.task;
import com.whch.presentCloud.mapper.taskMapper;
import com.whch.presentCloud.repository.IRepository.taskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class taskRepositoryImpl implements taskRepository {
    @Autowired
    private taskMapper taskM;
    @Override
    public task get(Integer userId, Integer classId) {
        return taskM.findOne(userId,classId);
    }

    @Override
    public List<task> get(Integer userId) {
        return taskM.find(userId);
    }

    // @Override
    // public List<task> getAll() {
    //     return taskM.;
    // }

    @Override
    public int add(task ta) {
        return taskM.insertSelective(ta);
    }

    @Override
    public int update(task ta) {
        return taskM.updateByPrimaryKeySelective(ta);
    }

    @Override
    public int delete(task ta) {
        return taskM.deleteByPrimaryKey(ta.getId());
    }

}