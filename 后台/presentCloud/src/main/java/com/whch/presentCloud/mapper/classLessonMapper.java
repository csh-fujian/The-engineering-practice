package com.whch.presentCloud.mapper;

import java.util.Date;
import java.util.List;

import com.whch.presentCloud.entity.classLesson;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface classLessonMapper {
    int deleteByPrimaryKey(Integer classid);

    int insert(classLesson record);

    int insertSelective(classLesson record);

    classLesson selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(classLesson record);

    int updateByPrimaryKey(classLesson record);

    @Select("select * from classlesson where TeacherId = #{teacherId}")
	List<classLesson> find(@Param("teacherId") String teacherId);

    @Select("select * from classlesson where TeacherId = #{teacherId} and ClassId = #{classId}")
	classLesson findOne(@Param("teacherId") String teacherId,@Param("classId") Integer classId);

    @Select("select * from classlesson where type = #{studnetId}")
	List<classLesson> findBanke(@Param("studentId")String studentId);

    @Update("update classlesson set School = #{schoolName},CreatTime = #{creatTime} where ClassId = #{classId}")
	void updateClass(@Param("classId")Integer classid, @Param("schoolName")String schoolName,@Param("creatTime") Date createTime);
}