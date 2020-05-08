package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.menu;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface menuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(menu record);

    int insertSelective(menu record);

    menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(menu record);

    int updateByPrimaryKey(menu record);

    @Select("select * from menu")
	List<menu> getAll();

    @Select("select id from menu where SuperiorMenuNumber = #{superiormenunumber} and menuname = #{menuname}")
    int findmenuid(@Param("superiormenunumber") Integer superiormenunumber, @Param("menuname")  String menuname);

    @Delete("delete from menu where menuname = #{menuname}")
    int deletemenu(String menuname);
}