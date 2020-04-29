package com.whch.presentCloud.mapper;

import java.util.List;

import com.whch.presentCloud.entity.dictionaryType;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
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

    @Delete("delete * from directorydata d where d.typed = #{typed} union delete * from dictionarytype de where de.typed = #{typed}")
    int delete(@Param("typed") String typed);
}