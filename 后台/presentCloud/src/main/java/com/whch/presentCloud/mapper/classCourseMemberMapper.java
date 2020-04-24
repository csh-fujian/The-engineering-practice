package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.classCourseMember;

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

    @Select("select * from ClassCourseMember where StudentId = #{studentId}")
	List<classCourseMember> get(@Param("studentId") String number);

    @Select("select * from ClassCourseMember where StudentId = #{studentId} and ClassId = #{classId}")
	classCourseMember getCourse(@Param("classId")String classId, @Param("studentId")String studentId);

    @Select("select * from ClassCourseMember where CtudentId = #{classId}")
	List<classCourseMember> getOneClassMembers(int classId);
}