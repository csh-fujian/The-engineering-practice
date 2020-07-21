package com.whch.presentCloud.repository.IRepository;

import java.util.List;

import com.whch.presentCloud.entity.task;
import com.whch.presentCloud.entity.taskMemory;

public interface taskMemoryRepository {
    public List<taskMemory> getAll();
    public List<taskMemory> get(Integer studentId);
    public int add(taskMemory taskM);
    public int update(taskMemory taskM);
    public int delete(taskMemory taskM);
	public taskMemory getTask(String taskId,Integer studentId);
	public List<taskMemory> getMemoryByTaskId(String task);
}