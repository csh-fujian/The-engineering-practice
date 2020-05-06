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

    @Delete("DELETE t1,t2 FROM directorydata t1 LEFT JOIN dictionarytype t2 ON t1.typed = t2.typed where t1.typed = #{typed}")
    int delete(@Param("typed") String typed);

}