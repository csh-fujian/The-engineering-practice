package com.whch.presentCloud.mapper;

import java.util.Date;
import java.util.List;

import com.whch.presentCloud.entity.signin;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
@Component
public interface signinMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(signin record);

    int insertSelective(signin record);

    signin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(signin record);

    int updateByPrimaryKey(signin record);

    @Select("select * from signin where UserId = #{userId} and ClassId = #{classId}")
	signin findOne(@Param("userId") Integer userId,@Param("classId") Integer classId);

    @Select("select * from signin where UserId = #{userId}")


	List<signin> findByUserId(@Param("userId") Integer userId);

    @Select("select * from signin where ClassId = #{classId} order by StartTime desc")
	List<signin> findByClassId(@Param("classId")int classId);
    @Select("select * from signin where ClassId = #{classId}")
	List<signin> findById(@Param("classId")int classId);
    @Select("select * from signin where ClassId = #{classId} and StartTime = #{now}")
	signin find(@Param("classId")int classId,@Param("now") Date now);
}