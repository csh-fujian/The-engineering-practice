package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.classLesson;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface classLessonMapper {
    int deleteByPrimaryKey(Integer classid);

    int insert(classLesson record);

    int insertSelective(classLesson record);

    classLesson selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(classLesson record);

    int updateByPrimaryKey(classLesson record);

    @Select("select * from classlesson where TeacherName = #{teachername}")
	List<classLesson> find(@Param("teachername") String teachername);

    @Select("select * from classlesson where TeachId = #{teacherId} and ClassId = #{classId}")
	classLesson findOne(@Param("teacherId") String teacherId,@Param("classId") Integer classId);

    @Select("select * from classlesson where type = #{studnetId}")
	List<classLesson> findBanke(@Param("studentId")String studentId);

    @Update("update classlesson c set c.TeacherName = #{teachername} where c.TeacherName = #{oldteachername}")
    void setname(@Param("teachername")String teachername, @Param("oldteachername")String oldteachername);

    @Select("select * from classlesson")
    List<classLesson> findAll();
}