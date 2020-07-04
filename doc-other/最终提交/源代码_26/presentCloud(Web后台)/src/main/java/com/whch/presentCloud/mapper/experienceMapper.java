package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.experience;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface experienceMapper {
    int deleteByPrimaryKey(String studentid);

    int insert(experience record);

    int insertSelective(experience record);

    experience selectByPrimaryKey(String studentid);

    int updateByPrimaryKeySelective(experience record);

    int updateByPrimaryKey(experience record);

    @Select("select * from experience where StudentId=#{studentId} and ClassId=#{classId}")
	experience findOne(@Param("studentId") String studentId, @Param("classId") Integer classId);

    @Select("select * from experience")
	List<experience> getAll();

}