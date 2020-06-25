package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.task;
import com.whch.presentCloud.entity.taskMemory;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface taskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(task record);

    int insertSelective(task record);

    task selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(task record);

    int updateByPrimaryKey(task record);

    @Select("select * from task where UserId=#{userId} and ClassId=#{classId}")
	task findOne(@Param("userId") Integer userId, @Param("classId") Integer classId);

    @Select("select * from task where UserId=#{userId}")
	List<task> find(@Param("userId") Integer userId);

    @Select("select * from task where  ClassId=#{classId}")
	List<task> getTask(Integer classid);
}