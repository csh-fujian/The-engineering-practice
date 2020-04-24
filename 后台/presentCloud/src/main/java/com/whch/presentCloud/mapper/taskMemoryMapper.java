package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.taskMemory;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface taskMemoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(taskMemory record);

    int insertSelective(taskMemory record);

    taskMemory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(taskMemory record);

    int updateByPrimaryKey(taskMemory record);

    @Select("select * from taskmeomory")
	List<taskMemory> getAll();
    @Select("select * from taskmeomory where StudentId =#{studentId}")
	List<taskMemory> get(@Param("studentId") Integer studentId);
}