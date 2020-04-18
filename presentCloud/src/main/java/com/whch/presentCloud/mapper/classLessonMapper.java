package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.classLesson;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface classLessonMapper {
    int deleteByPrimaryKey(Integer classid);

    int insert(classLesson record);

    int insertSelective(classLesson record);

    classLesson selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(classLesson record);

    int updateByPrimaryKey(classLesson record);

    @Select("select * from classlesson where TeachId = #{teacherId}")
	List<classLesson> find(@Param("teacherId") String teacherId);

    @Select("select * from classlesson where TeachId = #{teacherId} and ClassId = #{classId}")
	classLesson findOne(@Param("teacherId") String teacherId,@Param("classId") Integer classId);
}