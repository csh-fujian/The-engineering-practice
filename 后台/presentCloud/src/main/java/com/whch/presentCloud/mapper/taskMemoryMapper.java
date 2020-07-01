package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.taskMemory;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface taskMemoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(taskMemory record);

    int insertSelective(taskMemory record);

    taskMemory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(@Param("record") taskMemory record,@Param("studentId")Integer studentId,@Param("taskId")String taskId);

    int updateByPrimaryKey(taskMemory record);

    @Select("select * from taskmemory")
	List<taskMemory> getAll();
    @Select("select * from taskmemory where StudentId =#{studentId}")
	List<taskMemory> get(@Param("studentId") Integer studentId);

    @Select("select * from taskmemory where StudentId =#{studentId} and Task = #{task}")
	taskMemory getTaskByClassId(@Param("studentId") Integer studentId,@Param("task") String task);
    @Select("select * from taskmemory where  Task = #{task}")
	List<taskMemory> getMemoryByTaskId(@Param("task") String task);
}