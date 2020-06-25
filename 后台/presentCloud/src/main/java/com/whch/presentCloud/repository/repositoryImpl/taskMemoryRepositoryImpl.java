package com.whch.presentCloud.repository.repositoryImpl;

import java.util.List;

import com.whch.presentCloud.entity.taskMemory;
import com.whch.presentCloud.mapper.taskMemoryMapper;
import com.whch.presentCloud.repository.IRepository.taskMemoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class taskMemoryRepositoryImpl implements taskMemoryRepository {
    @Autowired
    private taskMemoryMapper taskM;
    @Override
    public List<taskMemory> getAll() {
        
        return taskM.getAll();
    }

    @Override
    public List<taskMemory> get(Integer studentId) {
        
        return taskM.get(studentId);
    }

    @Override
    public int add(taskMemory taskMem) {
        return taskM.insertSelective(taskMem);
    }

    @Override
    public int update(taskMemory taskMem) {
        return taskM.updateByPrimaryKeySelective(taskMem);
    }

    @Override
    public int delete(taskMemory taskMem) {
        return taskM.deleteByPrimaryKey(taskMem.getId());
    }

    @Override
    public taskMemory getTask(String task, Integer studentId) {
        
        return taskM.getTaskByClassId(studentId, task);
    }

    @Override
    public List<taskMemory> getMemoryByTaskId(String task) {
        return taskM.getMemoryByTaskId(task);
    }

}