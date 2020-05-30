package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.admin;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

@Component
public interface adminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(admin record);

    int insertSelective(admin record);

    admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(admin record);

    int updateByPrimaryKey(admin record);

	@Select("select * from admin where Account = #{number} and Password = #{password}")
	admin findOne(@Param("number") String number, @Param("password") String password);

	@Select("select * from admin where Name = #{name} and Password = #{password}")
	admin adminlogin(@Param("name") String name, @Param("password") String password);

    @Select("select * from admin where Name = #{name}")
    admin admintoken(@Param("name") String name);

    @Select("select * from admin")
    List<admin> getAll();

    @Select("select * from admin where Account = #{layer}")
    List<admin> findAll(@Param("layer") String layer);

    @Delete("delete from admin where Name = #{name}")
    int deleteadmin(@Param("name") String name);

    @Update("update admin a set a.Password = #{password} where a.Name = #{name}")
    int updateadmin(@Param("password") String password, @Param("name") String name);
}