package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.classCourseMember;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
@Component
public interface classCourseMemberMapper {
    int deleteByPrimaryKey(Integer classid);

    int insert(classCourseMember record);

    int insertSelective(classCourseMember record);

    classCourseMember selectByPrimaryKey(Integer classid);

    int updateByPrimaryKeySelective(classCourseMember record);

    int updateByPrimaryKey(classCourseMember record);

    //找出一个学生的所有课程
    @Select("select * from ClassCourseMember where StudentId = #{studentId}")
	List<classCourseMember> get(@Param("studentId") String number);

    @Select("select * from ClassCourseMember where StudentId = #{studentId} and ClassId = #{classId}")
	classCourseMember getCourse(@Param("classId")String classId, @Param("studentId")String studentId);

    @Select("select * from ClassCourseMember where ClassId = #{classId}")
	List<classCourseMember> getOneClassMembers(@Param("classId")int classId);

    @Delete("delete from ClassCourseMember where ClassId = #{classId} and StudentId = #{username}")
	boolean delete(@Param("username")String  username, @Param("classId")int classId);
}