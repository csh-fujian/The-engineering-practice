package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.menu;

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
}