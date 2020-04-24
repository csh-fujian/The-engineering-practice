package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.admin;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface adminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(admin record);

    int insertSelective(admin record);

    admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(admin record);

    int updateByPrimaryKey(admin record);

	@Select("select * from admin where Account = #{number} and Password = #{password}")
	admin findOne(@Param("number") String number, @Param("password") String password);

    @Select("select * from admin")
    List<admin> getAll();
}