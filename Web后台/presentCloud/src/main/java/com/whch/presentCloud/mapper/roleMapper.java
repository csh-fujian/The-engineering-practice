package com.whch.presentCloud.mapper;

import java.util.List;

import com.github.pagehelper.Page;
import com.whch.presentCloud.entity.role;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface roleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(role record);

    int insertSelective(role record);

    role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(role record);

    int updateByPrimaryKey(role record);

    @Select("select * from role where Name = #{name}")
	List<role> find(@Param("name") String name);

    @Select("select * from role")
	List<role> getAll();

    @Insert("insert into role(name) values (#{name})")
    int addrole(@Param("name") String name);

    @Delete("delete from role where name = #{name}")
    int deletebyname(@Param("name") String name);

    Page<role> findByPaging();
}