package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.dictionaryType;

import org.apache.ibatis.annotations.Select;

public interface dictionaryTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(dictionaryType record);

    int insertSelective(dictionaryType record);

    dictionaryType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(dictionaryType record);

    int updateByPrimaryKey(dictionaryType record);

    @Select("select * from dictionarytype")
	List<dictionaryType> getAll();
}